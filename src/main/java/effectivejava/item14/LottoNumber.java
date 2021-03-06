package effectivejava.item14;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    static final int LOTTO_SIZE = 6;
    static final int MINIMUM_LOTTO_NUMBER = 1;
    static final int MAXIMUM_LOTTO_NUMBER = 45;

    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS;

    private final int number;

    static {
        LOTTO_NUMBERS = new HashMap<>();
        IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                .forEachOrdered(value -> LOTTO_NUMBERS.put(value, new LottoNumber(value)));
    }

    public static LottoNumber generateNumber(int lottoNumber) {
        validLottoNumber(lottoNumber);
        return LOTTO_NUMBERS.get(lottoNumber);
    }

    private static void validLottoNumber(int number) {
        if (MINIMUM_LOTTO_NUMBER > number || number > MAXIMUM_LOTTO_NUMBER) {
            throw new RuntimeException("로또 넘버는 " + MINIMUM_LOTTO_NUMBER + "~" + MAXIMUM_LOTTO_NUMBER + "사이의 값을 가집니다.");
        }
    }

    private LottoNumber(int number) {
        validLottoNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }
}