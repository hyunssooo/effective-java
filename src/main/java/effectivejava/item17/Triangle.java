package effectivejava.item17;

import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.Set;

@EqualsAndHashCode
public class Triangle {
    private final Set<Point> points;

    public Triangle(Set<Point> points) {
        validCheck(points);
        this.points = Set.copyOf(points);
    }

    public Triangle(Point... points) {
        this(Set.of(points));
    }

    private void validCheck(Set<Point> points) {
        if (points.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public Set<Point> getPoints() {
        return Collections.unmodifiableSet(points);
    }
}
