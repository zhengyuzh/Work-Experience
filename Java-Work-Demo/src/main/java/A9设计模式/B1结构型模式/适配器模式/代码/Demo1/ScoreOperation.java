package A9设计模式.B1结构型模式.适配器模式.代码.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/2 10:03
 * @Description: 定义适配者：具体完成的接口方法、适配器：接口请求转化。抽象目标接口：客户端实际调用接口
 *
 * 抽象成绩操作类：目标接口 目标抽象类定义客户所需接口，可以是一个抽象类或接口，也可以是具体类。
 *
 *
 */

interface ScoreOperation {
     int[] sort(int array[]); //成绩排序
     int search(int array[],int key); //成绩查找
}

/**
 * 适配器:
 *      适配器可以调用另一个接口，作为一个转换器，对Adaptee和Target进行适配，
 *      适配器类是适配器模式的核心，在对象适配器中，它通过继承Target并关联一个Adaptee对象使二者产生联系
 */
class OperationAdapter implements ScoreOperation{
    private QuickSort sortObj; //定义适配者QuickSort对象
    private  BinarySearch searchObj; //定义适配者BinarySearch对象

    public OperationAdapter(){
        sortObj = new QuickSort();
        searchObj = new BinarySearch();
    }

    @Override
    public int[] sort(int[] array) {
        return sortObj.quickSort(array);
    }

    @Override
    public int search(int[] array, int key) {
        return searchObj.binarySearch(array,key);
    }
}