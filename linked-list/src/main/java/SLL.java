public class SLL {

  public SLL.Node head;
  public int size;

  public SLL.Node tail;

  public static SLL  createSLL(){
    SLL sll = new SLL();
    sll.insert(1);
    sll.insert(2);
    sll.insert(3);
    sll.insert(4);
    sll.insert(5);
    return sll;

  }

  public void insertAt(int data , int idx){
    if(idx>=size){
      insert(data);
      return;
    }
    SLL.Node node = head;
    int i=1;
    while (i<idx-1){
      node=node.next;
      i++;
    }
    SLL.Node tmp = new Node(data);
    SLL.Node nxt = node.next;
    node.next=tmp;
    tmp.next=nxt;
    size++;

  }

  public SLL.Node getAt(int idx){
    if(idx>size) return null;
    if(idx==size) return tail;
    if(idx==1) return head;

    SLL.Node node = head;
    int i=1;
    while (i<idx){
      node=node.next;
      i++;
    }
    return node;
  }

  public void insert(int data){

    if(tail!=null){
      tail.next=new Node(data);
      tail=tail.next;
    } else {
      tail=new Node(data);
      head=tail;
    }
    size++;
  }


  public static class Node{
    public int data;

    @Override
    public String toString() {
      return "Node{" +
          "data=" + data +
          '}';
    }

    public Node next;

    public Node(int data){
      this.data=data;
    }
  }
}
