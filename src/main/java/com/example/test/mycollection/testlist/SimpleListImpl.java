package com.example.test.mycollection.testlist;


public class SimpleListImpl<T> extends SimpleList<T> {

    public SimpleListImpl(){
        this.elementData = new Object[4];
    }
    public SimpleListImpl(int capacity){
        this.elementData = new Object[capacity];
    }

    public boolean add(T e) {

        if(size >= elementData.length){
            Object[] nElementData = new Object[this.elementData.length * 2];
            System.arraycopy(this.elementData,0,nElementData,0,this.elementData.length);
            this.elementData = nElementData;
        }

        elementData[size++] = e;
        return true;
    }

    public T get(int index) {
        if(index >= elementData.length)
            return null;
        return (T)elementData[index];
    }


    public boolean isEmpty() {

        return size == 0;

    }

    public int size() {
        return this.size;

    }

    public T remove(Object o) {
        if( o ==null){
            return null;
        }
        for(int i=0; i< size ; i++){
            if( o.equals( elementData[i])){
                Object elementDatum = elementData[i];
                System.arraycopy(elementData,i+1,elementData,i,elementData.length-i-1);
                elementData[--size] = null;//GC;
                return (T)elementDatum;
            }
        }
        return null;

    }

    public static void main(String[] args) {
        SimpleListImpl<String> simpleList = new SimpleListImpl<>();
       for(int i=0; i<10; i++){
           simpleList.add(String.valueOf(i));

       }

        simpleList.remove("2");
        simpleList.remove("5");
        //simpleList.add("2");
        //simpleList.add("4");
        for(int i=0; i<simpleList.size(); i++){
            System.out.println( simpleList.get(i));

        }

    }
}
