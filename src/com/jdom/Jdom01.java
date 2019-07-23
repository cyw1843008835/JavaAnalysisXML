package com.jdom;

import java.io.FileOutputStream;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 * JDOM创建xml文件
 * 
 * @param args
 */
public class Jdom01 {

	public static void main(String[] args) {
		// 定义根节点
		Element school = new Element("School");
		// 定义根节点属性
		Attribute id = new Attribute("id", "001");
		Attribute level = new Attribute("level", "A");
		school.setAttribute(id);
		school.setAttribute(level);
		// 定义子节点
		Element name = new Element("name");
		// 定义name节点文本
		name.setText("ASL");
		school.addContent(name);
		Element year = new Element("year");
		// 定义year节点文本
		year.setText("10");
		school.addContent(year);
		Element location = new Element("location");
		// 定义location节点文本
		location.setText("Beijing");
		school.addContent(location);

		// 创建xml文件
		Document doc = new Document(school);
		XMLOutputter outputter = new XMLOutputter();
		outputter.setFormat(outputter.getFormat().setEncoding("UTF-8"));
		try {
			outputter.output(doc, new FileOutputStream("src\\school.xml"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
