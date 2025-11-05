//Darren Hagood
//10-30-2025
//
public class RecursionProblems {

    // count8: counts 8s, but an 8 with another 8 immediately to its left counts double.
    public static int count8(int n) {
        if (n == 0) return 0;
        int last = n % 10;
        int next = (n / 10) % 10;
        if (last == 8) {
            // double-count if the digit to the left is also 8
            return (next == 8 ? 2 : 1) + count8(n / 10);
        }
        return count8(n / 10);
    }

    // countHi: count occurrences of "hi" (non-overlapping)
    public static int countHi(String str) {
        if (str == null || str.length() < 2) return 0;
        if (str.startsWith("hi")) {
            return 1 + countHi(str.substring(2)); // non-overlapping
        }
        return countHi(str.substring(1));
    }

    // countHi2: count "hi" but NOT if immediately preceded by 'x'
    public static int countHi2(String str) {
        if (str == null || str.length() < 2) return 0;

        // If we see "xhi", skip the whole "xhi" with no count
        if (str.startsWith("xhi")) {
            return countHi2(str.substring(3));
        }
        // If we see "hi" (and it's not "xhi" because of the check above), count it
        if (str.startsWith("hi")) {
            return 1 + countHi2(str.substring(2));
        }
        // Otherwise move one char forward
        return countHi2(str.substring(1));
    }

    // strCount: count non-overlapping occurrences of sub in str
    public static int strCount(String str, String sub) {
        if (str == null || sub == null) return 0;
        if (str.length() < sub.length()) return 0;
        if (str.startsWith(sub)) {
            return 1 + strCount(str.substring(sub.length()), sub); // non-overlapping
        }
        return strCount(str.substring(1), sub);
    }

    // stringClean: collapse runs of the same char to a single char
    public static String stringClean(String str) {
        if (str == null || str.length() <= 1) return str;
        // If first two are same, drop the first
        if (str.charAt(0) == str.charAt(1)) {
            return stringClean(str.substring(1));
        }
        // Keep first, clean the rest
        return str.charAt(0) + stringClean(str.substring(1));
    }

    // MAIN METHOD so you can run it
    public static void main(String[] args) {
        System.out.println("count8(8818) → " + count8(8818)); // 4
        System.out.println("countHi(\"xhixhix\") → " + countHi("xhixhix")); // 2
        System.out.println("countHi2(\"ahixhi\") → " + countHi2("ahixhi")); // 1
        System.out.println("strCount(\"catcowcat\", \"cat\") → " + strCount("catcowcat", "cat")); // 2
        System.out.println("stringClean(\"yyzzza\") → " + stringClean("yyzzza")); // "yza"
    }
}