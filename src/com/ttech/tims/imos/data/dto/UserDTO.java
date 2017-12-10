package com.ttech.tims.imos.data.dto;

import java.io.IOException;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
import com.ttech.tims.imos.data.entry.User;

public class UserDTO implements PortableObject{
	
	User user;
	

	@Override
	public void readExternal(PofReader in) throws IOException {
		user = new User(in.readString(0), in.readString(1), in.readString(2),in.readInt(3));
//		user.setId(in.readString(0));
//		user.setName(in.readString(1));
//		user.setSurname(in.readString(2));
	}

	@Override
	public void writeExternal(PofWriter out) throws IOException {
		out.writeString(0, user.getId());
		out.writeString(1, user.getName());
		out.writeString(2, user.getSurname());
		out.writeInt(3, user.getSize());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
