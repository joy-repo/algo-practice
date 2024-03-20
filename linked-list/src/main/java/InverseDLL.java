public class InverseDLL {

  public static void main(String[] args) {
    DLL dll = DLL.createDLL();
    reverse(dll.startNode);
  }

  private static DLL.Node reverse(DLL.Node startNode) {

    DLL.Node curr = startNode;
    DLL.Node prev=null;
    DLL.Node next=startNode.next;

    while (next!=null){
      curr.next=prev;
      if(prev!=null) prev.prev=curr;
      prev = curr;
      curr= next;
      next=next.next;
    }

    curr.next=prev;
    curr.prev=null;
    System.out.println(curr);
    return curr;




  }
}
