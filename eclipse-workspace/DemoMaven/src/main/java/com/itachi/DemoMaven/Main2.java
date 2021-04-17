package com.itachi.DemoMaven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itachi.DemoMaven.Aspects.AnimalAsp;
import com.itachi.DemoMaven.model2.Animal;

public class Main2 implements Main
{
	ApplicationContext xmlContext=null;
	public Main2() {
		// TODO Auto-generated constructor stub
	}
	
	public void invokXmlContext()
	{
		xmlContext= new ClassPathXmlApplicationContext("config2.xml");
		//AnimalAsp asp=(AnimalAsp)xmlContext.getBean("animal_asp");
		Animal animal =(Animal)xmlContext.getBean("animal");
		
		System.out.println(animal);
		System.out.println(animal.age()); 
		System.out.println(animal.sleep());
		System.out.println("live on "+animal.getLiveOn());
		animal.setSpeciName("Cheetha");
		System.out.println("kills "+animal.kills());
	}

	public void invokAnnotationContext() {
		// TODO Auto-generated method stub
		
	}
}
