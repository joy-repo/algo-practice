package com.test;

import java.util.HashMap;
import java.util.Map;

public class Trie {

  public TrieNode rootNode;

  public Trie(){
    rootNode=new TrieNode();
  }

  public boolean search(String data){

    TrieNode node = rootNode;

    for (Character c : data.toCharArray()){
      if(!node.childNodeMap.containsKey(c)) return false;
      node=node.childNodeMap.get(c);
    }
    return node.completeWord;
  }

  public boolean startsWith(String data){
    TrieNode node = rootNode;

    for (Character c : data.toCharArray()){
      if(!node.childNodeMap.containsKey(c)) return false;
      node=node.childNodeMap.get(c);
    }
    return true;
  }




  public void insert(String data){

    TrieNode node = rootNode;

    for (Character c : data.toCharArray()){
      node.childNodeMap.putIfAbsent(c, new TrieNode());
      node.wordCount++;
      node=node.childNodeMap.get(c);
    }
    node.completeWord=true;
  }



  static class TrieNode {

    public TrieNode(){
      childNodeMap = new HashMap<>();
    }

    public Map<Character, TrieNode> childNodeMap;
    public boolean completeWord ;

    public int wordCount;


  }
}
