package com.ttech.tims.imos.data.entry;

public class Person {
	
String name;
String sirname;
int age;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSirname() {
	return sirname;
}
public void setSirname(String sirname) {
	this.sirname = sirname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Person(String name, String sirname, int age) {
	super();
	this.name = name;
	this.sirname = sirname;
	this.age = age;
}




}
