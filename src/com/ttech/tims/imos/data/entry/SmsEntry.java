/**
 * @author TTAHKARAKAYA
 */
package com.ttech.tims.imos.data.entry;

import java.util.Date;

public class SmsEntry {

	String username;
	Date smsSendDate;
	int numberOfSmsSend;

	
	
	public SmsEntry(String username, Date smsSendDate, int numberOfSmsSend) {
		super();
		this.username = username;
		this.smsSendDate = smsSendDate;
		this.numberOfSmsSend = numberOfSmsSend;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public Date getSmsSendDate() {
		return smsSendDate;
	}

	public void setSmsSendDate(Date smsSendDate) {
		this.smsSendDate = smsSendDate;
	}

	public int getNumberOfSmsSend() {
		return numberOfSmsSend;
	}

	public void setNumberOfSmsSend(int numberOfSmsSend) {
		this.numberOfSmsSend = numberOfSmsSend;
	}

	@Override
	public String toString() {
		return "SmsEntry [username=" + username + ", smsSendDate=" + smsSendDate + ", numberOfSmsSend=" + numberOfSmsSend + "]";
	}
	
	

}
