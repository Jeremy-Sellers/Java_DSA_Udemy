package Sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] array){
        //for each element in array, test if element is greater than next elements
        for (int i = array.length-1; i > 0; i--){
            //each element checks for swap against next element
            //if greater, swaps position
            //j increments and continues to check original element if it was swapped, or the increiment moves on to the next element to check
            for (int j = 0; j < i; j++){

                if (array[j] > array[j+1]){
                    //swaps items in array
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    //end swap
                }
            }

        }

    }//end of method

    public static void main(String[] args) {
        int[] myArr = {4, 2, 6, 5, 1, 3};

        bubbleSort(myArr);

        System.out.println(Arrays.toString(myArr));
    }

}
