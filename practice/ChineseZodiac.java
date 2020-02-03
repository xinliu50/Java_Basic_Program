package practice;

import java.util.*;

public class ChineseZodiac {

	public static void main(String[] args) {

		Year y = new Year();
		print(y.ls);
		System.out.println(sexagenary(1971,y.ls));
		System.out.println(sexagenary(1927,y.ls));
		System.out.println(sexagenary(1974,y.ls));
	}
	public static void print(ArrayList<Year>ls) {
		for(int i = 0; i < ls.size(); i ++) {
			System.out.println(ls.get(i));
		}
	}
	public static String sexagenary(int y, ArrayList<Year>ls) {
		int mol = y%10;
		String stem;
		String branch;
		if(mol == 4 || mol == 5)
			stem = ls.get(0).getStem();
		else if(mol == 6 || mol == 7)
			stem = ls.get(2).getStem();
		else if(mol == 8 || mol == 9)
			stem = ls.get(4).getStem();
		else if(mol == 0 || mol == 1)
			stem = ls.get(6).getStem();
		else 
			stem = ls.get(8).getStem();
		
		int dis = y - 1984;
		int disMos = dis%12;
		if(disMos < 0) {
			disMos += 12;
		}
		if(disMos == 0)
			branch = ls.get(0).getBranch();
		else if(disMos == 1)
			branch = ls.get(1).getBranch();
		else if(disMos == 2)
			branch = ls.get(2).getBranch();
		else if(disMos == 3)
			branch = ls.get(3).getBranch();
		else if(disMos == 4)
			branch = ls.get(4).getBranch();
		else if(disMos == 5)
			branch = ls.get(5).getBranch();
		else if(disMos == 6)
			branch = ls.get(6).getBranch();
		else if(disMos == 7)
			branch = ls.get(7).getBranch();
		else if(disMos == 8)
			branch = ls.get(8).getBranch();
		else if(disMos == 9)
			branch = ls.get(9).getBranch();
		else if(disMos == 10)
			branch = ls.get(10).getBranch();
		else
			branch = ls.get(11).getBranch();
		return stem + " " + branch;
	}
}
class Year{
	private String stem;
	private String Branch;
	private int year;
	public ArrayList<Year> ls;
	
	Year(){
		ls = generateList();
	}
	Year(int year, String stem, String Branch){
		this.year = year;
		this.stem = stem;
		this.Branch = Branch;
	}
	public ArrayList<Year> generateList(){
		var ls = new ArrayList<Year>();
		ls.add(new Year(1984,"Wood","Rat"));
		ls.add(new Year(1985,"Wood","Ox"));
		ls.add(new Year(1986,"Fire","Tiger"));
		ls.add(new Year(1987,"Fire","Rabbit"));
		ls.add(new Year(1988,"Earth","Dragon"));
		ls.add(new Year(1989,"Earth","Snake"));
		ls.add(new Year(1990,"Metal","Horse"));
		ls.add(new Year(1991,"Metal","Sheep"));
		ls.add(new Year(1992,"Water","Monkey"));
		ls.add(new Year(1993,"Water","Rooster"));
		ls.add(new Year(1994,"Wood","Dog"));
		ls.add(new Year(1995,"Wood","Pig"));
		ls.add(new Year(1996,"Fire","Rat"));
		ls.add(new Year(1997,"Fire","Ox"));
		return ls;
	}
	public String getStem() {
		return stem;
	}
	public void setStem(String stem) {
		this.stem = stem;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Year [stem=" + stem + ", Branch=" + Branch + ", year=" + year +"]";
	}
	
}