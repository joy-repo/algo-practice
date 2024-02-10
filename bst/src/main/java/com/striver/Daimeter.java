package com.striver;

// L16. Diameter of Binary Tree
// https://www.youtube.com/watch?v=Rezetez59Nk&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=16

public class Daimeter {

  static int RES=0;

  public static void main(String[] args) {
    BinaryTree.Node node = BinaryTree.createBT();
    sol(node);
    System.out.println(RES);
    RES=0;
    traverseEveryNode(node) ;
    System.out.println(RES);// n^2
  }

  private static void traverseEveryNode(BinaryTree.Node node) {

    if(node==null) return ;

    int lh = DepthOfBinaryTree.sol(node.left);
    int rh = DepthOfBinaryTree.sol(node.right);

    RES = Math.max(RES, lh+rh+1);

    traverseEveryNode(node.left);
    traverseEveryNode(node.right);





  }

  private static int sol(BinaryTree.Node node) {
    if(node==null) return 0;

    int lh = sol(node.left);
    int rh = sol(node.right);

    RES = Math.max(RES, lh+rh+1);

    return 1+ Math.max(lh,rh);



  }
}
