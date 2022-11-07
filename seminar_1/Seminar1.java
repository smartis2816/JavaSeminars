package seminar_1;

public class Seminar1 {
    public static void main(String[] args) {
        // Given 2 binary strings a and b, return their sum as a binary string
        System.out.println(addBinary("1010", "1011"));

        // You are given two strings word1 and word2.
        // Merge the strings by adding letters in alternating order,
        // starting with word1. If a string is longer than the other,
        // append the additional letters onto the end of the merged string.
        //Return the merged string.
        System.out.println(mergeStr("ab", "pqrs"));
    }

    public static String addBinary(String a, String b){
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        int carry = 0;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '1') {
                carry += 1;
            }
            if (j >= 0 && b.charAt(j) == '1') {
                carry += 1;
            }
            sb.append(carry % 2);
            carry /= 2;
            j--;
        }
        if (carry == 1) {
            sb.append(carry % 2);
        }
        return sb.reverse().toString();
    }

    public static String mergeStr(String word1, String word2) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}
