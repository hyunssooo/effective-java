package effectivejava.item2.buliderpatten;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewYorkPizzaTest {

    @Test
    void create() {
        NewYorkPizza newYorkPizza = new NewYorkPizza.Builder(NewYorkPizza.Size.LARGE)
                .addTopping(NewYorkPizza.Topping.ONION)
                .addTopping(NewYorkPizza.Topping.HAM)
                .addTopping(NewYorkPizza.Topping.PEPPER)
                .build();
    }
}