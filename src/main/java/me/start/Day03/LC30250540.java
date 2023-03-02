package me.start.Day03;

/**
 * 540. 有序数组中的单一元素
 * 给你一个仅由整数组成的有序数组，
 * 其中每个元素都会出现两次，唯有一个数只会出现一次。
 * 请你找出并返回只出现一次的那个数。
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 * 示例 1
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 */
public class LC30250540 {
    // 超出时间限制
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (mid % 2 == 1) { // 可能是这里超时
                mid--; // 数是成对出现的，保证mid始终为偶数，即所在位置为奇数位
                     // 因此，此时，mid与其身后数只要相等，则表明target在后面，否则反之。
            }
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return nums[l]; // l每次+2跳过一对相等的数，r的后面也全是正确的
                        // 所以最后一次l停的位置>=r，即target所在
    }

    public int singleNonDuplicate02(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) { // 异或运算
                low = mid + 1; // low永远在成对数的后一个
            } else {
                high = mid; //
            }
        }
        return nums[low];
    }
}
