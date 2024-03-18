package com.test.practice;

public class BoundaryTraversal {

  public static void main(String[] args) {
    BinaryTree.Node root = BinaryTree.createBT();

    leftTraversal(root);
  }

  private static void leftTraversal(BinaryTree.Node node) {
    if(node==null) return;
    if(node.right==null && node.left==null) return;
    System.out.print(node.data+",");

    if(node.left!=null) leftTraversal(node.left);
    else leftTraversal(node.right);



  }
}
