package 设计模式.结构型模式.适配器模式.代码.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/2 10:07
 * @Description: 二分查找类：适配者
 *  *            适配者即被适配的角色，它定义了一个已经存在的接口，这个接口需要适配，
 *  *            适配者类一般是一个具体类，包含了客户希望使用的业务方法，在某些情况下可能没有适配者类的源代码
 */

class BinarySearch {
    public int binarySearch(int array[],int key) {
        int low = 0;
        int high = array.length -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if(midVal < key) {
                low = mid +1;
            }
            else if (midVal > key) {
                high = mid -1;
            }
            else {
                return 1; //找到元素返回1
            }
        }
        return -1;  //未找到元素返回-1
    }
}