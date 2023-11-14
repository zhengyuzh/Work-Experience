package A3力扣刷题.移除元素01;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/9/26 10:09
 * @Description:
 */
class Solution {
    /**
     * 力扣  移除数组中的指定元素
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int [] mynums = new int[nums.length];
        int rs = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                mynums[rs] = nums[i];
                rs ++;
            }
        }
        return mynums.length;

    }

    /**
     * 增强for循环
     * @param nums
     * @param val
     */
    public static void test(int [] nums,int val){
        int rs = 0;
        for(int num : nums){
            if(num != val){
                nums[rs] = num;
                rs ++;
            }
        }
    }

    /**
     * 对象循环
     * @param students
     */
    public static void testObject(Student [] students){
        for(Student student : students){
            System.out.println("姓名:" + student.name + ",年龄:" + student.age);
        }
    }

    public static void main(String[] args) {
        int [] nums = {3,2,2,3};
        int val = 3;
//        System.out.println(Solution.removeElement(nums, val));

        Student  student1 = new Student("张三1",18);
        Student  student2 = new Student("张三2",19);
        Student  student3 = new Student("张三3",20);
        Student  student4 = new Student("张三4",21);
        Student [] students = {student1, student2, student3, student4};

        Solution.testObject(students);

        Solution.test(nums,val);
    }
}

class Student{
    String name;
    int age;

    Student(){

    }

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
