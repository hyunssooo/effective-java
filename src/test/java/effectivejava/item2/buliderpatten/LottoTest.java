package effectivejava.item2.buliderpatten;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void name() {
        Lotto lotto = Lotto.builder()
                .num(1L)
                .nums(List.of(2L, 3L, 4L))
                .build();

        assertThat(lotto.getNums()).isEqualTo(List.of(1L, 2L, 3L, 4L));
    }
}