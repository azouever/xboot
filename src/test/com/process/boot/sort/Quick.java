package com.process.boot.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xkx
 * @description
 */
public class Quick {

  int leftIndex;
  int rightIndex;

  int temp;


  public void sort(int[] arr, int left, int right) {

    while (true) {
      // left 排序
      for (int i = left + 1; i <= right; i++) {

        if (arr[i] >= arr[left]) {
          leftIndex = i;
          break;
        }
        leftIndex++;
      }

      // right 排序
      for (int i = right; i >= left + 1; i--) {

        if (arr[i] <= arr[right]) {
          rightIndex = i;
          break;
        }
        rightIndex--;
      }

      if (leftIndex < rightIndex) {
        temp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = temp;
      } else {
        break;
      }
    }
    if (leftIndex >= rightIndex) {
      temp = arr[left];
      arr[left] = arr[rightIndex];
      arr[rightIndex] = temp;
    }

    sort(arr, left, rightIndex - 1);
    sort(arr, rightIndex + 1, right);
  }

  public static void main(String[] args) {
    Map<String, Object> hashMap = new HashMap<>();
    hashMap.put("xkx", "xukaixuan");
  }
}
