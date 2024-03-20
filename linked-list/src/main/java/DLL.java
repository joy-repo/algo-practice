public class DLL {

  public Node startNode;
  public Node lastNode;

  public int size;

  public static void main(String[] args) {
    createDLL();
  }

  public static DLL createDLL(){
    DLL dll = new DLL();

    dll.insertLast(1);
    dll.insertLast(2);
    dll.insertLast(3);
    dll.insertLast(4);
    dll.insertLast(5);
    dll.insertLast(6);

    dll.insertAt(1, 100);
    dll.insertAt(3, 300);
    dll.insertAt(dll.size+1, 800);
    DLL.Node nn = dll.getNodeAt(3);

    return dll;

  }


  // nn  1 2 3 4
  // ind 3 2 1 0
  public void delete(int index){

    DLL.Node node = startNode;

    while (index>1 && node!=null){
      node=node.next;
      index--;
    }
    if(node==null) return;

    DLL.Node prev = node.prev;
    prev.next=node.next;
    if(node.next!=null) node.next.prev=prev;

    size--;


  }

  public DLL.Node getNodeAt(int index){
    DLL.Node n = startNode;
    int i=1;
    while (i<index && n!=null){
      n =n.next;
      i++;
    }
    return n;

  }

  public void insertAt(int indx, int data){
    if(indx==1){
      insertFirst(data);
      return;
    }
    if(indx>=size){
      insertLast(data);
      return;
    }
    DLL.Node node = startNode;

    while (indx>1 && node!=null){
      node=node.next;
      indx--;
    }
    node=node.prev;

    DLL.Node temp = new DLL.Node(data);
   // node.prev.next = temp;
    temp.prev=node;
    temp.next=node.next;
    node.next.prev=temp;
    node.next=temp;

    size++;


  }

  public void deleteLast(){

  }

  public void insertFirst(int data){

    Node temp = new Node(data);
    if(startNode==null){
      startNode=temp;
      lastNode=temp;
    } else {
      temp.next=startNode;
      startNode.prev=temp;
      startNode=temp;
    }
    size++;
  }

  public void insertLast(int data){

    Node temp = new Node(data);
    if(lastNode==null){
      startNode=temp;
      lastNode=temp;
    } else {
      lastNode.next=temp;
      temp.prev=lastNode;
      lastNode=temp;
    }
    size++;
  }



  static class Node{
    public Node(Integer data) {
      this.data = data;
    }

    public Integer data;
    public Node next;
    public Node prev;
  }
}
