package Stepik;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int v = input.nextInt();
        int s = input.nextInt();
        input.close();
        System.out.println(v * s);

    }
}
