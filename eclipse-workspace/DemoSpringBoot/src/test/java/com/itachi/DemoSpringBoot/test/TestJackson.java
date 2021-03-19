package com.itachi.DemoSpringBoot.test;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

enum Type {
	ARRAY, OBJECT
}

/**
 * @author itachi
 *
 */
public class TestJackson {
	final String XML = "<students> <student> <fullName><firstName>itachi</firstName><middleName></middleName><lastName>uchiha</lastName></fullName> <id>1</id> <age/><marks><sub><name>math</name><score>98</score></sub><sub><name>science</name><score>97</score></sub></marks></student></students>";
	final List<String> ARRAY_ELEMENTS = Arrays.asList("students", "marks");
	final List<String> OBJECT_ELEMENTS = Arrays.asList("student", "sub","fullName");

	XMLInputFactory factory = XMLInputFactory.newInstance();
	ObjectMapper mapper = new ObjectMapper();
	XmlMapper xmlMapper = new XmlMapper();

	public void xmlToJson() {
		List<String> keys = Arrays.asList("sub");
		try {
			JsonNode node = xmlMapper.readTree(XML);
			System.out.println(xmlMapper.writeValueAsString(node));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void parseXml() {
		try {
			int eid = 0;
			int eid1 = 0;
			int edi2 = 0;
			XMLEventReader xReader = factory.createXMLEventReader(new StringReader(XML));
			while (xReader.hasNext()) {
				XMLEvent event = xReader.nextEvent();
				if (event.isStartElement()) {
					StartElement sElement = event.asStartElement();
					eid = sElement.getEventType();
					System.out.println("<" + sElement.getName() + ":" + eid);
				}
				// handle attributes

				if (event.isCharacters()) {
					Characters chrs = event.asCharacters();
					eid = chrs.getEventType();
					System.out.println("-" + chrs.getData() + ":" + eid);
				}

				if (event.isEndElement()) {
					// handle end element
					EndElement eElement = event.asEndElement();
					eid = eElement.getEventType();
					System.out.println(">" + eElement.getName() + ":" + eid);
				}
			}
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// working okayr
	@Test
	public void streamXml2() {
		int current = 0, pre = 0, prepre = 0, dept = 0;
		String key = "", value = "";		
		StringBuilder builder = new StringBuilder();
		Map<String,String> keyReplacements = new HashMap<String, String>();
		boolean hasParentArray = false;
		try {
			XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(XML));
			while (reader.hasNext()) {
				prepre = pre;
				pre = current;
				current = reader.next();
				// System.out.print("[" + pre + "," + current + "] ->");

				switch (current) {
				case XMLStreamConstants.START_ELEMENT:
					key = reader.getLocalName();
					break;
				case XMLStreamConstants.CHARACTERS:
					value = reader.getText();
					break;
				case XMLStreamConstants.END_ELEMENT:
					key = reader.getLocalName();
					break;
				}
				
				
				if (current == XMLStreamConstants.START_ELEMENT) {
					if(pre == 0)
					{
						builder.append("{");
					}
					if(!OBJECT_ELEMENTS.contains(key))
					{
						builder.append("\"").append(key).append("\":");
					}
					if(ARRAY_ELEMENTS.contains(key))
					{
						hasParentArray = true;
						keyReplacements.putIfAbsent(key, null);
						builder.append("[");
					}
					else if(OBJECT_ELEMENTS.contains(key))
					{
						if(!hasParentArray && !keyReplacements.containsValue(key))
						{
							builder.append("\"").append(key).append("\":");
						}
						else
						{
							for(Entry<String, String> entry:keyReplacements.entrySet())
							{
								if(entry.getValue() == null)
								{
									keyReplacements.put(entry.getKey(), key);
								}
							}
						}
						builder.append("{");
						hasParentArray = false;
					}
				} else if (current == XMLStreamConstants.CHARACTERS && !value.isBlank()) {
					builder.append("\"").append(value).append("\"");
				} else if (current == XMLStreamConstants.END_ELEMENT) {
					if (OBJECT_ELEMENTS.contains(key)) {
						builder.replace(builder.lastIndexOf(","), builder.length(), "}");
					}
					else if (ARRAY_ELEMENTS.contains(key)) {
						builder.replace(builder.lastIndexOf(","), builder.length(), "]");
					}
					else if (pre == XMLStreamConstants.START_ELEMENT) {
						builder.append("\"").append("\""); /*empty tag*/
					}
					builder.append(",");
				}
				System.out.println(builder.toString() + current);
			}
			builder.delete(builder.length() - 1, builder.length());
			System.out.println(builder.toString());
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void streamXml() {
		int current = 0, pre = 0, prepre = 0, dept = 0;
		String key = "", value = "";		
		StringBuilder builder = new StringBuilder();
		try {
			XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(XML));
			while (reader.hasNext()) {
				prepre = pre;
				pre = current;
				current = reader.next();
				// System.out.print("[" + pre + "," + current + "] ->");
				
				switch (current) {
				case XMLStreamConstants.START_ELEMENT:
					key = reader.getLocalName();
					break;
				case XMLStreamConstants.CHARACTERS:
					value = reader.getText();
					break;
				case XMLStreamConstants.END_ELEMENT:
					key = reader.getLocalName();
					break;
				}
				if (current == XMLStreamConstants.START_ELEMENT) {
					if (pre == 0 || pre == XMLStreamConstants.START_ELEMENT) {
						dept++;
						builder.append("{\"").append(key).append("\":");
					} else if (pre == XMLStreamConstants.CHARACTERS && prepre == XMLStreamConstants.START_ELEMENT) {
						dept++;
						builder.delete(builder.lastIndexOf("\""), builder.length());
						builder.delete(builder.lastIndexOf("\""), builder.length());
						builder.append("{\"").append(key).append("\":");
					} else if (pre == XMLStreamConstants.CHARACTERS && prepre == XMLStreamConstants.END_ELEMENT) {
						builder.delete(builder.lastIndexOf("\""), builder.length());
						builder.delete(builder.lastIndexOf("\""), builder.length());
						builder.append(key).append("\":");
					} else if (pre == XMLStreamConstants.END_ELEMENT) {
						builder.replace(builder.lastIndexOf(","), builder.length(), "},");
					}
				} else if (current == XMLStreamConstants.CHARACTERS) {
					builder.append("\"").append(value).append("\"");
				} else if (current == XMLStreamConstants.END_ELEMENT) {
					if (pre == XMLStreamConstants.START_ELEMENT) {
						builder.append("\"").append("\"");
					} else if (pre == XMLStreamConstants.END_ELEMENT) {
						dept--;
						builder.replace(builder.lastIndexOf(","), builder.length(), "}");
					}
					builder.append(",");
				}
				System.out.println(builder.toString() + current);
			}
			builder.delete(builder.length() - 1, builder.length());
			builder.append("");
			System.out.println(builder.toString());
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}