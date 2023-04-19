package com.ll;

public class Main {
}

class MyArrayList<T> {
    private int index;
    private int size;
    private T elements;
    private MyArrayList<T> prevArr;
    private MyArrayList<T> nextArr;
    //private MyArrayList<T> myList;

    public MyArrayList(){
        this.size = 0;
        this.index = -1;
        this.prevArr = null;
        this.nextArr = null;
    }

    public MyArrayList(int size , MyArrayList<T> prevArr) {
        this.size = size;
        this.prevArr = prevArr;
        nextArr = null;
    }

    public boolean add(T elements){
        MyArrayList<T> now ;
        for(now = this ; now.nextArr != null ; now = now.nextArr) ;

        now.elements = elements;
        now.index = index+1;
        now.size++;
        //now.myList = new MyArrayList<>(now.size, now);
        //now.nextArr = now.myList;
        now.nextArr = new MyArrayList<>(now.size, now);
        return true;
    }

    public int size(){
        MyArrayList<T> now;
        for( now = this ; now.nextArr != null ; now = now.nextArr);

        return now.size;
    }

    public T get(int index){
        for( MyArrayList<T> now = this ; now.nextArr != null ; now = nextArr){
            if(now.index == index) return now.elements;
        }
        return null;
    }
}