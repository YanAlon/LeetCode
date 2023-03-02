package me.start.Day02;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组nums，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 */
public class LC20110075 {
    // 1.大神解法：双指针+计数+赋值
    // --通过先赋值再比较，节省了交换赋值的操作
    // 首先，所有数都≤2，那么索性把所有数组置为2，
    // 然后用一个变量统计遇到所有≤1的次数，同时将所有前面的数全部置为1，
    // 这就覆盖了错误的2，那最后未覆盖的所有2的位置就是正确的了，
    // 最后统计遇到所有≤0的次数，同时全部置为0，也就覆盖了一些错误的1，
    // 这时候，0和1的位置都正确。
    // 最重要的就是需要两个指针指向下一个1或0的位置，这两个指针同时起到了统计的作用
    public void sortColors01(int[] nums) {
        int n0 = 0, n1 = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i]; // 先储存当前元素
            nums[i] = 2; // 首先全部赋值为2
            // 当元素为2时，n1和n0不会移动，始终在数组前端
            if(num < 2){
                // 每有一个<2的元素，n1就移动一次，这样将始终指向1该去的位置
                nums[n1++] = 1;
            }
            if(num < 1){
                // 同理
                nums[n0++] = 0;
            }
        }
    }

    // 2.
    public void sortColors02(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        // 三个指针分别代表赋0，1，2的指针，也分别位于首、中、尾
        // 其中由1指针负责便利，通过灵活使用++和--，控制交换赋值
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, --two, one);
            } else {
                ++one;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
