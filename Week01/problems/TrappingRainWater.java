//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针
import sun.misc.JavaLangRefAccess;

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 栈解法
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.empty()) break;
                int distance = i - stack.peek() - 1;
                int min = Math.min(height[i], height[stack.peek()]);
                sum += distance * (min - h);
            }
            stack.push(i);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
