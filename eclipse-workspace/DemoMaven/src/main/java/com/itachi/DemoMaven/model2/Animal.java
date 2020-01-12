package com.itachi.DemoMaven.model2;

import java.util.Random;

import org.springframework.stereotype.Component;


public class Animal {
	private String feedType;
	private String liveOn;
	private String speciName;
	
	public Animal() {
		super();
	}

	public Animal(String feedType, String liveOn, String speciName) {
		super();
		this.feedType = feedType;
		this.liveOn = liveOn;
		this.speciName = speciName;
	}

	public String getFeedType() {
		return feedType;
	}

	public void setFeedType(String feedType) {
		this.feedType = feedType;
	}

	public String getLiveOn() {
		return liveOn;
	}

	public void setLiveOn(String liveOn) {
		this.liveOn = liveOn;
	}

	public String getSpeciName() {
		return speciName;
	}

	public void setSpeciName(String speciName) {
		this.speciName = speciName;
	}

	@Override
	public String toString() {
		return "Animal [feedType=" + feedType + ", liveOn=" + liveOn + ", speciName=" + speciName + "]";
	}
	public void eat()
	{
		System.out.println("eating...");
	}
	public int age()
	{
		return new Random(100).nextInt();
	}
	public String sleep()
	{
		System.out.println("Sleeping...");
		return "Sleeping...";
	}
	public int kills()
	{
		return 4/0;
	}
	
}
