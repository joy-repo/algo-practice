package com.striver;

// L15. Check for Balanced Binary Tree -
//https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=15

public class CheckForbalancedBinaryTree {

  public static void main(String[] args) {
    BinaryTree.Node root = BinaryTree.createBT();
    int res = sol(root);
    System.out.println(res);
  }

  private static int sol(BinaryTree.Node node) {
    if(node==null) return 0;
    int lh = sol(node.left);
    int rh = sol(node.right);

    if(lh==-1 || rh ==-1) return -1;
    if(Math.abs(lh-rh)>1) return -1;
    return Math.max(lh, rh)+1;
  }
}
