package homework_2;
import java.util.Scanner;
import java.util.Random;

public class insertion_sort {
    public static void main(String[] args) {
        int [] newArr = FillArray();
        InsertSort(newArr);
    }

    public static int[] FillArray() {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = input.nextInt();
        System.out.print("Элементы от 0 до number. Введите number: ");
        int upperRange = input.nextInt();
        input.close();
        int[] newArray = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            newArray[i] = rnd.nextInt(upperRange + 1);
        }
        PrintArray(newArray);
        return newArray;
    }

    public static void PrintArray(int[] array) {
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println("\n");
    }

    public static void InsertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
        PrintArray(array);
    }

}
