package com.itachi.DemoMaven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itachi.DemoMaven.model.Name;
import com.itachi.DemoMaven.model.Shinobi;

public class Main1 implements Main{
	Shinobi shinobi = null;
    Name name=null;
	public void invokXmlContext()
	{
		ApplicationContext contexXml = new ClassPathXmlApplicationContext("config.xml");
	    shinobi = (Shinobi)contexXml.getBean("shinobi");
		  System.out.print(shinobi);
	}
	public void invokAnnotationContext()
	{
		
		  ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		  System.out.println(name); 
		  context.getBean(Shinobi.class); 
		  shinobi.getClan().getVillage().setName("hidden leaf");
		  shinobi.getClan().setName("Uchiha");
		  shinobi.getName().setFirstName("Sasuke");
		  System.out.print(shinobi);
	}
}
