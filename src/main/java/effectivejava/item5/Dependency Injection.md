많은 클래스는 하나 이상의 자원에 의존한다. 

유틸리티 클래스로 구현
~~~java
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpellChecker {
    private static final Lexicon dictionary  = ...;

    public static boolean isValid(String word) { ... }

    public static List<String> suggertions(String typo) { ... }
}
~~~

싱글턴으로 구현

~~~java
public class SpellChecker {
  private final Lexicon dictionary = ...;
  
  private SpellChecker(...) {}
  public static INSTANCE = new SpellChecker(...);
  
  public boolean isValid(String word) { ... }
  public List<String> suggestions(String typo) { ... } 
}
~~~

하지만 하나의 dictionary로 모든 쓰임에 대응하는것은 멍청한짓.

setter를 사용한 방식.

~~~java
public class SpellChecker {
  private Lexicon dictionary;
  
  public boolean isValid(String word) { ... }
  public List<String> suggestions(String typo) { ... } 

  public void setDictionary(Lexicon dictionary) {
      this.dictionary = dictionary;
  }
~~~

setter를 사용한 방법은 오류를 내기 쉬우며 멀티스레드 환경에서 쓸 수 없다. 

사용하는 자원에 따라 동작이 달라지는 클래스에는 정적 유틸리티 클래스나 싱글턴 방식이 적합하지 않다. 

클래스가 여러 자원 인스턴스를 지원해야 하며, 클라이언트가 원하는 자원을 사용해야 한다. 

인스턴스를 생성할 때 생성자에 필요한 자원을 넘겨주는 방법을 이용하면 된다. 

~~~java
public class SpellChecker {
  private Lexicon dictionary;
  
  public SpellChecker(Lexicon dictionary) {
      this.dictionary = Objects.requireNonNull(dictionary);
  }

  public boolean isValid(String word) { ... }
  public List<String> suggestions(String typo) { ... } 
}
~~~

DI 패턴은 불변을 보장하여 여러 클라이언트가 의존 객체들을 안심하고 공유할 수 있기도 하다. 또한, 생성자, 정적팩터리, 빌더에 똑같이 응용할 수 있다. 

~~~java
public class SpellChecker {
    private final Lexicon dictionary;

    private SpellChecker(Lexicon dictionary) {
        this.dictionary = dictionary;
    }

    public static SpellChecker of(Lexicon lexicon) {
        return new SpellChecker(lexicon);
    }

    ...
}
~~~

~~~java
SpellChecker spellChecker = SpellChecker.builder()
                              .dictionary(new Lexicon())
                              .build();
~~~

변형으로는 생성자에 자원 팩터리를 넘겨주는 것.
이때, 한정적 와일드카드 타입을 통해 Supplier 타입을 제한해야 한다.

~~~java
public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Supplier<? extends Lexicon> dictionaryFactory) {
        this.dictionary = dictionaryFactory.get();
    }
}
~~~