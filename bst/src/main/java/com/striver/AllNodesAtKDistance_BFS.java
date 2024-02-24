package com.striver;

//https://www.youtube.com/watch?v=i9ORlEy6EsI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=31

import org.checkerframework.checker.units.qual.C;

import java.util.*;

public class AllNodesAtKDistance_BFS {

  static  int DISTANCE =2;

  static int NODE_VAL = 2;


  public static void main(String[] args) {
    Map<Integer,BinaryTree.Node> childToParent = new HashMap<>();

    BinaryTree.Node root= BinaryTree.createBT();
    markParentPointers(root, childToParent);

    BinaryTree.Node node = searchForNode(root,2);

    List<BinaryTree.Node> resList = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    bfs_recurssive(node, childToParent, 0, resList, visited);
    System.out.println(resList);

    bfs_iterative(node, childToParent);




  }

  private static void bfs_iterative(BinaryTree.Node node, Map<Integer, BinaryTree.Node> childToParent) {

    class Container {
      public BinaryTree.Node node;
      public int dis;

      public Container(BinaryTree.Node node, int dis){
        this.node=node;
        this.dis=dis;
      }
    }

    Queue<Container> queue = new LinkedList<>();
    queue.offer(new Container(node, 0));



    List<BinaryTree.Node> resList = new ArrayList<>();

    Set<Integer> visited = new HashSet<>();


    while (!queue.isEmpty()){

      Container tmp = queue.poll();

      visited.add(tmp.node.data);

      if(tmp.dis==DISTANCE){
        resList.add(tmp.node);
      }

      if(tmp.dis < DISTANCE) {

        if(tmp.node.right !=null && !visited.contains(tmp.node.right.data) )
        queue.add(new Container(tmp.node.right, tmp.dis + 1));

        if(tmp.node.left !=null &&  !visited.contains(tmp.node.left.data))
        queue.add(new Container(tmp.node.left, tmp.dis + 1));

        if(childToParent.containsKey(tmp.node.data) && !visited.contains(childToParent.get(tmp.node.data).data) )
        queue.add(new Container(childToParent.get(tmp.node.data), tmp.dis + 1));

      }


    }

    System.out.println(resList);


  }

  private static void bfs_recurssive(BinaryTree.Node node, Map<Integer, BinaryTree.Node> childToParent, int distance, List<BinaryTree.Node> resList, Set<Integer> visited) {

    if(node==null || distance> DISTANCE || visited.contains(node.data)) return;

    if(DISTANCE==distance) { resList.add(node); return; }

    visited.add(node.data);

    bfs_recurssive(node.left, childToParent,distance+1, resList, visited);
    bfs_recurssive(node.right, childToParent, distance+1, resList, visited);
    bfs_recurssive(childToParent.get(node.data), childToParent, distance+1, resList, visited);

  }

  private static BinaryTree.Node searchForNode(BinaryTree.Node node, int  data) {

    if(node == null)
      return null;

    if(node.data==data) return node;

    BinaryTree.Node tempNode = searchForNode(node.right,data);

    if(tempNode!=null) return tempNode;

    tempNode = searchForNode(node.left,data);
    if(tempNode!=null) return tempNode;
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
