package com.coding.basic;

import java.util.Arrays;

public class ArrayList implements List {
	
	private int size = 0;
	private final int DEFAULT_CAPACITY = 5;
	
	private Object[] elementData ;
	public ArrayList(){
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	public static void main(String[] args) {
		ArrayList list =new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(5,6);
		System.out.println(list);
		System.out.println("size="+list.size());
		System.out.println(list.get(0));
		list.remove(0);
		System.out.println(list);
		System.out.println("size="+list.size());
	}
	public void add(Object o){
		if(size < elementData.length) {
			elementData[size++] = o;
		}else{
			elementData = grow(elementData,DEFAULT_CAPACITY);
			elementData[size++] = o ;
		}
	}
	public void add(int index, Object o){
		size++;
		if(size > elementData.length){
			elementData = grow(elementData,DEFAULT_CAPACITY);
		}
		if(index < elementData.length) {
			Object temp = elementData[index];
			elementData[index] = o;
			for(int i = size-1 ; i>index ;i-- ){
				elementData[i]=elementData[i-1];
			}
			elementData[index+1] = temp;
		}else{}
	}
	
	public Object get(int index){
		if(index<size){
			return elementData[index];
		}
		else{
			throw new IndexOutOfBoundsException();
		}
	}
	
	public Object remove(int index){
		Object o = null ;
		if(index < size){
			size--;
			o = get(index) ;
			for(int i = index ; i< size;i++){
				elementData[i] = elementData[i+1];
			}
			elementData[size]=null;
		}else{
			throw new IndexOutOfBoundsException();
		}
		return o;
	}
	
	public int size(){
		return size;
	}
	
	public Iterator iterator(){
		return null;
	}
	public Object[] grow(Object[] src ,int capacity){
		Object[] dest = new Object[src.length+capacity];
		System.arraycopy(src, 0, dest, 0, src.length);
		return  dest;
	}

	@Override
	public String toString() {
		return "ArrayList [elementData=" + Arrays.toString(elementData) + "]";
	}
	
}
