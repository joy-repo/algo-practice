package com.test;

public class BinaryExponention {

  static int A=5;
  static int B= 7;

  //////   A^B

  public static void main(String[] args) {
    long res =pp(A,B);
    System.out.println(res);
    power(A,B);
  }

  public static long power(long a, long b) {
    long result = 1;
    while (b > 0) {
      if ((b%2) == 1) {
        result = result * a;
      }
      a =a*a;
      b =b/2 ;
    }

    System.out.println(result);
    return result;
  }





  static long pp (int base, int ex ){

    if(ex==0) return 1l;

    long res =pp(base, ex/2);

    if(ex%2==1) return res*res*base;

    return res*res;

  }





  static long power_RECC(long A, long B) {
    if (B == 0)
      return 1;

    long res = power_RECC(A, B / 2);

    if (B % 2 == 1)
      return res * res * A;
    else
      return res * res;
  }

}
