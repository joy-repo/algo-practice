package com.striver;

// L21. Vertical Order Traversal of Binary Tree
//https://www.youtube.com/watch?v=q_a6lpbKJdw&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=21

import java.util.*;

//    {0=[Node{data=1}, Node{data=5}, Node{data=11}],
//    -1=[Node{data=2}, Node{data=9}, Node{data=6}],
//    -2=[Node{data=4}], 1=[Node{data=7}, Node{data=3}],
//    -3=[Node{data=8}], 2=[Node{data=12}]}


//              1
//         2         3
//     4        5-11    12
//  8      9         6     7

public class VerticalOrderTraversal {

  public static void main(String[] args) {
    BinaryTree.Node root = BinaryTree.createBT();
  //  Map<Integer, Map<Integer, List<BinaryTree.Node>>> mapStore = new HashMap<>();
    List<Tuple> list = new ArrayList<>();
    solVertical(root,0,0, list);
    Collections.sort(list);

    list.forEach(System.out::println);

  }

 static class Tuple implements Comparable<Tuple>{

   @Override
   public String toString() {
     return "Tuple{" +
         "x=" + x +
         ", y=" + y +
         ", node=" + node +
         '}';
   }

   public int x;
    public int y;

    public BinaryTree.Node node;

    public Tuple(int x, int y, BinaryTree.Node node) {
      this.x = x;
      this.y = y;
      this.node = node;
    }

    @Override
    public int compareTo(Tuple tuple) {
      if(this.x!=tuple.x) return this.x-tuple.x;
      if(this.y!=tuple.y) return this.y-tuple.y;

      return this.node.data-tuple.node.data;
    }
  }

  private static void solVertical(BinaryTree.Node root, int x, int y, List<Tuple> list) {

    if(root==null) return;

    list.add(new Tuple(x,y,root));

    solVertical(root.right, x+1, y+1, list);
    solVertical(root.left, x-1, y+1, list);


  }

  //              1
  //       2             3
  //    4      5       11  12
  //  8  9    6  7
}
