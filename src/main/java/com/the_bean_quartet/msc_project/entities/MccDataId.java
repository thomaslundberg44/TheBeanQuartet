package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MccDataId implements Serializable {

	// auto generated serial id
	private static final long serialVersionUID = 7007673299604521440L;
	
	@Column(name="Mcc")Integer mcc;
	@Column(name="Mnc")Integer mnc;
	public Integer getMcc() {
		return mcc;
	}
	public void setMcc(Integer mcc) {
		this.mcc = mcc;
	}
	public Integer getMnc() {
		return mnc;
	}
	public void setMnc(Integer mnc) {
		this.mnc = mnc;
	}
	@Override
	public int hashCode() {
		return Objects.hashCode(mcc+mnc);
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MccDataId))
			return false;
		MccDataId other = (MccDataId)obj;
		return (other.mcc.equals(this.mcc) 
				&& other.mnc.equals(this.mnc));
	}

}
