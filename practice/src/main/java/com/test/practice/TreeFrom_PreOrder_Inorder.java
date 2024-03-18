package com.test.practice;

import java.util.ArrayList;
import java.util.List;

public class TreeFrom_PreOrder_Inorder {

  public static void main(String[] args) {

    List<Integer> inorder = getInorder(BinaryTree.createBT());
    System.out.println(inorder);
    List<Integer> preOrder = getPreorder(BinaryTree.createBT());
    System.out.println(preOrder);
  }

  private static List<Integer> getInorder(BinaryTree.Node node) {

    if(node==null) return new ArrayList<>();

    List<Integer> res = new ArrayList<>();



    List<Integer> left = getInorder(node.left);
    List<Integer> right = getInorder(node.right);

    res.addAll(left);
    res.add(node.data);
    res.addAll(right);

    return res;
 }

  private static List<Integer> getPreorder(BinaryTree.Node root) {

    if(root==null) return new ArrayList<>();

    List<Integer> resList = new ArrayList<>();
    resList.add(root.data);

    List<Integer> left = getPreorder(root.left);
    List<Integer> right = getPreorder(root.right);

    resList.addAll(left);
    resList.addAll(right);

    return resList;


  }

}
