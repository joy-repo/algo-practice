package com.test;

public interface Cache<K,V> {

  void set(K key, V value);
  V get(K key);
   int size();

   void clear();

}
