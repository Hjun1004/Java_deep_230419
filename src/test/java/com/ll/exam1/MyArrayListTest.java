package com.ll.exam1;

import com.ll.TestUt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyArrayListTest {
    @Test
    @DisplayName("size()")
    void t1() {
        MyArrayList<String> list = new MyArrayList<>();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("add(\"사과\")")
    void t2() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("사과");
        list.add("포도");

        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("get(1)")
    void t3() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("사과"); // data[0];
        list.add("포도"); // data[1];

        assertThat(list.get(0)).isEqualTo("사과"); // data[0];
        assertThat(list.get(1)).isEqualTo("포도"); // data[1];
    }

    @Test
    @DisplayName("data(배열)의 크기가 자동으로 늘어나야 한다.")
    void t4() {
        MyArrayList<String> list = new MyArrayList<>();

        int dataLength1 = ((Object[]) TestUt.getFieldValue(list, "data", null)).length;

        IntStream.rangeClosed(0,dataLength1)
                .forEach(index -> list.add("사과 %d".formatted(index)));

        int dataLength2 =  ((Object[]) TestUt.getFieldValue(list, "data", null)).length;

        assertThat(dataLength2).isGreaterThan(dataLength1);
    }

    @Test
    @DisplayName("MyArrayList 초기화(new) 시 생성자 인자로 data 배열의 사이즈 지정")
    void t5() {
        MyArrayList<String> list = new MyArrayList<>(200);
        int dataLength =  ((Object[]) TestUt.getFieldValue(list, "data", null)).length;

        IntStream.range(0,dataLength)
                .forEach(index -> list.add("사과 %d".formatted(index)));


        assertThat(dataLength).isEqualTo(200);
    }

    @Test
    @DisplayName("디버그 : 데이터를 많이 넣으면 배열증가가 많이 발생함")
    void t6() {
        MyArrayList<String> list = new MyArrayList<>();
        list.debug = true;

        // IntStream.range(0, 10); = [0, ... 9] 까지의 int 스트림 발생
        // 딱 1번 넘칠만큼의 데이터를 넣는다.
        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));
    }

    @Test
    @DisplayName("디버그 : 애초에 큰 배열로 만들면 데이터를 많이 넣어도 배열증가가 빈번하지 않음")
    void t7() {
        MyArrayList<String> list = new MyArrayList<>(25);
        list.debug = true;

        // IntStream.range(0, 10); = [0, ... 9] 까지의 int 스트림 발생
        // 딱 1번 넘칠만큼의 데이터를 넣는다.
        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));
    }

    @Test
    void t8() {
        MyArrayList<String> list = new MyArrayList<>(25);

        list.add("Element1");
        list.add("Element2");
        list.add("Element1");
        assertThat(list.indexOf("Element1")).isEqualTo(0);
        assertThat(list.indexOf("Element2")).isEqualTo(1);
        assertThat(list.indexOf("Element3")).isEqualTo(-1);
    }

    @Test
    @DisplayName("add(true)")
    void t09() {
        MyArrayList<Boolean> list = new MyArrayList<>();
        list.add(true);
        list.add(false);

        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("get(1)")
    void t10() {
        MyArrayList<Boolean> list = new MyArrayList<>();

        list.add(true);
        list.add(false);

        boolean e0 = list.get(0);
        boolean e1 = list.get(1);

        assertThat(e0).isEqualTo(true);
        assertThat(e1).isEqualTo(false);
    }

    @Test
    @DisplayName("contains Test")
    void t11() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("Element1");
        list.add("Element2");
        assertThat(list.contains("Element1")).isEqualTo(true);
        assertThat(list.contains("Element3")).isEqualTo(false);
    }

    @Test
    void testRemove() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        assertThat(list.remove(1)).isEqualTo("Element2");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    void testAddAtIndex() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        list.add(1, "Element4");
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0)).isEqualTo("Element1");
        assertThat(list.get(1)).isEqualTo("Element4");
        assertThat(list.get(2)).isEqualTo("Element2");
        assertThat(list.get(3)).isEqualTo("Element3");
    }

    @Test
    void testSet() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        assertEquals("Element1", list.set(0, "Element4"));
        assertEquals(3, list.size());
        assertEquals("Element4", list.get(0));
        assertEquals("Element2", list.get(1));
        assertEquals("Element3", list.get(2));
    }
}

