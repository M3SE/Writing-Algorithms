import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {
    // Function to find all occurrences of the pattern in the text using the Z-Algorithm
    public static List<Integer> search(String S, String pat) {
        String concat = pat + "$" + S; // Concatenate pattern, a special character, and the text
        int l = concat.length();

        int[] Z = new int[l];
        getZArray(concat, Z);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            // If Z[i] is equal to the length of the pattern, pattern is found in the text
            if (Z[i] == pat.length()) {
                result.add(i - pat.length() - 1 + 1); // Correctly calculate 1-based index
            }
        }

        return result;
    }

    // Function to calculate the Z-array
    private static void getZArray(String str, int[] Z) {
        int n = str.length();
        int L = 0, R = 0;

        for (int i = 1; i < n; i++) {
            if (i > R) {
                L = R = i;

                while (R < n && str.charAt(R) == str.charAt(R - L)) {
                    R++;
                }
                Z[i] = R - L;
                R--;
            } else {
                int K = i - L;

                if (Z[K] < R - i + 1) {
                    Z[i] = Z[K];
                } else {
                    L = i;
                    while (R < n && str.charAt(R) == str.charAt(R - L)) {
                        R++;
                    }
                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }

    public static void main(String[] args) {
        String S = "batmanandrobinarebat";
        String pat = "bat";
        List<Integer> result = search(S, pat);
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int index : result) {
                System.out.print(index + " ");
            }
        }
        System.out.println();

        S = "abesdu";
        pat = "edu";
        result = search(S, pat);
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int index : result) {
                System.out.print(index + " ");
            }
        }
    }
}
