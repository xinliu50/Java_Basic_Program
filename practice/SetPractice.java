package practice;
import java.util.*;
import static org.junit.Assert.*;


public class SetPractice {
	public static void main(String []args){
		Map<String,Product> productsByName = new HashMap<>();
		
		Map<String,Integer> myNum = new HashMap<>();
		myNum.put("a",1);
		myNum.put("b",2);
		myNum.put("c",3);
		myNum.put("d",4);
		myNum.put("e",5);
		
		print(myNum);
		
		myNum.compute("e", (key,val)-> val > 5 ? 1 : 0);
		print(myNum);


	}
	public static void print(Object o) {
		System.out.print(o);
	}

}
class Product{
	private String name;
	private String description;
	private List<String> tags;
	
	Product(String name,String description, List<String>tags){
		this.name = name;
		this.description = description;
		this.tags = tags;
	}
	String getName() {
		String temp = name;
		return temp;
	}
	String getDescription() {
		String temp = description;
		return temp;
	}
	List<String> getTags(){
		List<String> temp = this.tags;
		return temp;
	}
	void setName(String name) {
		this.name = name;
	}
	void setDescription(String description) {
		this.description = description;
	}
	void SetTags(List<String> tags) {
		this.tags = tags;
	}
	void print() {
		System.out.print("Name: " + name + "\n");
		System.out.print("Description: " + description + "\n");
		System.out.print(tags + "\n");
	}
	Product addTagsOfOtherProduct(Product product) {
		this.tags.addAll(product.getTags());
		return this;
	}
}