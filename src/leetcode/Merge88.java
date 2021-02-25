package leetcode;

public class Merge88 {
    public static void main(String[] args) {
        int[] nums1 = {2, 0};
        int[] nums2 = {1};

        Merge88 merge88 = new Merge88();
        merge88.merge(nums1, 1, nums2, 1);
        for (int j : nums1) {
            System.out.println(j);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }

        int nums1Index = nums1.length - 1;
        n--;
        m--;
        while (n >= 0) {
            while (m >= 0) {
                if (nums2[n] >= nums1[m]) {
                    nums1[nums1Index--] = nums2[n--];
                    break;
                } else {
                    nums1[nums1Index--] = nums1[m--];
                }
            }
            if (m == -1) {
                System.arraycopy(nums2, 0, nums1, 0, n + 1);
                break;
            }
        }
    }
}
