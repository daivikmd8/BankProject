package com.Bank.DTO;

public class Customer {
	
	//	Database Columns
	
	private long accno;
	private String name;
	private long phone;
	private String mail;
	private double bal;
	private int pin;
	
	// CONSTRUCTORS
	
	public Customer(long accno, String name, long phone, String mail, double bal, int pin) {
		super();
		this.accno = accno;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.bal = bal;
		this.pin = pin;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	
	// GETTERS AND SETTERS
	
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Customer [accno=" + accno + ", name=" + name + ", phone=" + phone + ", mail=" + mail + ", bal=" + bal
				+ ", pin=" + pin + "]";
	}
	
	

}