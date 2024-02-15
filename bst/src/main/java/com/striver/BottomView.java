package com.striver;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BottomView {

  public static void main(String[] args) {
    Map<Integer, BinaryTree.Node> levelMap = new TreeMap<>();
    solBottomView(BinaryTree.createBT(), 0, levelMap);
    System.out.println(levelMap);

  }

  private static void solBottomView(BinaryTree.Node node, int level,Map<Integer, BinaryTree.Node> levelMap ) {

    if(node==null) return;

    levelMap.put(level, node);

    solBottomView(node.right, level+1, levelMap);
    solBottomView(node.left, level-1, levelMap);
  }
}
