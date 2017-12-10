package com.ttech.tims.imos.data.dto;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
import com.ttech.tims.imos.data.entry.SmsEntry;

public class SendSmsEntryDTO2 implements PortableObject{
	SmsEntry smsEtry;
	
	public SendSmsEntryDTO2(){
		
	}
	
	public SendSmsEntryDTO2(SmsEntry smsEtry){
		this.smsEtry=smsEtry;
	}
	
	public final static SimpleDateFormat dateFormatSeferDate = new SimpleDateFormat("dd.MM.yyyy");
	@Override
	public void readExternal(PofReader arg0) throws IOException {
		smsEtry = new SmsEntry(arg0.readString(0), arg0.readDate(1), arg0.readInt(2));
		
	}

	@Override
	public void writeExternal(PofWriter arg0) throws IOException {
		arg0.writeString(0, smsEtry.getUsername());
		arg0.writeDate(1, smsEtry.getSmsSendDate());
		arg0.writeInt(2, smsEtry.getNumberOfSmsSend());
		
	}
	
	public String getId(){
		return smsEtry.getUsername()+dateFormatSeferDate.format(smsEtry.getSmsSendDate());
	}

	public SmsEntry getSmsEtry() {
		return smsEtry;
	}

	public void setSmsEtry(SmsEntry smsEtry) {
		this.smsEtry = smsEtry;
	}
	
	

}
