package com.striver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversal {

  public static void main(String[] args) {
    BinaryTree.Node n = BinaryTree.createBT();
    sol(n);
  }

  //              1
  //       2             3
  //    4      5       11  12
  //  8  9    6  7

  //qu1 ->1
  //qu2 ->  2, 3

  private static void sol(BinaryTree.Node n) {

    Stack<BinaryTree.Node> st1 = new Stack<>();
    Stack<BinaryTree.Node> st2 = new Stack<>();

    st1.push(n);
    while (!st1.isEmpty() || !st2.isEmpty()) {

      while (!st1.isEmpty()) {
        BinaryTree.Node node = st1.pop();
        System.out.println(node.data);
        if (node.right != null)
          st2.push(node.right);
        if (node.left != null)
          st2.push(node.left);
      }

      while (!st2.isEmpty()) {
        BinaryTree.Node node = st2.pop();
        System.out.println(node.data);
        if (node.left != null)
          st1.push(node.left);

        if (node.right != null)
          st1.push(node.right);


      }
    }

  }
}
