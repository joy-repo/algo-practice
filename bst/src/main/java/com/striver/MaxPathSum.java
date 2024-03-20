package com.striver;

// L17. Maximum Path Sum in Binary Tree
// https://www.youtube.com/watch?v=WszrfSwMz58&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=17



public class MaxPathSum {

  private static  int RES =0 ;

  public static void main(String[] args) {
    BinaryTree.Node root = BinaryTree.createBT();
    int res =sol(root);
    System.out.println(res);

  }

  private static void traverseEveryNode(BinaryTree.Node node) {

    if (node == null)
      return;

    int lh = DepthOfBinaryTree.sol(node.left);
    int rh = DepthOfBinaryTree.sol(node.right);

    RES = Math.max(RES, lh + rh + 1);

    traverseEveryNode(node.left);
    traverseEveryNode(node.right);

  }

    private static int sol(BinaryTree.Node root) {

    if(root==null) return 0;

    int sumR = sol(root.right);
    int sumL = sol(root.left);

    int max = Math.max(sumL, sumR);
    return max+ root.data;


  }
}
