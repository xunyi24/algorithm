package leetcode;

public class Jump45 {
    public static void main(String[] args) {
        new Jump45().jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3});
    }
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int curCoverRange = 0;
        int nextCoverRange = 0;
        int stepCount = 0;
        for (int i = 0; i <= nums.length; i++) {
            // 在同一个coverRange中, 每次都更新最远的coverRange。以当到达当前的coverRange终点时, 续上下次最新的coverRange。
            nextCoverRange = Math.max(nextCoverRange, i + nums[i]);
            // 当到达这一次的最远coverRange时, 就要增加一步
            if (i == curCoverRange) {
                if (i == nums.length - 1) {
                    break;
                } else {
                    // 一开始是index = 0; 我一开始到达了这个点, 如果这个点还不是终点的话那么我就需要走一步
                    stepCount++;
                    // 这是我这一步能走的最远的距离
                    curCoverRange = nextCoverRange;
                    // 如果我这一步的最远距离可以到达数组的终点的话就可以break了, 说明可以到达终点; 当然不在这里判断的话也会在上边的if中判断出去, 不过需要多走几步
                    if (curCoverRange >= nums.length - 1) break;
                }
            }
        }
        return stepCount;
    }
}
