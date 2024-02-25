package com.striver;

//https://www.youtube.com/watch?v=2r5wLmQfD6g&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=31&t=227s

import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BurnBinaryTree {

  static int DATA = 6;

  public static void main(String[] args) {
    BinaryTree.Node root = BinaryTree.createBT();

    BinaryTree.Node node = searchNode(root);

    Map<Integer, BinaryTree.Node> childToParent = new HashMap<>();

    getChildToParent(root, childToParent);

    int res =timeToBurn(node, childToParent, new HashSet<>());
    System.out.println(res);
   // res = getmaxdis(node,0, new HashSet<>(), childToParent);
    System.out.println(res-1);
  }


  //////COPIED FROM GEEKS--- START //////////
  static int getmaxdis(BinaryTree.Node target, int dis,
      Set<Integer> vis,
      Map<Integer, BinaryTree.Node> map)
  {
    if (target == null)
      return dis - 1;

    if (vis.contains(target.data))
      return Integer.MIN_VALUE;
    // calls
    // calls

    vis.add(target.data);

    int a1 = Integer.MIN_VALUE;
    int a2 = Integer.MIN_VALUE;
    int a3 = Integer.MIN_VALUE;
    // if(a->left!=NULL)
    a1 = getmaxdis(target.left, dis + 1, vis,
        map); // left child

    // if(a->right!=NULL)
    a2 = getmaxdis(target.right, dis + 1, vis,
        map); // right child

    // if(map[a] != NULL)
    a3 = getmaxdis(map.get(target.data), dis + 1, vis,
        map); // parent

    return Math.max(Math.max(a1, a2), a3);
  }

  //////COPIED FROM GEEKS--- END //////////

  private static int timeToBurn(BinaryTree.Node node, Map<Integer, BinaryTree.Node> childToParent, Set<Integer> visited) {

    if(node==null ) return 0;

    if(visited.contains(node.data)) return Integer.MIN_VALUE;

    visited.add(node.data);

    int t1 = timeToBurn(node.left, childToParent, visited);
    int t2 = timeToBurn(node.right, childToParent, visited);
    int t3 = timeToBurn(childToParent.get(node.data), childToParent, visited);

    return Math.max(Math.max(t1, t2),t3)+1;
  }

  private static void getChildToParent(BinaryTree.Node node, Map<Integer, BinaryTree.Node> childToParent) {

    if(node==null) return;

    if(node.left!=null) childToParent.put(node.left.data, node);
    if(node.right!=null) childToParent.put(node.right.data, node);

    getChildToParent(node.left, childToParent);
    getChildToParent(node.right, childToParent);

  }

  private static BinaryTree.Node searchNode(BinaryTree.Node node) {

    if(node==null) return null;

    if(node.data==DATA) return node;

    BinaryTree.Node tmp = searchNode(node.left);

    if(tmp!=null) return tmp;

    tmp = searchNode(node.right);

    if(tmp!=null) return tmp;

    return null;
  }
}
