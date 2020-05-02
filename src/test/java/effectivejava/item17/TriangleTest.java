package effectivejava.item17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {

    private Point point1;
    private Point point2;
    private Point point3;

    @BeforeEach
    void setUp() {
        point1 = new Point(0, 0);
        point2 = new Point(1, 2);
        point3 = new Point(2, 1);
    }

    @Test
    void test1() {
        Triangle triangle = new Triangle(point1, point2, point3);
        assertThrows(UnsupportedOperationException.class, () -> triangle.getPoints().add(new Point(4, 4)));
        assertThrows(UnsupportedOperationException.class, () -> triangle.getPoints().remove(point1));
        assertThrows(UnsupportedOperationException.class, () -> triangle.getPoints().clear());
    }

    @Test
    void test2() {
        Set<Point> points = new HashSet(Arrays.asList(point1, point2, point3));
//        Set<Point> points = Set.of(point1, point2, point3);

        Triangle triangle = new Triangle(points);
        triangle.getPoints().add(new Point(1, 1));
        assertThat(triangle.getPoints().size()).isEqualTo(4);
    }

    @Test
    void test3() {
        Set<Point> points = new HashSet(Arrays.asList(point1, point2, point3));
//        Set<Point> points = Set.of(point1, point2, point3);

        Triangle triangle = new Triangle(points);
        triangle.getPoints().remove(point1);
        assertThat(triangle.getPoints().size()).isEqualTo(2);
    }
}