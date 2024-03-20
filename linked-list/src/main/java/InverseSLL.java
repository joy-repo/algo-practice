public class InverseSLL {

  public static void main(String[] args) {
    SLL sll = SLL.createSLL();
    SLL.Node res = reverse(sll.head);
  }

  private static SLL.Node reverse(SLL.Node node) {

    SLL.Node next = node.next;
    SLL.Node curr = node;
    SLL.Node prev = null;

    while(curr!=null){
      curr.next=prev;
      prev=curr;
      curr=next;
      if(next!=null) next=next.next;
    }

    System.out.println(prev);
    return prev;

  }
}
