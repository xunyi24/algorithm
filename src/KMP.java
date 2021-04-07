public class KMP {
    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issip";
        System.out.println(new KMP().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(needle, next);

        int i = 0, j = 0;
        while (i < haystack.length() && j < next.length) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j - 1];
            }
            if (j == needle.length()) {
                return i - next.length;
            }
        }

        return -1;
    }

    /**
     * 求next数组总体架构
     * 1. 初始化next数组
     * 2. 处理前缀末尾与后缀末尾不相等时的情况
     * 3. 处理前缀末尾与后缀末尾相等时的情况
     * 4. 给next数组赋值
     *
     * 这里使用了动态规划的思想, 首先将一开始的相关位置赋值,
     * 当前缀末尾与后缀末尾相等的时候就更新相关的值,
     * 当不相等的时候就根据由初始值推出来的一系列值进行回退更新,
     * 处理相等与不想等的情况的方式就是动态规划中的推导公式
     * @param s 模式串
     * @param next next数组
     */
    private void getNext(String s, int[] next) {
        //1. 初始化前缀末尾j, 后缀末尾i, next数组
        int j = 0; //前缀末尾也同时表示了包括当前i之前的字符串的最长相等前后缀的长度
        next[0] = 0; //字符串的第一个字符的最长相等前后缀是0
        //初始化i为后缀末尾, 从i = 1开始, 0开始无意义, i也表示了当前遍历模式串的位置
        for (int i = 1; i < s.length(); i++) {
            //2.处理前缀末尾与后缀末尾不相等时的情况
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                //当前缀末尾与后缀末尾不相同的时候, j回退到j的前一个位置的下标所指的位置并再次比较直到相等或者j == 0
                j = next[j - 1];
            }
            //3. 处理前缀末尾与后缀末尾相等时的情况, 如果前缀末尾与后缀末尾相同那么前缀末尾加1, 并将当前j更新到next数组
            if (s.charAt(j) == s.charAt(i)) {
                //4. 给next数组赋值
                next[i] = ++j;
            }
            //同时i前进进行下一轮比较
        }
    }
}
