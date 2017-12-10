package com.ttech.tims.imos.data.entry;

import java.io.IOException;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

public class User  {

	private String id;
	private String name;
	private String surname;
	private int size =12;
	
	
	
	
	public User(String id, String name, String surname,int size) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.size =size;
	}

	/**
     * Gets User Id
     *
     * @return String id
     */
	public String getId() {
		return id;
	}

	/**
     * Sets User Id
     *
     * @param String id
     */
	public void setId(String id) {
		this.id = id;
	}

	/**
     * Gets User Name
     *
     * @return String name
     */
	public String getName() {
		return name;
	}
	
	/**
     * Sets User Name
     *
     * @param String name
     */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
     * Gets User Surname
     *
     * @return String surname
     */
	public String getSurname() {
		return surname;
	}
	
	/**
     * Sets User Surname
     *
     * @param String surname
     */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", size=" + size + "]";
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}	
	
	
}
