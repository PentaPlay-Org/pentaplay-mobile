package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game4_RememberTheValueIndex.Logics;

import java.util.Arrays;
import java.util.Random;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Firebase.FirebaseHandler;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Model.Sort;

public class RememberTheValueIndex {
   private static long startTime;
   private static long endTime;
   private static long duration;

   FirebaseHandler firebaseHandler = new FirebaseHandler();
   public int[] myMethod() {
      RememberTheValueIndex rememberTheValueIndex = new RememberTheValueIndex();
      Random rand = new Random();

      //generate random numbers
      int[] arr = new int[5000];
      for (int i = 0; i < 5000; i++) {
         arr[i] = rand.nextInt(1000000) + 1;
      }


      // Bubble Sort
      startTime = System.nanoTime();
      int[] arrBubbleSort = arr.clone();
      rememberTheValueIndex .bubbleSort(arrBubbleSort);
      endTime = System.nanoTime();
      duration = (endTime - startTime);
      System.out.println("Time taken by Bubble Sort: " + duration + " nanoseconds");
      store("Bubble Sort", duration);
      printFirst20Sorted(arrBubbleSort);

      // Insertion Sort
      startTime = System.nanoTime();
      int[] arrInsertionSort = arr.clone();
      rememberTheValueIndex .insertionsort(arrInsertionSort);
      endTime = System.nanoTime();
      duration = (endTime - startTime);
      System.out.println("Time taken by Insertion Sort: " + duration + " nanoseconds");
      store("Insertion Sort", duration);
      printFirst20Sorted(arrInsertionSort);

      // Merge Sort
      startTime = System.nanoTime();
      int[] arrMergeSort = arr.clone();
      rememberTheValueIndex .mergeSort(arrMergeSort, 0, arr.length - 1);
      endTime = System.nanoTime();
      duration = (endTime - startTime);
      System.out.println("Time taken by Merge Sort: " + duration + " nanoseconds");
      store("Merge Sort", duration);
      printFirst20Sorted(arrMergeSort);

      // Shell Sort
      startTime = System.nanoTime();
      int[] arrShellSort = arr.clone();
      rememberTheValueIndex .shellsort(arrShellSort);
      endTime = System.nanoTime();
      duration = (endTime - startTime);
      System.out.println("Time taken by Shell Sort: " + duration + " nanoseconds");
      store("Shell Sort", duration);
      printFirst20Sorted(arrShellSort);

      // Quick Sort
      startTime = System.nanoTime();
      int[] arrQuickSort = arr.clone();
      rememberTheValueIndex .quicksort(arrQuickSort, 0, arr.length - 1);
      endTime = System.nanoTime();
      duration = (endTime - startTime);
      System.out.println("Time taken by Quick Sort: " + duration + " nanoseconds");
      store("Quick Sort", duration);
      printFirst20Sorted(arrQuickSort);

      // Tim Sort
      startTime = System.nanoTime();
      int[] arrTimSort = arr.clone();
      rememberTheValueIndex .timSort(arrTimSort);
      endTime = System.nanoTime();
      duration = (endTime - startTime);
      System.out.println("Time taken by Tim Sort: " + duration + " nanoseconds");
      store("Tim Sort", duration);
      printFirst20Sorted(arrTimSort);

      // Radix Sort
      startTime = System.nanoTime();
      int[] arrRadixSort = arr.clone();
      rememberTheValueIndex .radixsort(arrRadixSort, arr.length);
      endTime = System.nanoTime();
      duration = (endTime - startTime);
      System.out.println("Time taken by Radix Sort: " + duration + " nanoseconds");
      store("Radix Sort", duration);
      printFirst20Sorted(arrRadixSort);

      return arrBubbleSort;


   }
   public void bubbleSort(int arr[]) {
      int n = arr.length;
      for (int i = 0; i < n - 1; i++)
         for (int j = 0; j < n - i - 1; j++)
            if (arr[j] > arr[j + 1]) {
               //swap arr[j] and arr[j + 1]
               int temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
            }
   }
   public void insertionsort(int arr[]) {
      int n = arr.length;
      for (int i = 1; i < n; ++i) {
         int key = arr[i];
         int j = i - 1;

         while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
         }
         arr[j + 1] = key;

      }
   }
   public void mergeSort(int arr[], int l, int r) {
      if (l < r) {
         int m = (l + r) / 2;
         mergeSort(arr, l, m);
         mergeSort(arr, m + 1, r);
         merge(arr, l, m, r);
      }
   }

   public void merge(int arr[], int l, int m, int r) {
      int n1 = m - l + 1;
      int n2 = r - m;
      int L[] = new int[n1];
      int R[] = new int[n2];
      for (int i = 0; i < n1; ++i)
         L[i] = arr[l + i];
      for (int j = 0; j < n2; ++j)
         R[j] = arr[m + 1 + j];
      int i = 0, j = 0;
      int k = l;
      while (i < n1 && j < n2) {
         if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
         } else {
            arr[k] = R[j];
            j++;
         }
         k++;
      }
      while (i < n1) {
         arr[k] = L[i];
         i++;
         k++;
      }
      while (j < n2) {
         arr[k] = R[j];
         j++;
         k++;
      }
   }

   int shellsort(int arr[]) {
      int n = arr.length;

      // Start with a big gap, then reduce the gap
      for (int gap = n / 2; gap > 0; gap /= 2) {
         // Do a gapped insertion sort for this gap size.
         // The first gap elements a[0..gap-1] are already
         // in gapped order keep adding one more element
         // until the entire array is gap sorted
         for (int i = gap; i < n; i += 1) {
            // add a[i] to the elements that have been gap
            // sorted save a[i] in temp and make a hole at
            // position i
            int temp = arr[i];

            // shift earlier gap-sorted elements up until
            // the correct location for a[i] is found
            int j;
            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
               arr[j] = arr[j - gap];

            // put temp (the original a[i]) in its correct
            // location
            arr[j] = temp;
         }
      }
      return 0;
   }
   int partition(int arr[], int low, int high) {
      int pivot = arr[high];
      int i = (low - 1); // index of smaller element
      for (int j = low; j < high; j++) {
         // If current element is smaller than or
         // equal to pivot
         if (arr[j] <= pivot) {
            i++;

            // swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
         }
      }

      // swap arr[i+1] and arr[high] (or pivot)
      int temp = arr[i + 1];
      arr[i + 1] = arr[high];
      arr[high] = temp;

      return i + 1;
   }


   /* The main function that implements QuickSort()
     arr[] --> Array to be sorted,
     low  --> Starting index,
     high  --> Ending index */
   void quicksort(int arr[], int low, int high) {
      if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
         int pi = partition(arr, low, high);

         // Recursively sort elements before
         // partition and after partition
         quicksort(arr, low, pi - 1);
         quicksort(arr, pi + 1, high);
      }
   }

   public void timSort(int[] arr) {
      final int MIN_MERGE = 32;
      int n = arr.length;

      // Sort individual subarrays of size MIN_MERGE
      for (int i = 0; i < n; i += MIN_MERGE) {
         int left = i;
         int right = Math.min((i + MIN_MERGE - 1), (n - 1));
         insertionSort(arr, left, right);
      }

      // Merge subarrays to get the sorted array
      for (int size = MIN_MERGE; size < n; size = 2 * size) {
         for (int left = 0; left < n; left += 2 * size) {
            int mid = left + size - 1;
            int right = Math.min((left + 2 * size - 1), (n - 1));
            mergeTimSort(arr, left, mid, right);
         }
      }
   }

   public void insertionSort(int[] arr, int left, int right) {
      for (int i = left + 1; i <= right; i++) {
         int key = arr[i];
         int j = i - 1;
         while (j >= left && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
         }
         arr[j + 1] = key;
      }
   }

   public void mergeTimSort(int[] arr, int l, int m, int r) {
      int len1 = m - l + 1;
      int len2 = r - m;
      if (len1 <= 0 || len2 <= 0) {
         return;
      }
      int[] left = new int[len1];
      int[] right = new int[len2];
      for (int x = 0; x < len1; x++)
         left[x] = arr[l + x];
      for (int x = 0; x < len2; x++)
         right[x] = arr[m + 1 + x];

      int i = 0;
      int j = 0;
      int k = l;

      while (i < len1 && j < len2) {
         if (left[i] <= right[j]) {
            arr[k] = left[i];
            i++;
         } else {
            arr[k] = right[j];
            j++;
         }
         k++;
      }

      while (i < len1) {
         arr[k] = left[i];
         k++;
         i++;
      }

      while (j < len2) {
         arr[k] = right[j];
         k++;
         j++;
      }
   }

   int getMax(int arr[], int n) {
      int mx = Math.abs(arr[0]);
      for (int i = 1; i < n; i++)
         if (Math.abs(arr[i]) > mx)
            mx = Math.abs(arr[i]);
      return mx;
   }

   // A function to do counting sort of arr[] according to
   // the digit represented by exp.
   void countSort(int arr[], int n, int exp) {
      int output[] = new int[n]; // output array
      int i;
      int count[] = new int[20]; // Count array to store count of negative, zero and positive values

      Arrays.fill(count, 0);

      // Store count of occurrences in count[]
      for (i = 0; i < n; i++)
         count[(arr[i] / exp) % 10 + 10]++;

      // Change count[i] so that count[i] now contains actual
      // position of this digit in output[]
      for (i = 1; i < 20; i++)
         count[i] += count[i - 1];

      // Build the output array
      for (i = n - 1; i >= 0; i--) {
         output[count[(arr[i] / exp) % 10 + 10] - 1] = arr[i];
         count[(arr[i] / exp) % 10 + 10]--;
      }

      // Copy the output array to arr[], so that arr[] now
      // contains sorted numbers according to current digit
      for (i = 0; i < n; i++)
         arr[i] = output[i];
   }

   // The main function to that sorts arr[] of
   // size n using Radix Sort
   void radixsort(int arr[], int n) {
      int m = getMax(arr, n);

      // Do counting sort for every digit. Note that
      // instead of passing digit number, exp is passed.
      // exp is 10^i where i is current digit number
      for (int exp = 1; m / exp > 0; exp *= 10)
         countSort(arr, n, exp);
   }



   public static void printFirst20Sorted(int[] arr) {
      Arrays.sort(arr, 0, 20);
      System.out.println("First 20 sorted numbers with indexes:");
      for (int i = 0; i < 20; i++) {
         System.out.println("Index: " + i + ", Number: " + arr[i]);
      }
   }

   private void store(String type, long duration)
   {
      Sort sort = new Sort (type, duration);
      firebaseHandler.storeSort(sort);
   }


}
