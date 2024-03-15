package com.striver.dpseries;

//https://www.youtube.com/watch?v=7win3dcgo3k&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=16

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S_16_PartitionEqualSubsetSum {


  static int[] ARR = {1,3,2,4};

  public static void main(String[] args) {
    int totalSum = Arrays.stream(ARR).sum();

    List<Integer> ll = new ArrayList<>();

   sol_RECC(0, 0, totalSum/2, ll);
   System.out.println(ll);

   List<Integer> res = sol_RECC_ret(0,0,5);
   System.out.println(res);

    sol_DP_Part();
  }


  private static boolean sol_RECC(int i, int sum, int target, List<Integer> list) {

    if (sum == target)
      return true;
    if (i >= ARR.length)
      return false;

    list.add(ARR[i]);
    if (sol_RECC(i + 1, sum + ARR[i], target, list))
      return true;
    list.remove(new Integer(ARR[i]));

    return sol_RECC(i + 1, sum, target, list);


  }


  private static List<Integer> sol_RECC_ret(int i, int sum, int target) {

    if (sum==target) return new ArrayList<>();
    if(i>=ARR.length) return null;

    List<Integer> res1 = sol_RECC_ret(i+1, sum+ARR[i], target);
    if(res1!=null){
      res1.add(ARR[i]);
      return res1;
    }

    List<Integer> res2 = sol_RECC_ret(i+1, sum, target);
    if(res2!=null){
      return res2;
    }
    return null;
    }

  private static void sol_DP_Part() {
    int totalSum = Arrays.stream(ARR).sum();
    int dp[][] = new int[ARR.length+1][totalSum/2+1];

    for(int y=0; y<dp.length; y++){
      dp[y][0]=1;
    }

    for(int y =1 ; y<dp.length; y++){
      for (int x=1; x<dp[0].length; x++){

        if(x>=ARR[y-1])
          dp[y][x]=Math.max(dp[y-1][x-ARR[y-1]]+1, dp[y-1][x]);
        else
          dp[y][x] = dp[y-1][x];

      }
    }
    for(int y=0; y<dp.length; y++  ){
      System.out.println();
      for(int x=0; x<dp[0].length; x++ ) {
        System.out.print(dp[y][x] +"  ");
      }
    }
  }




}
