package practice;

public class ArrayPractice {
	public static void main(String []args) {
		Array arr = new Array();
		arr.print();
		arr.add(1);
		arr.add(12);
		arr.add(31);
		arr.add(10);
		arr.add(110);
		arr.print();
		arr.add(141);
		arr.add(10001);
		arr.print();
		arr.add(3,70);
		arr.print();
	}
	
}

class Array{
	private int[] myArray;
	private int size;
	
	Array(){
		myArray = new int[7];
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
	
}