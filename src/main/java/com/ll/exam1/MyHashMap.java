package com.ll.exam1;

public class MyHashMap<K, V> {
    private int size = 0;
    private final Object[] keys;
    private final Object[] values;

    public MyHashMap() {
        this(2);
    }

    public MyHashMap(int arrayLength){
        keys = new Object[arrayLength];
        values = new Object[arrayLength];
    }

    public int size() {
        return 0;
    }

    public V put(K key, V value) {
        keys[size] = key;
        values[size] = value;

        size++;

        return null;
    }

    public V get(K key) {
        int indexOfKey = indexOfKey(key);

        if(indexOfKey == -1) return null;

        return (V)values[indexOfKey];
    }

    public int indexOfKey(K key){
        for(int i = 0 ; i < size ; i++){
            if(keys[i].equals(key)) return i;
        }
        return -1;
    }
}
