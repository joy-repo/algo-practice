package com.test;

public class DoublyLinkedList<D> {

  public Node<D> start;
  public Node<D> last;
  public void addLast(){

  }


}

class Node<D>{

 public D data;
 public Node<D> next;
 public Node<D> prev;

  public Node(D data) {
    this.data = data;
  }
}
