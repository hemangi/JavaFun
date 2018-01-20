import java.io.IOException;

/**
 * Created by HP on 1/20/2018.
 */
public class LongestCommonSuffix {
    private static String findLongestCommonSuffix(String input1 , String input2){
        int str1Length = input1.length(),
                str2Length = input2.length(),
                row = 0,
                col = 0,
                len = 0;

        int subStringDetails[][] = new int[str1Length+1][str2Length+1];
        for(int i=1; i<= str1Length ; i++) {
            for(int j=1; j<=str2Length ; j++) {
                if (i == 0 || j == 0) {
                    subStringDetails[i][j] = 0;
                } else if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                    subStringDetails[i][j] = subStringDetails[i - 1][j - 1] + 1;
                    if (len < subStringDetails[i][j]) {
                        len = subStringDetails[i][j];
                        row = i;
                        col = j;
                    }
                } else
                    subStringDetails[i][j] = 0;
            }
        }

        System.out.println("Result array for comparison");
        for(int i=0; i<= str1Length ; i++) {
            for (int j = 0; j <= str2Length; j++) {
                System.out.print(subStringDetails[i][j] + "-");

            }
            System.out.println();
        }
        String result = "";
        while(subStringDetails[row][col] !=0) {
            result = input1.charAt(row-1) + result;
            row--;
            col--;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Result:" + findLongestCommonSuffix("ABC", "ABABCA"));
    }
}
