package effectivejava.item17;

import lombok.EqualsAndHashCode;

import java.util.Set;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class Line {
    private final Set<Point> points;

    public Line(Set<Point> points) {
        validCheck(points);
        this.points = points;
    }

    public Line(Point... points) {
        this(Set.of(points));
    }

    private void validCheck(Set<Point> points) {
        if (points.size() != 2) {
            throw new IllegalArgumentException();
        }
    }

    public Line moveByX(double xValue) {
        return new Line(points.stream()
                .map(point -> point.moveByX(xValue))
                .collect(Collectors.toSet())
        );
    }

    public Line moveByY(double yValue) {
        return new Line(points.stream()
                .map(point -> point.moveByY(yValue))
                .collect(Collectors.toSet())
        );
    }

    public Line move(double xValue, double yValue) {
        return new Line(points.stream()
                .map(point -> point.move(xValue, yValue))
                .collect(Collectors.toSet())
        );
    }

    public Set<Point> getPoints() {
        return points;
    }

//    public Set<Point> getPoints() {
//        return Collections.unmodifiableSet(points);
//    }
}
