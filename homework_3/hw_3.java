package homework_3;
import java.util.Random;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class hw_3 {
    public static void main(String[] args) {
           
        int [][] map = CreateField();
        System.out.println();
        CreateWalls(map);
        wave(map);
        System.out.println();
        printArr(map);
        
        
    }


    public static int[][] CreateField() {
        int size = 12;
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                map[i][j] = 0;
        printArr(map);
        return map;        
    }

    public static void printArr(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(" " + array[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void CreateWalls(int[][] array) {
        Random rnd = new Random();
        int height = 12;
        int width = 12;
        int wall = 99;
        for (int i = 0; i < width; i++) {
			array[i][0] = wall;
			array[width - 1][i] = wall;
		}
		for (int i = 0; i < height; i++) {
			array[0][i] = wall;
			array[i][height - 1] = wall;
		}
        int count = 0;
        while (count <= 20){
            int x = rnd.nextInt(2, 9);
            int y = rnd.nextInt(2, 9);
            array[x][y] = wall;
            count++;
        }
        printArr(array);
    }

    public static boolean isValid(int[][] array, boolean visited[][], int row, int col){
        int M = 10;
        int N = 10;
        return ((row >= 0) && (row < M)) && ((col >= 0) && (col < N)) && (array[row][col] == 1) && (!visited[row][col]);
    }

    public static void Up(ArrayList<Integer[]> newArr, int[][] array, int row, int col){
        if (array[row][col] == 99){
            return;
        }
        if (array[row - 1][col] == 0 && array[row - 1][col] != 99) {
            array[row - 1][col] = array[row][col] + 1;
            addItem(newArr, row - 1, col);
        }
    }

    public static void Right(ArrayList<Integer[]> newArr, int[][] array, int row, int col){
        if (array[row][col] == 99){
            return;
        }
        if (array[row][col + 1] == 0 && array[row][col + 1] != 99) {
            array[row][col + 1] = array[row][col] + 1;
            addItem(newArr, row, col + 1);
            }
    }

    public static void Down(ArrayList<Integer[]> newArr, int[][] array, int row, int col){
        if (array[row][col] == 99){
            return;
        }
        if (array[row + 1][col] == 0 && array[row + 1][col] != 99) {
            array[row + 1][col] = array[row][col] + 1;
            addItem(newArr, row + 1, col);
        }
    }

    public static void Left(ArrayList<Integer[]> newArr, int[][] array, int row, int col){
        if (array[row][col] == 99){
            return;
        }
        if (array[row][col - 1] == 0 && array[row][col - 1] != 99) {
            array[row][col - 1] = array[row][col] + 1;
            addItem(newArr, row, col - 1);
            }
    }
    
    public static ArrayList<Integer[]> wave(int array[][]) {
        ArrayList<Integer[]> newArr = new ArrayList<Integer[]>();
        int row = 1;
        int col = 1; 

        
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                Up(newArr, array, i, j);
                Right(newArr, array, i, j);
                Down(newArr, array, i, j);
                Left(newArr, array, i, j);
            }
        }
        array[1][1] = 0;
        System.out.println(newArr);
        return newArr;
    }
    
    public static void addItem(ArrayList<Integer[]> newArr, int row, int col) {
        Integer[] value = new Integer[] {row, col};
        newArr.add(value);
    }

    public static void FindWay(ArrayList<Integer> newArr) {
        
    }

}
