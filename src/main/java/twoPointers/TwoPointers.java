package twoPointers;

public class TwoPointers {
    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        // runtime: O(n)
        while (l <= r) {
            char lC = s.charAt(l);
            char rC = s.charAt(r);
            if (!Character.isAlphabetic(lC) && !Character.isDigit(lC)) {
                l++;
                continue;
            };
            if (!Character.isAlphabetic(rC) && !Character.isDigit(rC)) {
                r--;
                continue;
            };
            if (Character.toLowerCase(lC) == Character.toLowerCase(rC)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
