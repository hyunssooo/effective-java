package effectivejava.item2.buliderpatten;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NutritionFacts {
    private final int servingSize;
    private final int serving;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

//    public static Builder builder(int servingSize, int serving) {
//        return new Builder(servingSize, serving);
//    }
//
//    public static class Builder {
//        private final int servingSize;
//        private final int serving;
//        private int calories = 0;
//        private int fat = 0;
//        private int sodium = 0;
//        private int carbohydrate = 0;
//
//        private Builder(int servingSize, int serving) {
//            this.servingSize = servingSize;
//            this.serving = serving;
//        }
//
//        public Builder calories(int calories) {
//            this.calories = calories;
//            return this;
//        }
//
//        public Builder fat(int fat) {
//            this.fat = fat;
//            return this;
//        }
//
//        public Builder sodium(int sodium) {
//            this.sodium = sodium;
//            return this;
//        }
//
//        public Builder carbohydrate(int carbohydrate) {
//            this.carbohydrate = carbohydrate;
//            return this;
//        }
//
//        public NutritionFacts build() {
//            return new NutritionFacts(this);
//        }
//    }
//
//    private NutritionFacts(Builder builder) {
//        this.servingSize = builder.servingSize;
//        this.serving = builder.serving;
//        this.calories = builder.calories;
//        this.fat = builder.fat;
//        this.sodium = builder.sodium;
//        this.carbohydrate = builder.carbohydrate;
//    }
//

//    public static class Builder {
//        private final int servingSize;
//        private final int serving;
//
//        private int calories = 0;
//        private int fat = 0;
//        private int sodium = 0;
//        private int carbohydrate = 0;
//
//        public Builder(int servingSize, int serving) {
//            this.servingSize = servingSize;
//            this.serving = serving;
//        }
//
//        public Builder calories(int calories) {
//            this.calories = calories;
//            return this;
//        }
//
//        public Builder fat(int fat) {
//            this.fat = fat;
//            return this;
//        }
//
//        public Builder sodium(int sodium) {
//            this.sodium = sodium;
//            return this;
//        }
//
//        public Builder carbohydrate(int carbohydrate) {
//            this.carbohydrate = carbohydrate;
//            return this;
//        }
//
//        public NutritionFacts Build() {
//            return new NutritionFacts(this);
//        }
//    }
//
//    private NutritionFacts(Builder builder) {
//        this.servingSize = builder.servingSize;
//        this.serving = builder.serving;
//        this.calories = builder.calories;
//        this.fat = builder.fat;
//        this.sodium = builder.sodium;
//        this.carbohydrate = builder.carbohydrate;
//    }
}