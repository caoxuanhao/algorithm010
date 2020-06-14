//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 动态规划,当台阶为1级时，只有一种走法；当台阶是2级时，有两种走法；当台阶有n级时，其走法等于从倒数第一级台阶和倒数第二级台阶的总和。
    public int climbStairs(int n) {
        int[] nArr = new int[n + 1];
        nArr[0] = 1;
        nArr[1] = 1;
        for (int i = 2; i < nArr.length; i++) {
            nArr[i] = nArr[i - 1] + nArr[i - 2];
        }
        return nArr[n];
    }

    // 递归方法在LeetCode上超时...
    public int climbStairs1(int n) {
        if(n == 1){
            return 1;
        } else if(n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
