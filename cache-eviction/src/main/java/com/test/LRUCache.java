package com.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K,V> implements Cache<K,V> {

  private int size;
  private Map<K, Integer> linkedListMap;
  private LinkedList<CacheElement<K,V>> doublyLinkedList;


  public void LRUCache(int size){
    this.size=size;
    linkedListMap =new HashMap<>();
    doublyLinkedList= new LinkedList<>();

  }
  @Override
  public void set(K key, V value) {
   if(linkedListMap.size()>=size ){
     CacheElement<K,V> element =doublyLinkedList.removeLast();
     linkedListMap.remove(element.getKey());
     size--;
   }
   CacheElement<K,V> cacheElement = new CacheElement<>(key, value);
   doublyLinkedList.addFirst(cacheElement);
   linkedListMap.put(key, 0);
   size++;

  }

  @Override
  public V get(K key) {
   if(linkedListMap.containsKey(key)){
     int index = linkedListMap.get(key);
     CacheElement<K,V> res = doublyLinkedList.get(index);
     doublyLinkedList.remove(index);
     doublyLinkedList.addFirst(res);
     return res.getValue();

   }
   return  null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void clear() {
    linkedListMap =new HashMap<>();
    doublyLinkedList= new LinkedList<>();
    size=0;
  }
}
