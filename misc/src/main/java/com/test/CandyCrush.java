package com.test;

import java.util.Stack;

public class CandyCrush {

  private static char[] cArr = "123455432190".toCharArray();

  public static void main(String[] args) {
    solit();
  }

  private static void solit() {

    Stack<Character> stk = new Stack<>();

    //stk.push(cArr[0]);
    int i=0;

    while (i< cArr.length){
      if(stk.isEmpty()){ stk.push(cArr[i]); i++; continue;}
      int peek = stk.peek();
      boolean repeatFound = false;
      while (i< cArr.length && peek==cArr[i]){
        i++;
        repeatFound=true;
      }
      if(repeatFound) stk.pop();
      else {stk.push(cArr[i]); i++;}

      }

    System.out.println(stk);

    }



  }


