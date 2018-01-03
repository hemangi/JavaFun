import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.IntStream;

public class ArrayLeftRotate {
    public void leftRotate(int arr[], int n, int d) {
        IntStream.range(0, d).forEach(i -> leftRotateOne(arr, n));
    }

    public void leftRotateOne(int arr[], int n) {
        int temp = arr[0];
        IntStream.range(0, n - 1).forEach(i -> {
            arr[i] = arr[i + 1];
        });
        arr[n - 1] = temp;
    }

    void printArray(int arr[], int size) {
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        ArrayLeftRotate rotate = new ArrayLeftRotate();
        rotate.leftRotate(a, n, k);
        rotate.printArray(a, n);
    }
}
