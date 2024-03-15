package test;

import org.junit.Test;

import java.util.*;


public class Prob1 {

  static int[] ARR = {1,2,33,4,44,5,5,666,333,1,2,3};

  public static void main(String[] args) {

   TreeSet<Integer> set = new TreeSet<>();

    for(int i : ARR){
      set.add(i);
    }

    System.out.println(set);




  }


  //100MB -->  set1 --> file1
  //100MB ---> set2 ---> file2
  ///........       ---> file3
  ///..................file 1000000000000
  //                        100000
  // / resFile ->

  //10000 --> write

  /// i1



  @Test
  public void test1(){
    int[] ARR = {1,2,33,4,44,5,5,666,333,1,2,3};




  }
}
