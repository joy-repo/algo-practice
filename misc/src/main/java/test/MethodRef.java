package test;


//1.    Reference to a static method.
//2.    Reference to an instance method.
//3.    Reference to a constructor.

public class MethodRef {

  public static void ThreadStatus(){
    System.out.println("Thread is running...");
  }
  public static void main(String[] args) {
    Thread t2=new Thread(MethodRef::ThreadStatus);
    t2.start();
  }
}
