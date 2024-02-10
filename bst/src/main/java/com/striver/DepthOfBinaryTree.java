package com.striver;

// Striver 14 - Binary tree- https://www.youtube.com/watch?v=eD3tmO66aBA&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=14&t=213s
public class DepthOfBinaryTree {

  public static void main(String[] args) {
    BinaryTree.Node root = BinaryTree.createBT();
   int res = sol(root);
   System.out.println(res);
  }

  public static int sol(BinaryTree.Node root) {

    if(root==null) return 0;

    return Math.max(sol(root.right), sol(root.left))+1;



  }
}
