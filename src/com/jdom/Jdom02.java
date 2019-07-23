package com.jdom;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 * Jdom±éÀúxmlÎÄ¼þ
 * 
 * @author 18430
 *
 */
public class Jdom02 {

	public static void main(String[] args) {
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			Document document = saxBuilder.build("src\\school.xml");
			Element element = document.getRootElement();
			List schooList = element.getChildren("School");
			for (int i = 0; i < schooList.size(); i++) {
				Element school = (Element) schooList.get(i);
				String id = school.getAttributeValue("id");
				String level = school.getAttributeValue("level");
				String name = school.getChildText("name");
				String year = school.getChildText("year");
				String location = school.getChildText("location");
				System.out.println("id=" + id + "; level=" + level + "; name=" + name + "; year=" + year + "; location="
						+ location);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
