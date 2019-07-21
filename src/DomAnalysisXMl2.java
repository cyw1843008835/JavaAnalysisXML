
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomAnalysisXMl2 {
	/**
	 * DOM方式解析xml文件之获取元素节点和属性节点
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("src\\Student2.xml");
			NodeList ndl = doc.getElementsByTagName("students");
			Element element = (Element) ndl.item(0);
			NodeList stuNodeList = element.getElementsByTagName("student");
			for (int i = 0; i < stuNodeList.getLength(); i++) {
				Element element2 = (Element) stuNodeList.item(i);
				System.out.println(
						"name:" + element2.getElementsByTagName("name").item(0).getFirstChild().getTextContent());
				printnodeAttr(element2.getElementsByTagName("name").item(0));
				System.out.println(
						"age:" + element2.getElementsByTagName("age").item(0).getFirstChild().getTextContent());
				System.out.println(
						"sex:" + element2.getElementsByTagName("sex").item(0).getFirstChild().getTextContent());
				System.out.println("============================================");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void printnodeAttr(Node node) {

		NamedNodeMap nnmMap = node.getAttributes();
		for (int i = 0; i < nnmMap.getLength(); i++) {
			Node attrNode = nnmMap.item(i);
			System.out.println(attrNode.getNodeName() + ":" + attrNode.getFirstChild().getNodeValue());
		}
	}
}
