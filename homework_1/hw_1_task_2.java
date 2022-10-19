import java.util.Scanner;
import java.util.Random;

public class hw_1_task_2 {
    public static void main(String[] args) {
        PyramidSorting(FillArray());
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

    public static void Swap(int [] array, int num1, int num2) {
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }

    public static void MoveEl(int [] array, int root, int size) {
        int maxindex = root;
        int a = root * 2 + 1;
        int b = root * 2 + 2;
        if (a < size && array[maxindex] < array[a]) maxindex = a;
        if (b < size && array[maxindex] < array[b]) maxindex = b;
        if (maxindex == root) return;
        
        Swap(array, maxindex, root);
        MoveEl (array, maxindex, size);
    }

    public static void PyramidSorting(int [] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            MoveEl(array, i, array.length);
        }
        
        for (int j = array.length - 1; j >= 0; j--) {
            Swap(array, 0, j);
            MoveEl(array, 0, j);
        }
        PrintArray(array);
        
    }
}
