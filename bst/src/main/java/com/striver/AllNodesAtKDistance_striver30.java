package com.striver;

//https://www.youtube.com/watch?v=i9ORlEy6EsI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=31

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesAtKDistance_striver30 {

  static  int DISTANCE =2;

  public static void main(String[] args) {
    Map<Integer, BinaryTree.Node> childToParent = new HashMap<>();
    BinaryTree.Node root = BinaryTree.createBT();
    markParentPointers(root,childToParent );

    BinaryTree.Node node = searchForNode(root,2);

    List<BinaryTree.Node> ll =searchBelow(node, 0, DISTANCE);
    System.out.println(ll);

    //searchAbove(node,0, childToParent);


  }

//  private static List<BinaryTree.Node> searchAbove(BinaryTree.Node node, int distance, Map<Integer, BinaryTree.Node> childToParent) {
//
//    if(!childToParent.containsKey(node.data) || distance> DISTANCE) return new ArrayList<>();
//
//    if(distance==DISTANCE){
//      List<BinaryTree.Node> list = new ArrayList<>();
//      list.add(node);
//      return list;
//    }
//
//    searchAbove(node, distance+1, childToParent);
//
//
//  }

  private static List<BinaryTree.Node> searchBelow(BinaryTree.Node node, int distance, int DISTANCE) {

    if(node==null|| distance>DISTANCE) return new ArrayList<>();

    if(distance==DISTANCE){
      List<BinaryTree.Node> list = new ArrayList<>();
      list.add(node);
      return list;
    }

    List<BinaryTree.Node> leftList  =searchBelow(node.left, distance+1, DISTANCE);
    List<BinaryTree.Node> rightList =searchBelow(node.right, distance+1, DISTANCE);
   // List<BinaryTree.Node> aboveList =searchBelow(childToParent.get(node.data), distance+1, DISTANCE, childToParent);

    leftList.addAll(rightList);
    return leftList;

  }

  private static BinaryTree.Node searchForNode(BinaryTree.Node node, int data) {

    if(node==null) return null;

    if(node.data==data) return node;

    BinaryTree.Node nR = searchForNode(node.right, data);
    if(nR!=null) return nR;
    BinaryTree.Node nL = searchForNode(node.left, data);
    if(nL!=null) return nL;
    return null;

  }

  private static void markParentPointers(BinaryTree.Node node, Map<Integer, BinaryTree.Node> childToParent) {

    if(node==null) return;

    if(node.left!=null){
      childToParent.put(node.left.data, node);
    }
    if(node.right!=null){
      childToParent.put(node.right.data, node);
    }
    markParentPointers(node.left, childToParent);
    markParentPointers(node.right, childToParent);
  }
}
