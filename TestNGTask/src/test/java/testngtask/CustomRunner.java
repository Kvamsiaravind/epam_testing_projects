package testngtask;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

public class CustomRunner {
    public static void main(String[] args) {
        TestListenerAdapter testListenerAdapter = new TestListenerAdapter();
        TestNG testNG = new TestNG();
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Calculator functionality");
        List<String> files = new ArrayList<>();
        files.addAll(new ArrayList<>() {{
            add("./src/test/resources/TestNGFile.xml");
        }});
        xmlSuite.setSuiteFiles(files);
        List<XmlSuite> xmlSuiteList = new ArrayList<>();
        xmlSuiteList.add(xmlSuite);
        testNG.setXmlSuites(xmlSuiteList);
        testNG.run();
    }
}
