package test.miscprobs;

public class TestDo {

  public static void main(String[] args) {
    String str = "1101001";
    String remove1 = str.replaceAll("1", "");
    int numOfOperations = str.length()-remove1.length()+1;
    System.out.println(numOfOperations);
  }
}
