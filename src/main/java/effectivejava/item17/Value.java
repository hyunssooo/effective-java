package effectivejava.item17;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@EqualsAndHashCode
public final class Value {
    private final double value;

    public Value move(double value) {
        return new Value(this.value + value);
    }
}
