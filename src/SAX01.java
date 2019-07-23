import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.model.Student;

public class SAX01 extends DefaultHandler {
	private ArrayList<Student> stuList;
	private Student student = null;
	private String preTag = null;

	@Override
	public void startDocument() throws SAXException {
		System.out.println("扫描文档开始");
		System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println();
		System.out.println("扫描文档结束");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print("<");
		System.out.print(qName);
		if (attributes != null) {
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.print(" " + attributes.getQName(i) + "=" + attributes.getValue(i));
			}
		}
		System.out.print(">");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.print("</");
		System.out.print(qName);
		System.out.print(">");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		System.out.print(new String(ch, start, length));
	}

	public static void main(String[] args) {
		// 单例模式
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse("src\\Student.xml", new SAX01());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}
