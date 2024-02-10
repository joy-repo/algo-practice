package com.striver;

public class BoundaryTraversal {

  public static void main(String[] args) {
    BinaryTree.Node node = BinaryTree.createBT();
    solLeftTraversal(node);
    solLeafNode(node);
    solRightTraversalReversed(node);
  }

  private static void solLeafNode(BinaryTree.Node node) {
    if(node==null) return;
    if(node.left==null && node.right==null) System.out.println(node.data);

    solLeafNode(node.left);
    solLeafNode(node.right);
  }

  private static void solLeftTraversal(BinaryTree.Node node) {

    if(node==null) return;
    if(node.right!=null || node.left!=null) System.out.println(node.data);

    if(node.left!=null) solLeftTraversal(node.left);
    else solLeftTraversal(node.right);


  }

  private static void solRightTraversalReversed(BinaryTree.Node node) {

    if(node==null) return;


    if(node.right!=null) solRightTraversalReversed(node.right);
    else solRightTraversalReversed(node.left);
    if(node.right!=null || node.left!=null) System.out.println(node.data);


  }
}
