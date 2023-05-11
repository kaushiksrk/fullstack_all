package com.cgi;

public class Address {
	
	private String addr1;
	private String addr2;
	private String pincode;
	
	public Address(String addr1, String addr2, String pincode) {
		super();
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.pincode = pincode;
	}
	
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addr1=" + addr1 + ", addr2=" + addr2 + ", pincode=" + pincode + "]";
	}
}
