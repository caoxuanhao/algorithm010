//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1.暴力解法
    // 首先创建一个Map<List<Integer>, List>
    // 将每个字符串解析成一个26个字母对应的数组
    // 每找到一个与Key中元素相同的字符串，就加入到Value的List中，否则就放到Map中
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) return result;
        Map<List<Integer>, List> strsMap = new HashMap<>();
        for (String str : strs) {
            Integer[] strList = new Integer[26];
            Integer zore = 0;
            for (int i = 0; i < strList.length; i++) {
                strList[i] = zore;
            }
            for (char c : str.toCharArray()) {
                strList[c - 97]++;
            }
            if (strsMap.size() == 0) {
                List<String> value = new ArrayList<>();
                value.add(str);
                strsMap.put(Arrays.asList(strList), value);
            } else {
                boolean isY = true;
                for (List<Integer> integers : strsMap.keySet()) {
                    for (int i = 0; i < 26; i++) {
                        isY = true;
                        if (integers.get(i) == strList[i]) {
                            continue;
                        } else {
                            isY = false;
                            break;
                        }
                    }
                    if (isY) {
                        strsMap.get(integers).add(str);
                        break;
                    }
                }
                if (!isY) {
                    List<String> value = new ArrayList<>();
                    value.add(str);
                    strsMap.put(Arrays.asList(strList), value);
                }
            }
        }
        for (List value : strsMap.values()) {
            result.add(value);
        }
        return result;
    }

    // Hash
    public List<List<String>> groupAnagrams(String[] strs) {
        // 考察了哈希函数的基本知识，只要 26 个即可
        // （小写字母ACSII 码 - 97 ）以后和质数的对应规则，这个数组的元素顺序无所谓
        // key 是下标，value 就是数值
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};

        // key 是字符串自定义规则下的哈希值
        Map<Integer, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            int hashValue = 1;

            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                hashValue *= primes[c - 'a'];
            }

            // 把单词添加到哈希值相同的分组
            if (hashMap.containsKey(hashValue)) {
                List<String> curList = hashMap.get(hashValue);
                curList.add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);

                hashMap.put(hashValue, newList);
            }
        }
        return new ArrayList<>(hashMap.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
