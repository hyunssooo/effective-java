# Builder
선택적 매개변수가 많을때 생성자와 static factory method는 적절히 대응이 힘들다. 

## 점층적 생성자 패턴
```java
public class NutritionFacts {
  private final int servingSize;
  private final int serving;
  private final int calories;
  private final int fat;
  private final int sodium;
  private final int carbohydrate;

  public NutritionFacts(int servingSize, int serving) {
    this(servingSize, serving, 0);
  }

  public NutritionFacts(int servingSize, int serving, int calories) {
    this(servingSize, serving, calories, 0);
  }

  public NutritionFacts(int servingSize, int serving, int calories, int fat) {
    this(servingSize, serving, calories, fat, 0);
  }

  public NutritionFacts(int servingSize, int serving, int calories, int fat, int sodium) {
    this(servingSize, serving, calories, fat, sodium, 0);
  }

  public NutritionFacts(int servingSize, int serving, int calories, int fat, int sodium, int carbohydrate) {
    this.servingSize = servingSize;
    this.serving = serving;
    this.calories = calories;
    this.fat = fat;
    this.sodium = sodium;
    this.carbohydrate = carbohydrate;
  }
}
```

해당 클래스의 인스턴스를 만드려면 원하는 매개변수를 모두 포함한 생성자 중 가장 짧은 것을 골라 호출하면 된다.  
보통 이런 생성자는 사용자가 설정하기 원치 않는 매개변수까지 포함하기 쉬운데, 어쩔수 없이 원하지 않는 매개변수에도 값을 지정해줘야 한다.  
```점칭적 생성자 패턴도 쓸 수는 있지만, 매개변수 개수가 많이지면 클라이언트 코드를 작성하거나 읽기 어렵다.```

## JavaBeans pattern
```java
@Getter
@Setter
public class NutritionFacts {
    private int servingSize = -1;
    private int serving = -1;
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;
}
```

자바빈즈의 심각한 단점은 setter를 통해서 매개변수에 값을 지정하기 때문에 클래스를 불변으로 만들지 못한다.

```java
@Test
void create() {
  NutritionFacts nutritionFacts = new NutritionFacts();
  nutritionFacts.setServingSize(10);
  assertThat(nutritionFacts.getServingSize()).isEqualTo(10);

  nutritionFacts.setServingSize(100);
  assertThat(nutritionFacts.getServingSize()).isEqualTo(100);
}
```

## Builder

필요한 객체를 직접 만드는 대신, 생성자(혹은 정적 팩터리)를 호출해 빌더 객체를 얻는다.  
다음 빌더 객체가 제공하는 일종의 setter 메서드들로 원하는 매개변수들을 설정한다.  
빌더 객체가 제공하는 매개변수가 없는 build()를 호출해 필요한 객체를 얻는다.  
빌더는 생성할 클래스 안에 정적 멤버 클래스로 만들어두는게 보통이다.  

```java
public class NutritionFacts {
  private final int servingSize;
  private final int serving;
  private final int calories;
  private final int fat;
  private final int sodium;
  private final int carbohydrate;

  public static class Builder {
    private final int servingSize;
    private final int serving;

    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public Builder(int servingSize, int serving) {
      this.servingSize = servingSize;
      this.serving = serving;
    }

    public Builder calories(int calories) {
      this.calories = calories;
      return this;
    }

    public Builder fat(int fat) {
      this.fat = fat;
      return this;
    }

    public Builder sodium(int sodium) {
      this.sodium = sodium;
      return this;
    }

    public Builder carbohydrate(int carbohydrate) {
      this.carbohydrate = carbohydrate;
      return this;
    }

    public NutritionFacts Build() {
      return new NutritionFacts(this);
    }
  }

  private NutritionFacts(Builder builder) {
    this.servingSize = builder.servingSize;
    this.serving = builder.serving;
    this.calories = builder.calories;
    this.fat = builder.fat;
    this.sodium = builder.sodium;
    this.carbohydrate = builder.carbohydrate;
  }
}
```

빌더의 setter()들은 빌더 자신을 반환하기 때문에 연쇄적으로 호출할 수 있다.  

```java
NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                                            .calories(100)
                                            .sodium(35)
                                            .carbohydrate(27)
                                            .Build();
```

잘못된 매개변수를 최대한 일찍 발견하려면 빌더의 생성자와 메서드에서 입력변수에 대한 검사를 하자.  

빌더 패턴은 계층적으로 설계된 클래스와 함께 쓰기에 좋다.  
추상 클래스는 추상 빌더를, 구체 클래스는 구체 빌더를 갖게 한다.

### lombok에서의 builder 
lombok은 정적 팩터리로 빌더객체를 호출한다. 

```java
NutritionFacts cocaCola = NutritionFacts.Builder(240, 8)
                                            .calories(100)
                                            .sodium(35)
                                            .carbohydrate(27)
                                            .Build();
```

#### @Builder.Default, @Singular

@Builder 어노테이션과 함께 많이 쓰인다.

```java
@Builder
@Getter
public class User {
  private String name = "1";
}

@Test
void create() {
  User user = User.builder().build();
  assertThat(user.getName()).isNull();
}
```

```java
@Builder
@Getter
public class User {
  @Builder.Default
  private String name = "1";
}

@Test
void create() {
  User user = User.builder().build();
  assertThat(user.getName()).isEqualTo("1");
}
```



```java
@Builder
@Getter
public class Lotto {
  @Singular private List<Long> nums;
}

@Test
void create() {
  Lotto lotto = Lotto.builder()
          .num(1L)
          .nums(List.of(2L, 3L, 4L))
          .build();

  assertThat(lotto.getNums()).isEqualTo(List.of(1L, 2L, 3L, 4L));
}
```