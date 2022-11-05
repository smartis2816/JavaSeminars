package seminar_3;

import java.util.ArrayList;

public class task2 {

  static int position = 0;
  static int[] storage = new int[11];

  static void clear() {
    position = 0;
    int size = storage.length;
    for (int i = 0; i < size; i++) {
      storage[i] = 0;
    }
  }

  static void print() {
    for (int i = 0; i < storage.length; i++) {
      System.out.printf(storage[i] + " ");
    }
    System.out.println();
  }

  static void shift() {
    for (int i = 0; i <= position; i++) {
      storage[i] = storage[i + 1];
    }
    storage[position] = 0;
    position--;
  }

  static void add(int item) {
    if (position >= storage.length)
      return;
    storage[position++] = item;
  }

  static int remove() {
    int el = storage[0];
    shift();
    return el;
  }

  public static void main(String[] args) {

    ArrayList<Integer> a = new ArrayList<>();
    print();
    add(1);
    print();
    add(2);
    print();
    add(3);
    print();
    System.out.println(remove());
    print();
    System.out.println(remove());
    print();
    System.out.println(remove());

    print();
    add(1);
    print();
    add(2);
    print();
    add(3);
    print();

    System.out.println(remove());
    print();

  }
}

// РћРїРёСЃР°С‚СЊ СЃС‚СЂСѓРєС‚СѓСЂСѓ С‚Р°РєСѓСЋ, С‡С‚Рѕ:
// Р•СЃС‚СЊ С…СЂР°РЅРёР»РёС‰Рµ, РјРѕР¶РЅРѕ РґРѕР±Р°РІРёС‚СЊ РёР·РІР»РµС‡СЊ.
// 0 0 0 0 0 0 0 0 0 0
// void add (int item)
// int remove (void)
// add(2)
// 2 0 0 0 0 0 0 0 0 0
// add(12)
// 2 12 0 0 0 0 0 0 0 0
// add(1)
// 2 12 1 0 0 0 0 0 0 0
// el = remove()
// 12 1 0 0 0 0 0 0 0 0
// el = remove()
// 1 0 0 0 0 0 0 0 0 0