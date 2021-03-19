package com.itachi.DemoSpringBoot.test;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class XmlParser {
	StringBuilder json = new StringBuilder("{}");
	String xml = "<students><student><name>itachi</name><id>1</id><marks><sub><name>math</name><score>98</score></sub><sub><name>science</name><score>97</score></sub></marks><awards><award><name>a1</award><for>running</for></award></awards></student></students>";
	String xml1 = "<marks><sub><name>math</name><score>98</score></sub><sub><name>science</name><score>97</score></sub></marks>";
	String xml2 = "<name> itachi </name>";
	String sTag = "(<[a-zA-Z]+>)";
	String text = "(\\w*)";
	String eTag = "(</[a-zA-Z]+>)";
	String childTag = "("+sTag+"\\s*"+text+"\\s*"+eTag+")*";
	String multiTag = "(\\s*"+sTag+"\\s*"+childTag+"\\s*"+eTag+"\\s*)*";
	String parentTag = "(\\s*"+sTag+"\\s*"+childTag+multiTag+"\\s*"+eTag+"\\s*)*";
	String xmlTag = "("+sTag+"\\s*"+childTag+multiTag+parentTag+"\\s*"+eTag+")";
	Pattern pattern = Pattern.compile(sTag);
	Matcher matcher = pattern.matcher(xml);
	public void testParseXml()
	{
		System.out.println(xmlTag);
		matcher = pattern.matcher(xml);
		if(matcher.find())
		{
			System.out.println(matcher.group().toString());
			
		}
		System.out.println(matcher.matches());
		//System.out.println(matcher.group(2).toString());
		System.out.println(matcher.groupCount());
		//Arrays.asList(pattern.split(xml)).forEach( s -> System.out.println(s));
	}
	
	@Test
	public void parseXml()
	{
		Stack innerStack = new Stack(), outterStack = new Stack();
		String tag = "";
		tag = next(sTag, xml);
		System.out.println(tag);
		String tagName = this.getTagName(tag);
		int endTagIndex = this.endAt(tagName, xml);
		System.out.println(xml);
		
	}
	public String inner(String tagName)
	{
		return "";
	}
	public String outer()
	{
		return "";
	}
	private String getTagName(String tag)
	{
		String name = "";
		if(tag.startsWith("</"))
		{
			name = tag.substring(2,tag.length());
		}
		else if(tag.startsWith("<"))
		{
			name = tag.substring(1,tag.length());
		}
		return tag;
	}
	private static Boolean matches(String regex, String input)
	{
		return Pattern.matches(regex, input);
	}
	private  String next(String regex, String input)
	{
		String result = "";
		matcher = Pattern.compile(regex).matcher(input);
		if(matcher.find())
		{
			result = matcher.group();
		}
		return result;
	}
	private int endAt(String tagName,String input)
	{
		 return input.indexOf("</"+tagName+">");
	}
}
