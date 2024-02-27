package com.striver;

/// https://www.youtube.com/watch?v=-YbXySKJsX8&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=36

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {

  public static void main(String[] args) {

    BinaryTree.Node root = BinaryTree.createBT();

    String str = serializeTree(root);

    System.out.println(str);

    BinaryTree.Node root_n = deserializeTree(str);
    System.out.println(root_n);
  }

  private static BinaryTree.Node deserializeTree(String str) {

    String [] strArr = str.split(",");

    Queue<BinaryTree.Node> qu = new LinkedList<>();

    BinaryTree.Node root = new BinaryTree.Node(Integer.parseInt(strArr[0]));

    qu.offer(root);

    int count=1;

    while(!qu.isEmpty()){
      BinaryTree.Node node = qu.poll();
      if(strArr[count].equals("N")){
        continue;
      } else {
        node.left= new BinaryTree.Node(Integer.parseInt(strArr[count]));
        qu.offer(node.left);
      }
      count++;
      if(strArr[count].equals("N")){
        continue;
      } else {
        node.right= new BinaryTree.Node(Integer.parseInt(strArr[count]));
        qu.offer(node.right);
      }
      count++;
    }

    return root;

  }

  private static String serializeTree(BinaryTree.Node root) {

    Queue<BinaryTree.Node> queue = new LinkedList<>();
    StringBuilder res=new StringBuilder();

    queue.add(root);

    while (!queue.isEmpty()){

      BinaryTree.Node node = queue.poll();

      if(node==null){
        res.append("N,");
        continue;
      } else {
        res.append(node.data +",");
      }
      queue.add(node.left);
      queue.add(node.right);

    }

    return res.toString();

  }
}
