package edu.postgraduate.programExercise.myutil;

public class MySortUtil {

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void bubbleSort(int[] arr) {
        for(int i = 0 ; i < arr.length - 1 ; i++) {
            for(int j = 0 ; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                   swap(arr, j, j + 1);
                }
            }
        }
    }


//    private static void subSort(int head, int tail, int[] arr) {
//
////        System.out.println("head = " + head + ", tail = " + tail);
//        if( head >= tail || arr == null || arr.length <= 1) {
//            return;
//        }
//
//        int i = head;
//        int j = tail;
//        int pivot = arr[(i + j) / 2];
//
//        while(i <= j) {
//            while(arr[i] < pivot) {
//                i++;
//            }
//            while(arr[j] > pivot) {
//                j--;
//            }
//            if(i < j) {
//                swap(arr, i, j);
//                i++;
//                j--;
//            } else if(i == j) {
//                i++;
//            }
//        }
//        subSort(head, j, arr);
//        subSort(i, tail, arr);
//    }
//
//    public static void quickSort(int begin, int end, int[] arr) {
//        subSort(begin, end, arr);
//    }
//
//    public static void quickSort(int[] arr) {
//        subSort(0, arr.length - 1, arr);
//    }


    private static void subSort(int head, int tail, int[] arr) {
//        //
//        System.out.println("head = " + head + ", tail = " + tail);
//        //
        if(head >= tail || arr == null || arr.length <= 1) {
            return ;
        }
        int i = head;
        int j = tail;
        int pivot = arr[(head + tail) / 2];
        while(i <= j) {
            while(arr[i] < pivot) {
                i++;
            }
            while(arr[j] > pivot) {
                j--;
            }
            if(i < j) {
                swap(arr, i, j);
                // 这个时候有可能arr[i]或arr[j]是 == pivot的，如果不移走，之后的循环将永远将pivot和另外一个值进行交换
                i++;
                j--;
            } else if(i == j) {
                i++;
            }
        }
        subSort(i, tail ,arr);
        subSort(head, j ,arr);
    }

    public static void quickSort(int begin, int end, int[] arr) {
        subSort(begin, end, arr);
    }

    public static void quickSort(int[] arr) {
        subSort(0, arr.length - 1, arr);
    }
}
