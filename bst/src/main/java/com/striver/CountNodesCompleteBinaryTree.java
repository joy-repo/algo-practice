package com.striver;

import java.util.concurrent.Flow;

//https://www.youtube.com/watch?v=u-yWemKGWO0&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=32
public class CountNodesCompleteBinaryTree {

  public static void main(String[] args) {
    BinaryTree.Node root = BinaryTree.createBT();

    int res = solve(root);
    System.out.println(res);
  }

  private static int solve(BinaryTree.Node node) {



    if(node ==null) return 0;

    int rightH= getRightHeight(node);
    int leftH = getLeftHeight(node);

    if(rightH==leftH) return new Double(Math.pow(2,rightH)-1).intValue();

    else return solve(node.left)+solve(node.right)+1;


  }

  private static int getRightHeight(BinaryTree.Node node) {

    if (node==null) return 0;
    return getRightHeight(node.right)+1;
  }

  private static int getLeftHeight(BinaryTree.Node node) {

    if (node==null) return 0;
    return getRightHeight(node.left)+1;
  }
}
