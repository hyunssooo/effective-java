package effectivejava.item2.buliderpatten;

import org.junit.jupiter.api.Test;

class NutritionFactsTest {

    @Test
    void create() {
        NutritionFacts nutritionFacts = NutritionFacts.builder(10, 20)
                .sodium(1)
                .calories(10)
                .build();
    }
}