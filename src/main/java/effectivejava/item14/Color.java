package effectivejava.item14;

public class Color implements Comparable<Color> {
    private int r;
    private int g;
    private int b;

    public Color(int r, int g, int b) {
        checkRange(r, g, b);
        this.r = r;
        this.g = g;
        this.b = b;
    }

    private void checkRange(int r, int g, int b) {
        if (r < 0 || r > 255) {
            throw new RuntimeException();
        }
        if (g < 0 || g > 255) {
            throw new RuntimeException();
        }
        if (b < 0 || b > 255) {
            throw new RuntimeException();
        }
    }

    @Override
    public int compareTo(Color o) {
        int result = Integer.compare(r, o.r);
        if (result == 0) {
            result = Integer.compare(g, o.g);
            if (result == 0) {
                result = Integer.compare(b, o.b);
            }
        }
        return result;
    }
}
