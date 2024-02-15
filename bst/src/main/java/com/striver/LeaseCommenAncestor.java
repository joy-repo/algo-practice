package com.striver;

public class LeaseCommenAncestor {

  public static void main(String[] args) {
    int res =solLCA(BinaryTree.createBT(), 7, 8);
    System.out.println(res);
  }

  private static int solLCA(BinaryTree.Node node, int data1, int data2) {

    if(node==null) return  -1;

    if(node.data==data1) return data1;
    if(node.data==data2) return data2;

    int res1 =solLCA(node.right, data1, data2);

    int res2 =solLCA(node.left, data1, data2);

    if(res1!=-1 && res2!=-1) return node.data;

    if(res1!=-1) return res1;
    if(res2!=-1) return res2;
    return -1;


  }
}
