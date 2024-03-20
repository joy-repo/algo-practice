public class DetectCycle {

  public static void main(String[] args) {
    SLL sll = SLL.createSLL();
    SLL.Node node3 = sll.getAt(3);
    SLL.Node last = sll.tail;
    last.next=node3;

    boolean res =detectCycle(sll);
    System.out.println(res);

  }

  private static boolean detectCycle(SLL sll) {

    SLL.Node slow= sll.head;
    SLL.Node fast = sll.head;

    while(fast!=null ){
      fast=fast.next.next;
      slow=slow.next;
      if(slow==fast) return true;
    }
    return  false;
  }
}
