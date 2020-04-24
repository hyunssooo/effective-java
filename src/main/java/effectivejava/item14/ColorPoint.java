package effectivejava.item14;

public class ColorPoint implements Comparable<ColorPoint> {
    private Point point;
    private Color color;

    public ColorPoint(Point point, Color color) {
        this.point = point;
        this.color = color;
    }

    @Override
    public int compareTo(ColorPoint o) {
        int result = point.compareTo(o.point);
        if (result == 0)
            return color.compareTo(o.color);
        return result;
    }
}
