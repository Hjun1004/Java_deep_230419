package com.ll.exam1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MyHashMapTest {

    @Test
    @DisplayName("size()")
    void t1(){
        MyHashMap<String, Integer> map = new MyHashMap<>();
        assertThat(map.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("put()")
    void t2(){
        MyHashMap<String, Integer> map = new MyHashMap<>();
        assertThat(map.put("철수", 22)).isNull();
        assertThat(map.put("영희", 25)).isNull();
    }

    @Test
    @DisplayName("get 구현")
    void t3(){
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("철수", 22);
        map.put("영희", 25);

        assertThat(map.get("철수")).isEqualTo(22);
        assertThat(map.get("영희")).isEqualTo(25);

    }

}
