package com.test;

public class Main {

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    System.out.println( trie.search("apple"));
    System.out.println(trie.startsWith("app"));
    System.out.println(trie.startsWith("aps"));
    System.out.println( trie.search("appl"));

  }
}
