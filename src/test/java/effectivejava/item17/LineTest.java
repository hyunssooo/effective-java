package effectivejava.item17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private Point point1;
    private Point point2;

    @BeforeEach
    void setUp() {
        point1 = new Point(0, 0);
        point2 = new Point(1, 2);
    }

    @Test
    void create() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 2);
        final Line line1 = new Line(point1, point2);
        final Line line2 = new Line(Set.of(new Point(0, 0), new Point(1, 2)));

        assertThat(line1).isEqualTo(line2);
    }

    @Test
    void move() {
        final Line line = new Line(point1, point2);
        final Line moveLine = line.move(1, 1);

        assertThat(moveLine).isEqualTo(new Line(new Point(1, 1), new Point(2, 3)));
    }

    @Test
    void test1() {
        Set<Point> points = new HashSet(Arrays.asList(point1, point2));
        
        final Line line = new Line(points);

        line.getPoints().clear();
        assertThat(line.getPoints().size()).isEqualTo(0);
//        assertThrows(UnsupportedOperationException.class, () -> line.getPoints().add(new Point(1, 1)));
    }
}