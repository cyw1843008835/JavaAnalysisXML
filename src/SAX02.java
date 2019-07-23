
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.model.Student;

public class SAX02 extends DefaultHandler {
	private List<Student> stuList;
	private Student student = null;
	private String preTag = null;

	@Override
	public void startDocument() throws SAXException {
		System.out.println("扫描文档开始");
		stuList = new ArrayList<Student>();

	}

	@Override
	public void endDocument() throws SAXException {

		System.out.println("\n 扫描文档结束");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if ("student".equals(qName)) {
			student = new Student();
			student.setId(attributes.getValue(0));
			student.setLevel(attributes.getValue(1));
		}
		preTag = qName;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if ("student".equals(qName)) {
			stuList.add(student);
			student = null;
		}
		preTag = null;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		if (preTag != null) {
			String content = new String(ch, start, length);
			switch (preTag) {
			case "name":
				student.setName(content);
				break;
			case "age":
				student.setAge(Integer.parseInt(content));
				break;
			case "sex":
				student.setSex(content);
				break;

			default:
				break;
			}
		}
	}

	public static void main(String[] args) {
		// 单例模式
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			SAX02 sax02 = new SAX02();
			parser.parse("src\\Student2.xml", sax02);
			for (Student s : sax02.stuList) {
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}
