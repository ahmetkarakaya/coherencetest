package com.ttech.tims.imos.data.dto;

import java.io.IOException;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
import com.ttech.tims.imos.data.entry.Person;

public class PersonDTO  implements PortableObject{

	Person p;
	
	public PersonDTO() {
	
	}
	
	public PersonDTO(Person p) {
		this.p =p;
	}

	@Override
	public void readExternal(PofReader arg0) throws IOException {
		p= new Person(arg0.readString(0),arg0.readString(1),arg0.readInt(2));
		//p=(Person) arg0.readObject(0);
	}

	@Override
	public void writeExternal(PofWriter arg0) throws IOException {
		arg0.writeString(0, p.getName());
		arg0.writeString(1, p.getSirname());
		arg0.writeInt(2, p.getAge());
		
		//arg0.writeObject(0,p);
	}

	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}
	

}
