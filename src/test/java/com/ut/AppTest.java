package com.ut;

import org.junit.Test;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void beanToXml() {

        Person person = new Person("xx",1,1);
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(person, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void xmlToBean() throws ParserConfigurationException, IOException, SAXException {

        URL url = ClassLoader.getSystemClassLoader().getResource("");
        String filePath = new File(url.getFile(), "../classes/").getCanonicalPath();
        File file = new File(filePath + "//excel_template_test.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        System.out.println(
            document.getXmlVersion()+"\n\r"+
            document.getXmlEncoding()+"\n\r"
        );

        Element documentElement = document.getDocumentElement();
        String tagName = documentElement.getTagName();
        System.out.println(tagName);
        NodeList childNodes = document.getChildNodes();
        System.out.println(childNodes.getLength());



        NodeList sheetList = documentElement.getElementsByTagName("sheet");
        Node item = sheetList.item(0);

        System.out.println(item.getNodeName());

        Node item1 = item.getChildNodes().item(1);
        System.out.println(item1.getNodeName());

        System.out.println(item1.getChildNodes().item(1).getNodeName());
        System.out.println(item1.getChildNodes().item(3).getNodeName());
        System.out.println(item1.getChildNodes().item(5).getNodeName());
    }

}
