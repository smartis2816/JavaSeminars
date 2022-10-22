package homework_2;
import java.util.Scanner;

/**
 * hanoi_tower
 */
public class hanoi_tower {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите количество дисков: ");
        int rings = input.nextInt();
        input.close();
        char a = 'A';
        char b = 'B';
        char c = 'C';
        game(rings, a, b, c);
    }

    public static void game(int rings, char a, char b, char c) {
        if (rings == 1) {
            System.out.println("Переносим диск №1 с башни " + a + " на башню " + c);
        } 
        else {
            game(rings - 1, a, c, b);
            System.out.println("Переносим диск №" + rings + " с башни " + a + " на башню " + c);
            game(rings - 1, b, a, c);
        }
    }
}

