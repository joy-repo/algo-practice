package com.test;

import java.util.Arrays;

public class SieveOfEratosthenes {


  static int N= 50;
  static boolean[] ARR = new boolean[N+1];

  public static void main(String[] args) {
    sol();
    for(int i =0; i< ARR.length; i++){
      System.out.println("i: "+i + "::"+ARR[i]);
    }
  }

  private static void sol() {

    for(int i =2; i<ARR.length; i++){
      ARR[i]=true;
    }

    for(int i=2; i*i <= N; i++){
      if(ARR[i]==true){
        for(int j=i*i; j<= N; j=j+i){
          ARR[j]=false;
        }
      }
    }
  }
}
