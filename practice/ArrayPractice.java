package practice;

public class ArrayPractice {
	public static void main(String []args)throws CloneNotSupportedException {
		Array arr = new Array();
	
		arr.add(1);
		arr.add(12);
		arr.add(31);
		arr.add(10);
		arr.add(110);
		arr.add(141);
		arr.add(10001);
		arr.add(3,70);
		arr.print();
		var myarr = arr.toArray();
		printArray(myarr);
		print("\n");
		print(arr.myArray.length);
		print(arr.myArray);
		arr.trimToSize();
		print("\n");
		print(arr.myArray.length);
		print(arr.myArray);
		
		
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void printArray(int[] a) {
		print("[");
		for(int i = 0; i < a.length; i++) {
			if(i == a.length-1) {
				print(a[i] + "]");
			}
			else {
				print(a[i] + ", ");
			}
		}
	}
	
}

class Array implements Cloneable{
	public  int[] myArray;
	public int size;
	
	Array(){
		myArray = new int[10];
		size = 0;
	}
	void print() {
		for(int i = 0; i < size; i ++)
			System.out.print(myArray[i] + ", ");
		System.out.print("\n");
	}
	int size() {
		return size;
	}
	void add(int num) {
		if(size < myArray.length) {
			myArray[size++] = num;
		}else {
			int[] newArray = new int[myArray.length*2];
			for(int i = 0; i < size; i ++) {
				newArray[i] = myArray[i];
			}
			newArray[size++] = num;
			myArray = newArray;
		}
	}
	void add(int index, int num) {
		if(index < 0 || index >= size()) {
			throw new IllegalArgumentException("Illegal index");
		}
		if(size < myArray.length) {
			for(int i = size-1; i >= index; i --) {
				myArray[i+1] = myArray[i];
			}
			myArray[index] = num;
		}
		else {
			int[] newArray = new int[myArray.length*2];
			for(int i = 0; i < index; i ++) {
				newArray[i] = myArray[i];
			}
			newArray[index] = num;
			for(int i = index; i < size; i ++) {
				newArray[i+1] = myArray[i];
			}
			myArray = newArray;
		}
		size++;
	}
	void clear() {
		int[] newArray = new int[20];
		myArray = newArray;
		size = 0;
	}
	Object cloneArray() {
		Array newArray = new Array();
		//1.deepcopy
//		newArray.myArray = new int[myArray.length];
//		for(int i = 0; i < size; i ++) {
//			newArray.myArray[i] = myArray[i];
//		}
//		newArray.size = size;
		//2.deep copy
//		newArray.myArray = myArray;
//		newArray.size = size;
		//3.shallow copy
		newArray = this;
		return newArray;
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	boolean contains(int num) {
		for(int i = 0; i < size; i ++) {
			if(myArray[i] == num)
				return true;
		}
		return false;
	}
	int get(int index) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("illegal index");
		}
		return myArray[index];
	}
	int indexOf(int num) {
		for(int i = 0; i < size; i ++) {
			if(myArray[i] == num)
				return i;
		}
		return -1;
	}
	int lastIndexOf(int num) {
		for(int i = size-1; i >= 0; i --) {
			if(myArray[i] == num)
				return i;
		}
		return -1;
	}
	int remove(int index) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("Illegal index");
		}
		int temp = myArray[index];
		for(int i = index; i < size-1; i++) {
			myArray[i] = myArray[i+1];
		}
		size --;
		return temp;
	}
	int[] toArray() {
		int[] newArray = new int[size];
		for(int i = 0; i < size; i++) {
			newArray[i] = myArray[i];
		}
		
		return newArray;
	}
	void trimToSize() {
		int[] newArr = new int[size];
		for(int i = 0; i < size; i++) {
			newArr[i] = myArray[i];
		}
		myArray = newArr;
	}
}