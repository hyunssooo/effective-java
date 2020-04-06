package effectivejava.item2.buliderpatten;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void create() {
        User user = User.builder().build();
        assertThat(user.getName()).isEqualTo("1");
    }
}