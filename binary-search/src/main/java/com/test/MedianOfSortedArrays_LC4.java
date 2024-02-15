package com.test;

public class MedianOfSortedArrays_LC4 {

  static int[] a = {1, 4, 7, 10, 12};
  static int[] b = {2, 3, 6, 8, 15};

  public static void main(String[] args) {
    double res = sol(a,b);
    System.out.println(res);
  }

  private static double sol(int[] a, int[] b) {
    if(a.length>b.length) sol(b,a);


    int low = 0;
    int high = a.length-1;
    int left = (a.length + b.length + 1) / 2;

    while(low<=high){

      int mid = (low+high)/2;

      int l1 = a[mid-1];
      int r1 = a[mid];


      int mid2 = left-mid;
      int l2=b[mid2-1];
      int r2 = b[mid2];

      if (l1 <= r2 && l2 <= r1) {
        if ((a.length+b.length) % 2 == 1) return Math.max(l1, l2);
        else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
      } else if (l1 > r2) high = mid - 1;
      else low = mid + 1;



    }

    return 0;

  }
}
