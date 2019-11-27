package com.itachi.DemoMaven.model;

import org.springframework.stereotype.Component;

@Component
public class Village {
	public Village() {
		super();
		System.out.println("village bean created.");
	}
	private String name;
	private String leader;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	@Override
	public String toString() {
		return "Village [name=" + name + ", leader=" + leader + "]";
	}
	
}
