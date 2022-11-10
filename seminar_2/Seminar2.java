package seminar_2;

public class Seminar2 {
    public static void main(String[] args) {
        findPath(3, 10, 2, 2, "");
    }

    public static void findPath(int source, int target, int addend, int multiplier, String path) {
        if (source > target) return;
        if (source == target) {
            System.out.println(path);
            return;
        }
        findPath(source + addend, target, addend, multiplier, path + " K1");
        findPath(source * multiplier, target, addend, multiplier, path + " K2");
        //K1 - сложение
        //К2 - умножение
    }

}
