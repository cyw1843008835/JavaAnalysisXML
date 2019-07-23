package com.dom4j;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * DOm4j����xml
 * 
 * @author 18430
 *
 */
public class DOM4j_001 {
	public static void main(String[] args) {
		Document document = DocumentHelper.createDocument();
		// ��Ӹ��ڵ�
		Element telElement = document.addElement("Telephone");
		// ��Ӹ��ڵ�����
		telElement.addAttribute("id", "001");
		telElement.addAttribute("modle", "mate20");

		// ����ӽڵ���ӽڵ��ı�Ԫ��
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
