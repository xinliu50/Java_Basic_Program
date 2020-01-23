package practice;
//what is hash table?
//a data structure that contains key-value pairs
import java.util.*;



public class Hash {
	public static void main(String []args) {
		HashTable hash = new HashTable(10);
		hash.set("pink","#ffff2837");
		hash.set("pink","#ffff2837");
		hash.set("black","mmmmm");
		hash.set("yellow","#ff2735");
		hash.set("blue","#wwsksksk");
		print(hash);
		print(hash.keys());
		println("values");
		print(hash.values());
		
	}
	public static void println(Object o) {
		System.out.println(o);
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void print(HashTable table) {
		for(int i = 0; i < table.keyMap.length; i ++) {
			println("index:" + i + " ");
			if(table.keyMap[i] != null) {
				for(int j = 0; j < table.keyMap[i].size(); j ++) {
					print(" <" + table.keyMap[i].get(j).getKey() + "," + table.keyMap[i].get(j).getValue() + ">->");
				}
				println("");
			}else {
				println("null");
			}
		}
	}
}


class HashTable{
	
	ArrayList<Pair>[] keyMap;
	
	HashTable(int size){
		keyMap = (ArrayList<Pair>[])new ArrayList[size];
	}
	
	int hashFunc(String key){
		int total = 0;
		int weirdPrime = 31; 
		for (int i = 0; i < Math.min (key.length(), 100); i++) {
			char c = key.charAt(i);
		    int value = (int)c - 96;
		    total = (total * weirdPrime + value) % keyMap.length;
		}
		return total;	
	}
	int get(String key) {
		int index = hashFunc(key);
		if(keyMap[index] != null) {
			for(int i = 0; i < keyMap[index].size(); i ++) {
				if(keyMap[index].get(i).getKey() == key)
					return index;
			}
		}
		return -1;
	}
	void set(String key, String value) {
		int index = hashFunc(key);
		if(keyMap[index] == null) {
			keyMap[index] = new ArrayList();
		}
		Pair myPair = new Pair(key,value);
		keyMap[index].add(myPair);
	}
	ArrayList<String> keys() {
		var keys = new ArrayList<String>();
		
		for(int i = 0; i < keyMap.length; i ++) {
			if(keyMap[i] != null) {
				for(int j = 0; j < keyMap[i].size(); j ++) {
					keys.add(keyMap[i].get(j).getKey());
				}
			}
		}
		return keys;
	}
	ArrayList<String> values(){
		var values = new ArrayList<String>();
		for(int i = 0; i < keyMap.length; i ++) {
			if(keyMap[i] != null) {
				for(int j = 0; j < keyMap[i].size(); j ++) {
					values.add(keyMap[i].get(j).getValue());
				}
			}
		}
		return values;
	}	
}
class Pair{
	private String key;
	private String value;
	Pair(){
		key = "";
		value = "";
	}
	Pair(String key, String value){
		this.key = key;
		this.value = value;
	}
	String getKey() {
		return key;
	}
	String getValue() {
		return value;
	}
}
