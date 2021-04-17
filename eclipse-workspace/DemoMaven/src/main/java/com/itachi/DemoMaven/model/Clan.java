package com.itachi.DemoMaven.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("clannn")
public class Clan {
	private String name;
	private String speciality;
	@Autowired
	private Village village;
	public String getName() {
		return name;
	}
	public Clan() {
		super();
		System.out.println("clan bean created.");
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public Village getVillage() {
		return village;
	}
	public void setVillage(Village village) {
		this.village = village;
	}
	public Clan(String name, String speciality, Village village) {
		super();
		this.name = name;
		this.speciality = speciality;
		this.village = village;
	}
	public Clan(String name, Village village) {
		super();
		this.name = name;
		this.speciality = "none";
		this.village = village;
	}
	@Override
	public String toString() {
		return "Clan [name=" + name + ", speciality=" + speciality + ", village=" + village + "]";
	}
	
}
