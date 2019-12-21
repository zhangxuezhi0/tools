package first.zxz.tools;

/**
 * 数组工具
 *
 * @author zhangxz
 * @date 2019-12-15 12:24
 */

public class ArraysTool {

    //使用异或运算实现值的交换，可以节省一个空间
    public static void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public static void reverse(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 0, j = nums.length - 1, mid = nums.length >> 1; i < mid; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 3, 5, 3, 20};
        swap(nums, 1, 3);
        PrintTool.printIntArr(nums);
    }

}
