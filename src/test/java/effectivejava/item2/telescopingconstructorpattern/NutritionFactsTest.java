package effectivejava.item2.telescopingconstructorpattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NutritionFactsTest {

    @DisplayName("점층적 생성자 패턴")
    @Test
    void create() {
        NutritionFacts nutritionFacts = new NutritionFacts(1,1);
        assertThat(nutritionFacts.getCalories()).isNull();
    }
}