package leetcode;

public class ReverseLeftWords {
    public static void main(String[] args) {
        ReverseLeftWords reverseLeftWords = new ReverseLeftWords();
        String s = "lrloseumg";
        System.out.println(reverseLeftWords.reverseLeftWords(s, 6));
        System.out.println(6 % 9);
    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
