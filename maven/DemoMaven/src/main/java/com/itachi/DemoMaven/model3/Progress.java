package com.itachi.DemoMaven.model3;

import java.util.Map;

public class Progress {
	private int id;
	private Map<Subject,Integer> record = null;
	
	public Progress() {
		super();
		System.out.println("progress involked.");
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Map<Subject, Integer> getRecord() {
		return record;
	}


	public void setRecord(Map<Subject, Integer> record) {
		this.record = record;
	}


	@Override
	public String toString() {
		return "Progress [id=" + id + ", record=" + record + "]";
	}
}
