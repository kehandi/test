package com.bonree.sort;

/**
 * 冒泡排序
 * <p>
 * 思路：俩俩交换，大的放在后面，第一次排序后最大值已在数组末尾。因为俩俩交换，需要n-1趟排序（比如10个数，需要9趟排序）
 * <p>
 * 代码实现要点：两个for循环，外层循环控制排序的趟数，内层循环控制比较的次数。每趟过后，比较的次数都应该要减1
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] array = {4, 6, 1, 8, 2, 7, 6};
        System.out.println("排序前：");
        showArray(array);

        System.out.println("开始排序...");
        bubbleSort(array);

        System.out.println("排序后：");
        showArray(array);
    }

    /**
     * 冒泡排序
     * @param array 数组
     */
    public static void bubbleSort(int[] array) {
        // 装载临时变量
        int temp;
        // 记录是否发生了置换 0 表示没有发生置换、1 表示发生了置换
        int isChange;
        // 记录执行了多少趟
        int num = 0;
        // 记录交换位置的次数
        int changeNum = 0;

        // 外层循环是排序的趟数
        for (int i = 0; i < array.length - 1; i++) {
            // 进一次外层循环，排序趟数加1
            num++;
            // 每比较一趟就重新初始化为0
            isChange = 0;

            // 内层循环是当前这一趟需要比较的次数
            for (int j = 0; j < array.length - i - 1; j++) {

                // 前一位与后一位比较，如果前一位比后一位大，那么交换 （如果相等不会交换，从这里可以看出冒泡排序是稳定的）
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    // 如果到了这里，说明发生了置换，把isChange标记为1，changeNum++
                    isChange = 1;
                    changeNum++;
                }
            }

            // 如果比较完一趟没有发生置换，那么说明已经排好序了，不需要再执行下去了
            if (isChange == 0) {
                break;
            }
        }
        System.out.println("外层循环执行了" + num + "次");
        System.out.println("交换了" + changeNum + "次");
    }

    /**
     * 打印数组
     * @param array 数组
     */
    public static void showArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println("]");
    }

}
