package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game5_PredictTheValueIndex.Logics;

import java.util.Date;

public class Helper {
    public int[] sortArray(int[] array){
        return quickSort(array , 0  , array.length - 1);
    }


    private int[] quickSort(int[] arr , int low , int high){
        if(low < high){
            int pi = partition(arr , low , high);
            quickSort(arr , low , pi-1);
            quickSort(arr , pi +1 , high);
        }
        return  arr;
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high -1 ; j++) {
            if(arr[j] < pivot){
                i++;
                swap(arr , i , j);
            }
        }
        swap(arr , i+1 , high);
        return (i+1);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
