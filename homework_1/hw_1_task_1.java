import java.util.Scanner;

/**
 * hw_1
 */
public class hw_1_task_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число n: ");
        int n = input.nextInt();
        input.close();
        int t = triangularNumber(n);
        System.out.printf("Треугольное число при n = %d равно %d \n", n, t);
    }

    public static int triangularNumber (int n) {
        if (n != 1) {
            int t = triangularNumber(n - 1) + n;
            return t;
        }
        else {
            return 1;
        }
    }
}