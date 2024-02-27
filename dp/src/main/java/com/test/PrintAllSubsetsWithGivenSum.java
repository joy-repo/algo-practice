package com.test;

//https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/

import java.util.ArrayList;

public class PrintAllSubsetsWithGivenSum {

  static int[] ARR = {2, 3, 5, 6, 8, 10};
  static int SUM = 10;

  public static void main(String[] args) {

    sol_Reccc_all(0, 0,new ArrayList<>());
    sol_Reccc_SubOrdered(-1, 0, new ArrayList<>());

  }

  private static void sol_Reccc_SubOrdered(int i, int sum, ArrayList<Integer> res) {


    System.out.println("sol_Reccc_Sub:" + res);

    if(i>=ARR.length)
      return;

    for(int cnt = i+1; cnt<ARR.length; cnt++){
      res.add(ARR[cnt]);
      sol_Reccc_SubOrdered(cnt, sum+ARR[cnt], res);
      res.remove(new Integer(ARR[cnt]));
    }


  }

  private static void sol_Reccc_all(int i, int sum, ArrayList<Integer> res) {

    System.out.println("sol_Reccc_all:" + res);

    if(i>=ARR.length){
      return;
    }



    sol_Reccc_all(i+1, sum, res);

    res.add(ARR[i]);
    sol_Reccc_all(i+1, sum+ARR[i], res);
    res.remove(new Integer(ARR[i]));


  }

}
