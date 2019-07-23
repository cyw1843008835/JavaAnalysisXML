package com.dom4j;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * DOM4j 读取xml
 * 
 * @author 18430
 *
 */
public class DOM4j_002 {

	public static void main(String[] args) {
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read("src\\Telephone.xml");
			// 获取根节点
			Element rootElement = document.getRootElement();
			Iterator rootiterator = rootElement.elementIterator();
			while (rootiterator.hasNext()) {
				Element TelephoneElement = (Element) rootiterator.next();
				System.out.println("id=" + TelephoneElement.attributeValue("id"));
				System.out.println("modle=" + TelephoneElement.attributeValue("modle"));
				System.out.println("name=" + TelephoneElement.elementText("name"));
				System.out.println("color=" + TelephoneElement.elementText("color"));
				System.out.println("size=" + TelephoneElement.elementText("size"));

			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
