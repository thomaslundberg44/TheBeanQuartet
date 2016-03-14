package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


public class MccDataId implements Serializable {

	// auto generated serial id
	private static final long serialVersionUID = 7007673299604521440L;
	
	private int Mcc;
	private int Mnc;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Mcc;
		result = prime * result + Mnc;
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MccDataId other = (MccDataId) obj;
		if (Mcc != other.Mcc)
			return false;
		if(Mnc != other.Mnc)
			return false;
		return true;
	}

	public int getMcc() {
		return Mcc;
	}

	public void setMcc(int mcc) {
		Mcc = mcc;
	}

	public int getMnc() {
		return Mnc;
	}

	public void setMnc(int mnc) {
		Mnc = mnc;
	}
	

}