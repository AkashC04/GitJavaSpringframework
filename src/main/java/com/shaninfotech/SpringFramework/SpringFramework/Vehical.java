package com.shaninfotech.SpringFramework.SpringFramework;

import org.springframework.stereotype.Component;

@Component
public class Vehical {
    private int veh_no;
    private String vehName;
    public Vehical() {
    	
    }
	public int getVeh_no() {
		return veh_no;
	}
	public void setVeh_no(int veh_no) {
		this.veh_no = veh_no;
	}
	public String getVehName() {
		return vehName;
	}
	public void setVehName(String vehName) {
		this.vehName = vehName;
	}
	@Override
	public String toString() {
		return "Vehical [veh_no=" + veh_no + ", vehName=" + vehName + "]";
	}
    
}
