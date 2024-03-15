package com.striver.dpseries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

///https://www.geeksforgeeks.org/number-of-ways-to-calculate-a-target-number-using-only-array-elements/
///https://www.youtube.com/watch?v=fWX9xDmIzRI&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=15

public class S_14_TargetSum {

  static  int[] ARR = {1, 2,3, 1};
  static int SUM = 3;

  public static void main(String[] args) {
    int res = sol_recc(0, 0);
    System.out.println(res);
    int totalSum = Arrays.stream(ARR).sum();
    int[][] dp = new int[ARR.length][totalSum*2+1];
    for(int[] temp : dp) Arrays.fill(temp, -1);
    res = sol_recc_memo(0,0, dp);
    System.out.println(res);
    
    sol_DP();
  }



  private static void sol_DP() {
    int totalSum = Arrays.stream(ARR).sum();

    int dp[][] = new int[ARR.length][totalSum*2+1];
    Map<Integer,Integer> map= new HashMap<>();

    for(int i=0; i<dp[0].length; i++){
      if(totalSum-ARR[0]==i) dp[0][i]=1;
      if(ARR[0]==i-totalSum)dp[0][i]=1;
    }





    for(int y=1; y<dp.length; y++  ){
      for(int x=0; x<dp[0].length; x++ ){
        if(ARR[y]>x)
          dp[y][x]= dp[y-1][x+ARR[y]];
        else if (x+ARR[y]>=dp[0].length){
          dp[y][x]=dp[y-1][x-ARR[y]];
        }
        else
          dp[y][x]=dp[y-1][x+ARR[y]]+dp[y-1][x-ARR[y]];


      }
    }
    System.out.println(dp);
    for(int y=0; y<dp.length; y++  ){
      System.out.println();
      for(int x=0; x<dp[0].length; x++ ) {
        System.out.print(dp[y][x] +"  ");
      }
    }
    System.out.println();
    System.out.println(dp[ARR.length-1][totalSum+SUM]);

  }

  private static int sol_recc_memo(int i, int sum, int[][] dp) {

    if(sum==SUM && i==ARR.length) return 1;

    if(i>=ARR.length) return 0;
    if(dp[i][sum]!=-1) return dp[i][sum];

    dp[i][sum] = sol_recc(i+1, sum+ARR[i])+sol_recc(i+1, sum-ARR[i]);
    return dp[i][sum];
  }

  private static int sol_recc(int i, int sum) {

    if(sum==SUM && i==ARR.length) return 1;

    if(i>=ARR.length) return 0;

    return sol_recc(i+1, sum+ARR[i])+sol_recc(i+1, sum-ARR[i]);
  }




}
