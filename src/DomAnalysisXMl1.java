
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomAnalysisXMl1 {
	/**
	 * DOM方式解析xml文件之获取元素节点
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("src\\Student.xml");
			NodeList ndl = doc.getElementsByTagName("student");
			Element element = (Element) ndl.item(0);
			System.out.println("name:" + element.getElementsByTagName("name").item(0).getFirstChild().getTextContent());
			System.out.println("age:" + element.getElementsByTagName("age").item(0).getFirstChild().getTextContent());
			System.out.println("sex:" + element.getElementsByTagName("sex").item(0).getFirstChild().getTextContent());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
