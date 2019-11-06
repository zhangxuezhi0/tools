package first.zxz.tools;

/**
 * /**
 * 格式化输出工具
 *
 * @author zhangxz
 * 2019/9/29
 */
public class PrintTool {

    /**
     * 输出int数组
     *
     * @param ints 数组
     * @return void
     * @author Zxz
     * @date 2019/9/29 20:31
     **/
    public static void printIntArr(int[] ints) {
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static void printStringArr(String[] strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
