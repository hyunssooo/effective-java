package effectivejava.item14;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Point implements Comparable<Point> {
    private int x;
    private int y;


    @Override
    public int compareTo(Point o) {
        int result = Integer.compare(x, o.x);
        if (result == 0) {
            return Integer.compare(y, o.y);
        }
        return result;
    }
}
