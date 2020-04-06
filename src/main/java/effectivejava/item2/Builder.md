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

#Builder