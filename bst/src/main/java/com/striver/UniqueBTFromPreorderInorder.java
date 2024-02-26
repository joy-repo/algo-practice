package com.striver;

//https://www.youtube.com/watch?v=aZNaLrVebKQ&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=34

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBTFromPreorderInorder {

  public static void main(String[] args) {
    BinaryTree.Node root = BinaryTree.createBT();

    List<Integer> preorderList = getPreorder(root);
    System.out.println("preorderList "+ preorderList);

    List<Integer> inorderList = getInorder(root);

    System.out.println("inorderList "+inorderList);

    Map<Integer,Integer> inMap = new HashMap<>();

    for(int i =0; i<inorderList.size(); i++){
      inMap.put(inorderList.get(i), i);
    }
    System.out.println(inMap);

    BinaryTree.Node newRoot = buildTree(preorderList, 0, preorderList.size()-1,
        inorderList, 0, inorderList.size()-1, inMap);

    System.out.println(newRoot);


  }

  private static BinaryTree.Node buildTree(List<Integer> preorderList, int preStart, int preEnd,
      List<Integer> inorderList, int inStart, int inend, Map<Integer, Integer> inMap) {

    if(preStart>preEnd || inStart>inend) return null;

    BinaryTree.Node root = new BinaryTree.Node(preorderList.get(preStart));

    int inRoot = inMap.get(root.data);
    int numsLeft = inRoot-inStart;

    root.left = buildTree(preorderList, preStart+1, preStart+numsLeft,
                          inorderList, inStart, inRoot-1, inMap);

    root.right = buildTree(preorderList, preStart+numsLeft+1,preEnd,
                           inorderList, inRoot+1, inend, inMap);

    return root;

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
