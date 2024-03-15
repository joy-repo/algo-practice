package com.test;

import java.util.LinkedList;
import java.util.Map;

public class LFUCache<K,V> implements Cache<K,V>{

  ///// 2-->    6 -->7---->8
  ///// CE1    CE5   CE8   CE10
  ///   CE2    CE3

  private int size;
 // private Map<K, V> resMap;
  private Map<K, Integer> freqMap;
  private LinkedList<CacheElement<K,V>> doublyLinkedList;

  @Override
  public void set(K key, V value) {

  }

  @Override
  public V get(K key) {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public void clear() {

  }
}
