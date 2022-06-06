package com.miracle.jms.message;

public class ProductDetails {
private int product_id,product_price;
private String product_name;
public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public int getProduct_price() {
	return product_price;
}
public void setProduct_price(int product_price) {
	this.product_price = product_price;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public ProductDetails(int product_id, int product_price, String product_name) {
	super();
	this.product_id = product_id;
	this.product_price = product_price;
	this.product_name = product_name;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}


}
