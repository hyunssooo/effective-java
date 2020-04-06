package effectivejava.item2.buliderpatten;

import org.junit.jupiter.api.Test;

class NutritionFactsTest {

    @Test
    void create() {
        NutritionFacts builder = NutritionFacts.builder().build();
    }
}