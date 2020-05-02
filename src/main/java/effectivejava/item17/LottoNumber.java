package effectivejava.item17;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class LottoNumber {
    private static final Map<Integer, LottoNumber> NUMBERS = new HashMap<>();

    static {
        IntStream.rangeClosed(1, 45)
                .forEach(value -> NUMBERS.put(value, new LottoNumber(value)));
    }

    private final int number;

    public LottoNumber of(int number) {
        return NUMBERS.get(number);
    }
}
