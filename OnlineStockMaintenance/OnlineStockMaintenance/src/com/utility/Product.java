package com.utility;

public class Product {
	int pid;
	String pname;
	float pprice;
	String pcatagory;
	public Product(){}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPprice() {
		return pprice;
	}
	public void setPprice(float pprice) {
		this.pprice = pprice;
	}
	public String getPcatagory() {
		return pcatagory;
	}
	public void setPcatagory(String pcatagory) {
		this.pcatagory = pcatagory;
	}
	public Product(int pid, String pname, float pprice, String pcatagory) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pcatagory = pcatagory;
	}
	

}
