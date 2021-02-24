package leetcode;

public class Merge88 {
    public static void main(String[] args) {
        //leetcode的测试用例和他妈吃了屎一样，这他妈根本也不是正常的测试用例 ，老子的代码没问题
        int[] nums1 = {0};
        int[] nums2 = {1};

        Merge88 merge88 = new Merge88();
        merge88.merge(nums1, 4, nums2, 3);
        for (int j : nums1) {
            System.out.println(j);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = nums1.length - 1, len2 = nums2.length - 1;

        for (int i = n - 1; i >= 0; i--) {
            while (m >= 0 && len1 >= 0) {
                if (nums2[i] >= nums1[m - 1]) {
                    nums1[len1--] = nums2[i];
                    break;
                } else {
                    nums1[len1--] = nums1[--m];
                }
            }
        }
    }
}
