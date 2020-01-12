package com.itachi.DemoMaven.model3;

import com.itachi.DemoMaven.model.Name;

public class Student {
	private int id;
	private Name name;
	private Progress progress;
	
	
	public Student() {
		super();
		System.out.println("student involked.");
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", progress=" + progress + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Progress getProgress() {
		return progress;
	}

	public void setProgress(Progress progress) {
		this.progress = progress;
	}
}
