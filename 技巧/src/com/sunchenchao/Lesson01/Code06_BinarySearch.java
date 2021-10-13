package com.sunchenchao.Lesson01;

/**
 * 二分查找
 * 只要是和两边有关 可以与中间然后丢掉一边的都是可以使用二分排序的
 */
public class Code06_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {
                1,4,6,9,10,10,10,141,7788,8889
        };
        binarySearch(arr,10);
        System.out.println("--------------------------");
        int[] arr1 = {1,1,1,3,3,3,3,4,4,4,4,4,6,6,6,6};
        searchNumBestLeftPosition(arr1,4);
        System.out.println("--------------------------");
        int[] arr2 = {7,7,4,3,2,1,2,3,5};
        partMinimum(arr2);

    }

    /**
     * 金典二分找查
     * @param arr 有序数组
     * @param num 你要找的数字
     */
    public static void binarySearch(int[] arr,int num){
        int rightPosition = arr.length-1;
        int leftPosition = 0;
        int flag = 1;//判断是否找到
        //数据越界的判断
        if (num<arr[leftPosition] || num>arr[rightPosition]){
            System.out.println("eor");
            return;
        }
        while (rightPosition>=leftPosition){
            int midPosition = (rightPosition + leftPosition)/2;
            if (num == arr[midPosition]){
                flag = 0;
                System.out.println("位置为：" + midPosition);
                return;
            }else if (num < arr[midPosition]){//要找的数在左边
                rightPosition= midPosition-1;//这边要理解一下
            }else{// 找左边的数 num > mid
                leftPosition = midPosition+1;//这两个
            }
        }
        if (flag==1){
            System.out.println("MEIYOUZHAODAO");
        }
    }

    /**
     * 找到>=最左侧的位置的一个数
     */
    public static void searchNumBestLeftPosition(int[] arr,int num){
        // 1 1 1 1 5 5 5 5 9 9 9 7 7 7 7 7 8 8
        int leftPosition = 0 ;
        int rightPosition = arr.length-1;
        int flag = -1 ; //记录每一次的位置
        while (rightPosition>=leftPosition){
            int midPosition = (rightPosition + leftPosition)/2;
             if (num < arr[midPosition]){//要找的数在左边
                rightPosition= midPosition-1;//这边要理解一下
                if (num >= arr[midPosition]){
                    flag = midPosition;
                }
            }else{// 找左边的数 num >= mid  如果相等就是要往左边走 记住这个细节
                 // 等于走左边就是左边在数据相同情况下的数
                 // 等于走右边就是右边在数据相同情况下的数
                leftPosition = midPosition+1;//这两个
                if (num >= arr[midPosition]){
                    flag = midPosition;
                }
            }
        }
        System.out.println("大于的最左的位置为" + flag);
    }

    /**
     * 局部最小值问题  要求是时间复杂度不能为O(N)
     * arr 无序 只有一个局部最小值 找出一个局部最小值
     * 1.先判断第一个 箭头是不是↓ 如果是name第一个数就是局部最小值
     * 2.判断最后一个数箭头是不是↓ 如果是就是局部最小值
     * 3.之后就是使用二分法去判断
     * 如果必有局部最小值 那么说明整体肯定是凹 或 凸的
     */
    public static void partMinimum(int[] arr){
        //判断第一个和最后一个 0代表↓  1代表↑
        int leftPosition = 0 ;
        int leftFlag = 0;
        int rightPosition = arr.length-1;
        int rightFlag = 1;
        if(arr[leftPosition]<arr[leftPosition+1]){
            System.out.println("局部最小位置："+leftPosition);
            return;
        }
        if (arr[rightPosition]<arr[rightPosition-1]){
            System.out.println("局部最小位置"+rightPosition);
            return;
        }
        while (leftPosition<=rightPosition) {
            int midPosition = (leftPosition + rightPosition)/2;
            if(arr[midPosition]<arr[midPosition+1] && arr[midPosition]<arr[midPosition-1]){//判断一下当前的值是不是最小值
                System.out.println("局部最小值为"+midPosition);
                return;
            } else if (arr[midPosition] > arr[midPosition+1]){ //这个如果满足就是往右边找
                leftPosition = midPosition + 1;
            }else {
                rightPosition = midPosition - 1;
            }
        }
    }

}
