package com.striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RooTToNodePath {

  public static void main(String[] args) {
    BinaryTree.Node root = BinaryTree.createBT();
    int data = 7;

    List<BinaryTree.Node> res = solP(root , 7);

    Collections.reverse(res);
    System.out.println(res);
  }

  private static List<BinaryTree.Node> solP(BinaryTree.Node node, int data) {

    if(node==null) return Collections.EMPTY_LIST;

    if(node.data==data) {
      List<BinaryTree.Node> list = new ArrayList<>();
      list.add(node);
      return list;
    }

    List<BinaryTree.Node> ll = solP(node.left,data);

    if(!ll.isEmpty()){
      ll.add(node);
      return ll;
    }
    ll = solP(node.right,data);

    if(!ll.isEmpty()){
      ll.add(node);
      return ll;
    }
    return Collections.EMPTY_LIST;
  }
}
