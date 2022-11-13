package homework_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Wave {
    public static void main(String[] args) {
        Field map = new Field();
        map.CreateField();
        map.CreateWalls();
        Coordinates start = new Coordinates(1, 3);
        Coordinates finish = new Coordinates(10, 7);
        var wv = new WaveAlgorithm(map.getMap());
        wv.WaveRealization(start);
        System.out.println("Волновой алгоритм");
        map.printArr(map.getMap());
        System.out.println("Координаты пути:");
        wv.showTrackCoordinates(wv.backTrack(start, finish));
        System.out.println("\nПуть отмечен на карте как -1");
        map.printArr(map.getMap());


    }
}

class Coordinates {
    int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String printCoords() {
        StringBuilder sb = new StringBuilder();
        sb.append("Координаты: ");
        sb.append("x = ");
        sb.append(x);
        sb.append(", ");
        sb.append("y = ");
        sb.append(y);
        return sb.toString();
    }
}

class Field {
    int[][] map;

    public void printArr(int[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                sb.append(String.format("%4d", array[i][j]));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public void CreateField() {
        int size = 12;
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                map[i][j] = 0;
        this.map = map;
        System.out.println("\nПустая карта");
        printArr(map);
    }

    public int[][] getMap() {
        return map;
    }

    public void CreateWalls() {
        Random rnd = new Random();
        int height = 12;
        int width = 12;
        int wall = 99;
        for (int i = 0; i < width; i++) {
            map[i][0] = wall;
            map[width - 1][i] = wall;
        }
        for (int i = 0; i < height; i++) {
            map[0][i] = wall;
            map[i][height - 1] = wall;
        }
        int count = 0;
        while (count <= 20) {
            int x = rnd.nextInt(2, 9);
            int y = rnd.nextInt(2, 9);
            map[x][y] = wall;
            count++;
        }
        System.out.println("Карта с добавленными препятствиями");
        printArr(map);
    }

    public void setStart(Coordinates crd) {
        map[crd.x][crd.y] = -1;
    }

    public void setFinish(Coordinates crd) {
        map[crd.x][crd.y] = -2;
    }
}

class WaveAlgorithm {
    int[][] map;
    Queue<Coordinates> q = new LinkedList<>();
    ArrayList<Coordinates> bt = new ArrayList<>();


    public WaveAlgorithm(int[][] map) {
        this.map = map;
    }

    public void Up(Queue<Coordinates> q, int[][] map, Coordinates point) {
        if (map[point.x - 1][point.y] == 0) {
            q.add(new Coordinates(point.x - 1, point.y));
            map[point.x - 1][point.y] = map[point.x][point.y] + 1;
        }
    }

    public void Right(Queue<Coordinates> q, int[][] map, Coordinates point) {
        if (map[point.x][point.y + 1] == 0) {
            q.add(new Coordinates(point.x, point.y + 1));
            map[point.x][point.y + 1] = map[point.x][point.y] + 1;
        }
    }

    public void Down(Queue<Coordinates> q, int[][] map, Coordinates point) {
        if (map[point.x + 1][point.y] == 0) {
            q.add(new Coordinates(point.x + 1, point.y));
            map[point.x + 1][point.y] = map[point.x][point.y] + 1;
        }
    }

    public void Left(Queue<Coordinates> q, int[][] map, Coordinates point) {
        if (map[point.x][point.y - 1] == 0) {
            q.add(new Coordinates(point.x, point.y - 1));
            map[point.x][point.y - 1] = map[point.x][point.y] + 1;
        }
    }

    public void WaveRealization(Coordinates start) {
        Queue<Coordinates> q = new LinkedList<>();
        q.add(start);
        map[start.x][start.y] = 1;
        while (!q.isEmpty()) {
            Coordinates point = q.poll();
            Up(q, map, point);
            Right(q, map, point);
            Down(q, map, point);
            Left(q, map, point);
        }
    }

    public ArrayList<Coordinates> backTrack(Coordinates start, Coordinates point) {
        bt.add(point);
        while (map[point.x][point.y] != 1) {
            if (map[point.x - 1][point.y] < map[point.x][point.y]) {
                point = new Coordinates(point.x - 1, point.y);
                bt.add(point);
            } else {
                if (map[point.x][point.y + 1] < map[point.x][point.y]) {
                    point = new Coordinates(point.x, point.y + 1);
                    bt.add(point);
                } else {
                    if (map[point.x + 1][point.y] < map[point.x][point.y]) {
                        point = new Coordinates(point.x + 1, point.y);
                        bt.add(point);
                    } else {
                        if (map[point.x][point.y - 1] < map[point.x][point.y]) {
                            point = new Coordinates(point.x, point.y - 1);
                            bt.add(point);
                        }
                    }
                }
            }

        }
        return bt;
    }

    public void showTrackCoordinates(ArrayList<Coordinates> bt) {
        for (Coordinates item : bt) {
            System.out.println(item.printCoords());
        }
        for (Coordinates item : bt) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if (item.x == i && item.y == j) {
                        map[i][j] = -1;
                    }
                }
            }
        }
    }
}
