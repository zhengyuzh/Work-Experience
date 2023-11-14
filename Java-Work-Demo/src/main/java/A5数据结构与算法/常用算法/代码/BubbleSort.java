package A5数据结构与算法.常用算法.代码;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/10/26 13:50
 * @Description: 排序算法
 *
 * 实现的基本思想：通过比较相邻数据的大小、将较大的数向后移动。
 *             然后再次和后边的数据比较、以此类推、直到将最大的数排到末尾。
 *             然后再次循环这个过程、直到完成排序。
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * @param arr
     */
    public void bubblSsort(int arr[]) {
        int len = arr.length;

        for (int i = 0; i < arr.length - 1; i++) {//控制循环次数
            for (int j = 0; j < arr.length - i - 1; j++) {//控制每一轮比较次数
                //交换数据
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }

            }
        }

    }

    /**
     * 打印数组
     * @param arr
     */
    public void pirnt(int arr[]){
        int len =arr.length;
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " 、");
        }

    }

    public static void main(String[] args) {
        BubbleSort testMy = new BubbleSort();

        int[] arr = {1, 3, 2, 5, 4, 6,16,12,99,45,78};
        testMy.bubblSsort(arr);
        testMy.pirnt(arr);

    }
}




