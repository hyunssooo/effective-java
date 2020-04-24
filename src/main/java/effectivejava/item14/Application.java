package effectivejava.item14;

public class Application {
    public static void main(String[] args) {
        Long a = 1L;
        Long b = 2L;
        System.out.println(a.compareTo(b)); // -1
        System.out.println(b.compareTo(b)); // 0
        System.out.println(b.compareTo(a)); // 1
    }
}
