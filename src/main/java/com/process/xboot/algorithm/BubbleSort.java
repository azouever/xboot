package com.process.xboot.algorithm;

// Java program for implementation of Bubble Sort
class BubbleSort {

  void bubbleSort(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          // swap arr[j+1] and arr[j]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  void bubbleSortByKai(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        if (arr[i] > arr[j]) {
          // swap arr[j+1] and arr[j]
          int temp = arr[j];
          arr[j] = arr[i];
          arr[i] = temp;
        }
      }
    }
  }

  /* Prints the array */
  void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  // Driver method to test above
  public static void main(String args[]) {
    BubbleSort ob = new BubbleSort();
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    ob.bubbleSortByKai(arr);
    System.out.println("Sorted array");
    ob.printArray(arr);
  }
}
/* This code is contributed by Rajat Mishra */