package com.jdom;

import java.io.FileOutputStream;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 * JDOM����xml�ļ�
 * 
 * @param args
 */
public class Jdom01 {

	public static void main(String[] args) {
		// ������ڵ�
		Element school = new Element("School");
		// ������ڵ�����
		Attribute id = new Attribute("id", "001");
		Attribute level = new Attribute("level", "A");
		school.setAttribute(id);
		school.setAttribute(level);
		// �����ӽڵ�
		Element name = new Element("name");
		// ����name�ڵ��ı�
		name.setText("ASL");
		school.addContent(name);
		Element year = new Element("year");
		// ����year�ڵ��ı�
		year.setText("10");
		school.addContent(year);
		Element location = new Element("location");
		// ����location�ڵ��ı�
		location.setText("Beijing");
		school.addContent(location);

		// ����xml�ļ�
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
