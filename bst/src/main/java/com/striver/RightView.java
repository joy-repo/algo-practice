package com.striver;

public class RightView {

  public static void main(String[] args) {
    solRighView(BinaryTree.createBT(), 0, -1);
  }

  private static void solRighView(BinaryTree.Node node, int level, int max) {
    if(node==null) return;

    if(level>max) System.out.println(node);
    max = Math.max(max, level);

    solRighView(node.right, level+1, max);
    solRighView(node.left, level-1, max);
  }
}
