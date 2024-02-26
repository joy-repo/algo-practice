package com.striver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBTFromPostorderInorder {

  public static void main(String[] args) {
    BinaryTree.Node root = BinaryTree.createBT();

    List<Integer> postorderList = getPostorder(root);
    System.out.println("postorderList "+ postorderList);

    List<Integer> inorderList = getInorder(root);

    System.out.println("inorderList "+inorderList);

    Map<Integer,Integer> inMap = new HashMap<>();

    for(int i =0; i<inorderList.size(); i++){
      inMap.put(inorderList.get(i), i);
    }
    System.out.println(inMap);

    BinaryTree.Node newRoot = buildTree(postorderList, 0, postorderList.size()-1,
        inorderList, 0, inorderList.size()-1, inMap);

    System.out.println(newRoot);


  }

  private static BinaryTree.Node buildTree(List<Integer> postorderList, int postStrt, int postEnd,
      List<Integer> inorderList, int inStart, int inEnd, Map<Integer, Integer> inMap) {

    if(postEnd<postStrt || inEnd<inStart) return null;

    BinaryTree.Node root = new BinaryTree.Node(postorderList.get(postEnd));

    int inRoot = inMap.get(root.data);
    int numsLeft = inStart-inRoot;

    root.left = buildTree(postorderList, postStrt, postStrt+numsLeft-1,
                          inorderList, inStart, inRoot-1, inMap);

    root.right = buildTree(postorderList, postStrt+numsLeft, postEnd-1,
                          inorderList, inRoot+1, inEnd, inMap);

    return root;
  }

  private static List<Integer> getPostorder(BinaryTree.Node root) {

    if(root==null) return new ArrayList<>();

    List<Integer> resList = new ArrayList<>();

    List<Integer> left = getPostorder(root.left);

    List<Integer> right = getPostorder(root.right);

    resList.addAll(left);
    resList.addAll(right);
    resList.add(root.data);

    return resList;

  }

  private static List<Integer> getInorder(BinaryTree.Node root) {

    if(root==null) return new ArrayList<>();

    List<Integer> resList = new ArrayList<>();


    List<Integer> left = getInorder(root.left);
    List<Integer> right = getInorder(root.right);

    resList.addAll(left);
    resList.add(root.data);
    resList.addAll(right);

    return resList;

  }

}
