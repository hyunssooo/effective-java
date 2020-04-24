package effectivejava.item14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Test
    @DisplayName("return 값")
    void name() {
        Long a = 1L;
        Long b = 2L;
        assertThat(a.compareTo(b)).isEqualTo(-1);
        assertThat(a.compareTo(a)).isEqualTo(0);
        assertThat(b.compareTo(a)).isEqualTo(1);
    }

    @Test
    void test2() {
        Long a = 1L;
        Long b = 2L;
        Long c = 3L;
        assertThat(a.compareTo(b)).isEqualTo(-1);
        assertThat(b.compareTo(c)).isEqualTo(-1);
        assertThat(a.compareTo(c)).isEqualTo(-1);
    }

    @Test
    void test3() {
        Long a = 1L;
        Long b = 1L;
        Long c = 1L;
        assertThat(a.compareTo(b)).isEqualTo(0);
        assertThat(b.compareTo(c)).isEqualTo(0);
        assertThat(a.compareTo(c)).isEqualTo(0);
    }

    @Test
    void test4() {
        final BigDecimal bigDecimal1 = new BigDecimal(("1.0"));
        final BigDecimal bigDecimal2 = new BigDecimal(("1.00"));
        final List<BigDecimal> bigDecimalList = Arrays.asList(bigDecimal1, bigDecimal2);

        Set<BigDecimal> bigDecimalHashSet = new HashSet<>(bigDecimalList);
        Set<BigDecimal> bigDecimalTreeSet = new TreeSet<>(bigDecimalList);

        assertThat(bigDecimal1.equals(bigDecimal2)).isEqualTo(false);
        assertThat(bigDecimal1.compareTo(bigDecimal2)).isEqualTo(0);
        assertThat(bigDecimalHashSet.size()).isEqualTo(2);
        assertThat(bigDecimalTreeSet.size()).isEqualTo(1);
    }
}