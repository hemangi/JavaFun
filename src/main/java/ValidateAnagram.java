import java.util.Arrays;
import java.util.Scanner;

public class ValidateAnagram {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        a = a.toLowerCase();
        b = b.toLowerCase();
        char first[] = new char[26];
        char second[] = new char[26];

        for (int i = 0; i < a.length(); i++)
            first[a.charAt(i) - 97]++;
        for (int i = 0; i < b.length(); i++)
            second[b.charAt(i) - 97]++;

        return Arrays.equals(first, second);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(isAnagram(a, b));
    }
}
