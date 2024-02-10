package com.test;

import java.util.*;

public class Leet432 {

  public static void main(String[] args) {
    sol();
  }

  private static void sol() {
    AllOne allOne = new AllOne();
    allOne.inc("hello");
    allOne.inc("hello");
    allOne.getMaxKey(); // return "hello"
    allOne.getMinKey(); // return "hello"
    allOne.inc("leet");
    allOne.getMaxKey(); // return "hello"
    allOne.getMinKey(); // return "leet"
  }

  static class DLinkedList {

    Node first;
    Node last;


  }

  public static class Node {

    public Set<String> words;
    public int count;

    public Node next;
    public Node prev;

    public Node(Set<String> words, int count) {
      this.words = words;
      this.count = count;
    }
  }

  static class AllOne{

    HashMap<String,Node> map;
   // LinkedList<Node> linkedList;

    Node first;
    Node last;

    public AllOne(){

      map= new HashMap<>();
      first=last=null;

    }

    public void inc(String key){
     // Node n = map.get(key);
      Node res=null;
      if(!map.containsKey(key)) {
        Node n = first;
        if (n!=null && n.count == 1) {
          n.words.add(key);
        } else {
          Node newNode = new Node(new HashSet<String>(), 1);
          newNode.words.add(key);
          if(first!=null){
            first.prev=newNode;
            newNode.next=first;
            first=newNode;
            res=newNode;
          }else {
            first=last=newNode;
          }
        }
      }else {
        Node node = map.get(key);
        int count = node.count;
       // node.words.remove(key);


        Node next = node.next;
        if(next==null){
          Node newNode = new Node(new HashSet<String>(), count+1);
          newNode.words.add(key);
          node.next=newNode;
          newNode.prev=node;
          last=newNode;
          res=newNode;
        } else if(next.count==count+1) {
          next.words.add(key);
          res=next;
        } else if(next.count>count+1){
          Node newNode = new Node(new HashSet<String>(), count+1);
          newNode.words.add(key);
          Node tempN = node.next;
          node.next=newNode;
          newNode.prev=node;
          newNode.next=tempN;
          tempN.prev=newNode;
          res=newNode;

        }


        node.words.remove(key);
        map.put(key,res);
      }



    }

    public void dec(String key) {

      int count = map.get(key);

      if(count==1){
        treemap.get(count).remove(key);
      } else {
        treemap.get(count).remove(key);
        treemap.putIfAbsent(count-1, new HashSet<>());
        treemap.get(count-1).add(key);
      }

      map.put(key, count-1);

    }

    public String getMaxKey() {

      return treemap.lastEntry().getValue().stream().findAny().get();

    }

    public String getMinKey() {

      return treemap.firstEntry().getValue().stream().findAny().get();

    }
  }
}
