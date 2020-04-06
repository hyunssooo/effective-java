package effectivejava.item2.javabeenspattern;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NutritionFactsTest {

    @Test
    void create() {
        NutritionFacts nutritionFacts = new NutritionFacts();
        nutritionFacts.setServingSize(10);
        assertThat(nutritionFacts.getServingSize()).isEqualTo(10);

        nutritionFacts.setServingSize(100);
        assertThat(nutritionFacts.getServingSize()).isEqualTo(100);
    }
}