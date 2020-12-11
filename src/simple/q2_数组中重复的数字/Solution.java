package simple.q2_数组中重复的数字;

/**
 * 我的思路：
 * 题目有点小问题，如果没有重复的返回啥？这里暂时返回-1；
 * 1. 最先思路肯定就是一个HashSet，然后不断的往里面塞和判断，这样就是空间换时间（直接的方法有很多：排序，循环去判断等）
 * 2. 后面想起了亦或来做，但是亦或其实不是这个场景的，想错了。
 * 3. 想不出什么可以空间复杂度O(1) 时间复杂度还为O(n)的了，于是使用bitmap稍微降低一下空间复杂度（但是如果数字很多，重复数字又很靠前，那么申请bitmap的内存可能大于hashSet的内存）
 * <p>
 * 题解：
 * 长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内 (!!!! 我看漏了这最关键的信息，这样O(1)和O(n)就好找了)
 * 也就是自身数组就可以当做那个bitmap，只要遇到不在自己索引位置的地方做交换和比较就行了。
 */
class Solution {

    /**
     * mine
     */
    public static int findRepeatNumber(int[] nums) {
        byte[] bitmap = new byte[nums.length];
        for (int num : nums) {
            byte b = bitmap[num];
            if (b == (byte) 1) {
                return b;
            } else {
                bitmap[num] = (byte) 1;
            }
        }
        return -1;
    }

    /**
     * network
     * 好玩的是，这个执行时间和内存消耗比上面的那个大 😂
     */
    public int findRepeatNumber2(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            if (nums[num] == num && index != num) {
                return num;
            } else {
                int tmp = nums[num];
                nums[num] = num;
                nums[index] = tmp;
            }
        }
        return -1;
    }

}