package com.dom4j;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * DOm4j创建xml
 * 
 * @author 18430
 *
 */
public class DOM4j_001 {
	public static void main(String[] args) {
		Document document = DocumentHelper.createDocument();
		// 添加根节点
		Element telElement = document.addElement("Telephone");
		// 添加根节点属性
		telElement.addAttribute("id", "001");
		telElement.addAttribute("modle", "mate20");

		// 添加子节点和子节点文本元素
		Element name = telElement.addElement("name");
		name.setText("HUAWEI");
		Element color = telElement.addElement("color");
		color.setText("black");
		Element size = telElement.addElement("size");
		size.setText("6.0");

		OutputFormat outputFormat = OutputFormat.createPrettyPrint();
		outputFormat.setEncoding("UTF-8");
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream("src\\Telephone.xml"), outputFormat);
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
