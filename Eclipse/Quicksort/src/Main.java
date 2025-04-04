// Quick sort in Java

import java.util.Arrays;

class Quicksort {

  // method to find the partition position
  static int partition(int array[], int low, int high) {
    
    // choose the rightmost element as pivot
	  
    int pivot = array[low];
    
    // pointer for greater element
    int lw = low ;
    
    // traverse through all elements
    // compare each element with pivot
    for (int i = low+1; i < high+1; i++) {
      if (array[i] <= pivot) {

        // if element smaller than pivot is found
        // swap it with the greatr element pointed by i
        

        // swapping element at i with element at j
        int temp = array[i];
        array[i] = array[lw];
        array[lw] = temp;
        lw+=1;
      }

    }

    // swapt the pivot element with the greater element specified by i
    int temp = array[lw ];
    array[lw ] = array[low];
    array[low] = temp;

    // return the position from where partition is done
    return (lw );
  }

  static void quickSort(int array[], int low, int high) {
    if (low < high) {

      // find pivot element such that
      // elements smaller than pivot are on the left
      // elements greater than pivot are on the right
      int pi = partition(array, low, high);
      
      // recursive call on the left of pivot
      quickSort(array, low, pi - 1);

      // recursive call on the right of pivot
      quickSort(array, pi + 1, high);
    }
  }
}

// Main class
class Main {
  public static void main(String args[]) {

    int[] data = { 8, 7, 2, 1, 0, 9, 6 };
    System.out.println("Unsorted Array");
    System.out.println(Arrays.toString(data));

    int size = data.length;

    // call quicksort() on array data
    Quicksort.quickSort(data, 0, size - 1);

    System.out.println("Sorted Array in Ascending Order: ");
    System.out.println(Arrays.toString(data));
  }
}