//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表

import java.util.Map;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 异位词，组成单词的字母元素相同，顺序不同。
    // 1. 暴力解法：
    // 遍历s字符数组，在t字符数组删除该元素，
    // 当s遍历完后，t中没有元素，则为异位词。
    // 若遍历过程中，t中没有找到s要删除的元素，或s遍历完后，t中还有元素，则不为异位词。
    // 时间复杂度O(n^2)，空间复杂度O(n)

    // 2. 哈希表，将s，t拆解为HashMap中的元素，比对两个Map中各元素的值。
    // 时间复杂度O(n),空间复杂度O(n)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : s.toCharArray()) sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        if (sMap.size() != tMap.size()) return false;
        for(Character key : sMap.keySet()){
            if (!sMap.get(key).equals(tMap.getOrDefault(key, 0))) {
                return false;
            }
        }
        return true;
    }

    // 3. 数组，一个int数组，26个下标对应26个字母，遍历s，对应下表标1，遍历t，对应下标-1。结束后检查数组是否所有元素为0.
    // 时间复杂度O(n),空间复杂度O(n)
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) counts[c - 97]++;
        for (char c : t.toCharArray()) counts[c - 97]--;

        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
