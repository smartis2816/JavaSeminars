package seminar_3;

public class task1 {

    static int solve(int s, int e, int p, int m) {
      int[] ways = new int[e + p];
      ways[s] = 1;
  
      for (int i = s + p; i <= e; i++) {
        ways[i] = i % m == 0 ? ways[i - p] + ways[i / m] : ways[i - p];
      }
  
      for (int i = 0; i < ways.length; i++) {
        System.out.printf(ways[i] + "  ");
      }
      return ways[e];
    }
  
    static int f(int s, int e, int p, int m) {
  
      // return e == s ? 1
      // : e % m == 0 ? f(s, e - p, p, m) + f(s, e / m, p, m)
      // : f(s, e - p, p, m);
      if (e == s)
        return 1;
      else if (e % m == 0)
        return f(s, e - p, p, m) + f(s, e / m, p, m);
      else
        return f(s, e - p, p, m);
    }
  
    public static void main(String[] args) {
  
      int a = 1;
      int b = 2;
      int max;
      if (a > b)
        max = a;
      else
        max = b;
  
      max = a > b ? a : b;
  
      // solve(2, 110, 1, 2);
      // System.out.println(f(2, 110, 1, 2));
    }
  
  }
  
  // f(s,e)=>if(s==2)return 1
  
  // |if(item%2==0)f(s,e)=>f(s,e-1)+f(s,e/2)f(s,e)={|if(item%2!=0)f(s,e)=>f(s,e-1)
  
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