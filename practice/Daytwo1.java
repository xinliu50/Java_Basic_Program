package practice;

import java.util.Date;

public class Daytwo1 {
	public static void main(String[]args) {
		Bank myBank = new Bank();
		println(myBank);
		myBank.update();
		println("\nAfter update, saving accounts should be added interest\n");
		println(myBank);
		myBank.payDividend();
		println("\nAfter paying\n");
		println(myBank);
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void println(Object o) {
		System.out.println(o);
	}
}
class Account{
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	public Account(){
		this.id = 0;
		this.balance = 0;
		annualInterestRate = 0;
		dateCreated = new Date();
	}
	public Account(int id, double balance){
		this.id = id;
		this.balance = balance;
		dateCreated = new Date();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public double getMonthlyInterestRate() {
		return this.annualInterestRate/12;
	}
	public double getMonthlyInterest() {
		return getMonthlyInterestRate()/100*this.balance;
	}
	public void withdraw(double amount) {
		if(amount > balance) {
			System.out.print("Not enough balance\n");
			return;
		}
		this.balance -= amount;
		System.out.println("After withdraw $" + amount + ", your still have $" + balance);
	}
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println("After deposit $" + amount + ", your still have $" + balance);
	}
	public String toString() {
		return "Account ID: " + this.id + "\nBalance: $" + this.balance + "\nAnnual "
				+ "interest: " + this.annualInterestRate + "%\nCreateDate: " + this.dateCreated+"\n";
	}
}
class SavingAccount extends Account{
	//I am not sure if this is monthly interest? or annual? or one-time
	//I am assuming this is monthly interest
	private double interest;
	
	public SavingAccount(){
		interest = 0;
	}
	public SavingAccount(int id, double balance){
		super(id,balance);
	}
	public void addInterest(double interest) {
		this.interest = interest;
		deposit(interest);
	}
	public double getInterest() {
		return this.interest;
	}
	public String toString() {
		return "SavingAccount ID: " + getId() + "\nBalance: $" + getBalance() + "\n" 
				+ "interest: " + this.interest + "%\nCreateDate: " + getDateCreated()+"\n";
	}
}
class CurrentAccount extends Account{
	private double overdraftLimit;
	
	public CurrentAccount(){
		super();
		overdraftLimit = 0;
		
	}
	public CurrentAccount(int id, double balance, double overdraftLimit){
		super(id,balance);
		this.overdraftLimit = overdraftLimit;
	}
	public void withdraw(double amount) {
		setBalance(getBalance()-amount);
		System.out.println("After withdraw $" + amount + ", your still have $" + getBalance()+"\n");
	}
	
	public void setLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	} 
	public double getOver() {
		return this.overdraftLimit;
	}
	public String toString() {
		return "CurrentAccount ID: " + getId() + "\nBalance: $" + getBalance() + "\n" 
				+ "interest: " + super.getAnnualInterestRate() + "%\nOverLimit: $" + getOver() + "\nCreateDate: " + getDateCreated()+"\n";
	}
	
}
class Bank implements bankInfo{
	 Account acc1 = new Account(111,300000);
	 Account acc2 = new Account(222,4000);
	 SavingAccount acc3 = new SavingAccount(333,30000);
	 SavingAccount acc4 = new SavingAccount(444,10000);
	 CurrentAccount acc5 = new CurrentAccount(555, 900, 1000);
	 CurrentAccount acc6 = new CurrentAccount(666, 100000,500000);
	 Account[] arr = new Account[100];
	 int number = 6;
	private static double BankAsset;
	public Bank(){
		acc1.setAnnualInterestRate(10);
		acc2.setAnnualInterestRate(5);
		acc5.setAnnualInterestRate(2);
		acc6.setAnnualInterestRate(7);
		arr[0] = acc1;
		arr[1] = acc2;
		arr[2] = acc3;
		arr[3] = acc4;
		arr[4] = acc5;
		arr[5] = acc6;
		for(int i = 0; i < 6; i ++) {
			BankAsset += arr[i].getBalance();
		}
		
	}
	public void update() {
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] instanceof SavingAccount) {
				SavingAccount saving = (SavingAccount)arr[i];
				saving.addInterest(4);
			}
			else if(arr[i] instanceof CurrentAccount) {
				CurrentAccount current = (CurrentAccount)arr[i];
				if(current.getBalance() <= current.getOver()*-1)
					System.out.println("You are in overdraft!");
			}
		}
	}
	@Override
	public void openAccount(int id, int balance) {
		// TODO Auto-generated method stub
		for(int i = 0; i < number; i ++) {
			if(id == arr[i].getId()) {
				System.out.println("Invalid account id!");
				return;
			}
		}
		Account newAccount = new Account(id,balance);
		arr[number] = newAccount;
		number ++;
	}
	@Override
	public void closeAccount(int id) {
		// TODO Auto-generated method stub
		for(int i = 0; i < number; i++) {
			if(arr[i].getId() == id) {
				for(int j = i; j < number-1; j++) {
					arr[j] = arr[j+1];
				}
				return;
			}
		}
		System.out.println("Can't find the account id");
	}
	//assuming this bank is paying dividend every month
	@Override
	public void payDividend() {
		// TODO Auto-generated method stub
		for(int i = 0; i < number; i++) {
			arr[i].deposit(arr[i].getMonthlyInterest());
			BankAsset -= arr[i].getMonthlyInterest();
		}
	}
	public String toString() {
		String result = "";
		for(int i = 0; i < number; i ++) {
			result += arr[i].toString()+"\n";
		}
		result += "Bank asset: $" + BankAsset + "\n";
		return result;
	}
	
}
interface bankInfo{
	void openAccount(int id, int balance);
	void closeAccount(int id);
	void payDividend();
}
