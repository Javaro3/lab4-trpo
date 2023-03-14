package com.example.binarysearch;

import java.util.Arrays;

public class BinarySearchClass {
    private int[] arr;

    public int[] getArr() {
        return arr;
    }

    public BinarySearchClass(int[] arr){
        this.arr = arr;
        sort();
    }

    private void sort(){
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[i]){
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    public int binarySearch(int elem, int min, int max){
        int sred = (max + min) / 2;
        if(Arrays.stream(arr).filter(e -> e == elem).count() == 0){
            return -1;
        }
        if(arr[sred] > elem){
            return binarySearch(elem, min, sred);
        } else if(arr[sred] < elem){
            return binarySearch(elem, sred, max);
        }
        return sred;
    }
}