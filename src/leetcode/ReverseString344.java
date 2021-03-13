package leetcode;

public class ReverseString344 {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }

        int left = 0, right = s.length - 1;
        while (left < right) {
            char t = s[right];
            s[right] = s[left];
            s[left] = t;
            left++; right--;
        }
    }
}
