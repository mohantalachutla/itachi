package com.itachi.DemoMaven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itachi.DemoMaven.model3.Student;

public class Main3 implements Main{
 public void invokXmlContext()
 {
	 Student student = null;
	 ApplicationContext xmlContext = new ClassPathXmlApplicationContext("student_config.xml");
	 student = (Student)xmlContext.getBean("suresh");
	 System.out.println(student);
 }
 public void invokAnnotationContext() {
	// TODO Auto-generated method stub
	
 }
}
