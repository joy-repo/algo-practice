package test.miscprobs;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ZigZag_LC6 {

  private static String STR ="PAYPALISHIRING";
  private static int NUM = 4;

//  Input: s = "PAYPALISHIRING", numRows = 4
//  Output: "PINALSIGYAHRPI"
  //         PINALSIGYAHRPI
//  Explanation:
//  P     I    N
//  A   L S  I G
//  Y A   H R
//  P     I


  //P   A   H   N
  //A P L S I I G
  //Y   I   R

  public static void main(String[] args) {
    solLC6();
  }

  private static void solLC6() {

    String[] arr = new String[NUM];
    for (int j=0; j<NUM; j++)
      arr[j]="";

    //PAYPALISHIRING                  Down = 4 i = 4
    // P
    // A L
    // Y A
    // P
    int i =0;
    while (i<STR.length()){
     int down =0;
      while(i<STR.length() && down<NUM){
        arr[down]=arr[down]+STR.charAt(i);
        i++;
        down++;
      }
      down=down-2;
      while (i<STR.length() && down!=0){
        arr[down]=arr[down]+STR.charAt(i);
        i++;
        down--;
      }
    }

    System.out.println(Arrays.stream(arr).collect(Collectors.joining()));
  }
}
