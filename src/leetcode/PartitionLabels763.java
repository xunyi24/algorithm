package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {
    public static void main(String[] args) {
        PartitionLabels763 partitionLabels763 = new PartitionLabels763();
        System.out.println(partitionLabels763.partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] charIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cIndex = c - 'a';
            if (charIndex[cIndex] < i) charIndex[cIndex] = i;
        }

        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, charIndex[s.charAt(i) - 'a']);
            if (i == right) {
                res.add(right - left + 1);
                left = i + 1;
            }
        }

        return res;
    }
}
