package isssue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 21:08 2020/8/6
 * @Modified By:
 */
public class Sort {
    public static void main(String[] args) {
//        sort(); //双指针排序
//        sort1(); //冒泡排序
//        switchTest(); //switch穿透测试
        getMath(); //Math.random()的取值范围0~1
    }

    private static void getMath() {
        Set<Integer> set = new HashSet<>();
        while (set.size() <= 15) {
            int i = (int) (Math.random() * 100) + 1;
            set.add(i);
        }
//        for (; ; ) {
//            if (set.size() == 15) {
//                break;
//            }
//            int i = (int) (Math.random() * 100) + 1;
//            set.add(i);
//        }
        System.out.println(set);
    }


    private static void switchTest() {
        int i = 0;
        switch (i) {
            case 0:
                System.out.println(0);
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            default:
                System.out.println(3);
        }
    }

    //冒泡排序
    private static void sort1() {
        int[] arr = {66, 33, 55, 59, 82, 4, 3};
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {//循环完毕后
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            System.out.print("第" + (i + 1) + "次外套循环结果：");
            sout(arr);
            System.out.println();
        }

    }

    private static void sout(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(", ");
        }
    }

    /*比如将如下两个有序数组
    [1, 3, 5, 7, 9, 12, 15, 18] 和 [2, 8, 11, 16, 19] 排序后，我们希望得到新数组[ 1, 2, 3, 5, 7, 8, 9, 11, 12, 15, 16, 18, 19 ]
    提示：不能java的原生排序、工具类*/
    public static void sort() {
        int[] arr1 = {1, 3, 5, 7, 9, 12, 15, 18};
        int[] arr2 = {2, 8, 11, 16, 19};
        int length = arr1.length + arr2.length;
        int indexArr1 = 0;
        int indexArr2 = 0;
        int[] arrResult = new int[length];
        for (int i = 0; i < length; i++) {
            if (indexArr1 < arr1.length && indexArr2 < arr2.length) {
                if (arr1[indexArr1] < arr2[indexArr2]) {
                    arrResult[i] = arr1[indexArr1++];
                } else {
                    arrResult[i] = arr2[indexArr2++];
                }
            } else if (indexArr1 == arr1.length && indexArr2 < arr2.length) {
                arrResult[i] = arr2[indexArr2++];
            } else if (indexArr1 < arr1.length && indexArr2 == arr2.length) {
                arrResult[i] = arr1[indexArr1++];
            } else {
                break;
            }
        }
        for (int i = 0; i < arrResult.length; i++) {
            System.out.print(arrResult[i]);
            System.out.print(", ");
        }
    }

}
