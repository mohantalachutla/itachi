package com.itachi.DemoMaven.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Shinobi {
	private Name name;
	private Clan clan;
	private String element;
	
	public Shinobi() {
		super();
		this.element = "none";
		System.out.println("shinobi bean created.");
	}
	
	public Shinobi(Name name, Clan clan, String element) {
		super();
		this.name = name;
		this.clan = clan;
		this.element = element;
		System.out.println("3 arg, shinobi bean created.");
	}

	public Clan getClan() {
		return clan;
	}
	public void setClan(Clan clan) {
		this.clan = clan;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Shinobhi [name=" + name + ", clan=" + clan + ", element=" + element + "]";
	}
}
