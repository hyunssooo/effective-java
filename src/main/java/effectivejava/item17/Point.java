package effectivejava.item17;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class Point {
    private final Value xValue;
    private final Value yValue;

    public Point(Value xValue, Value yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public Point(double xValue, double yValue) {
        this(new Value(xValue), new Value(yValue));
    }

    public Point move(double xValue, double yValue) {
        return new Point(this.xValue.move(xValue) , this.yValue.move(yValue));
    }

    public Point moveByX(double xValue) {
        return move(xValue, 0);
    }

    public Point moveByY(double yValue) {
        return move(0, yValue);
    }
}
