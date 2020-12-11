//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//import javax.xml.stream.XMLInputFactory;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//
//public class XmlParser {	
//	
//	
//	public XmlParser() {
//		deserializeFromXML();
//	}
//	
//	public static void deserializeFromXML() {
//    try {
//        
//        File file = new File("currencies.xml");
//        XmlMapper xmlMapper = new XmlMapper();
//        String XML = inputStreamToString(new FileInputStream(file));
//        Currency value = xmlMapper.readValue(XML, Currency.class);
//        Currency value2 = xmlMapper.readValue(XML, Currency.class);
//        System.out.println(value.getTargetCurrency() + " " + value.getInverseRate());
//        System.out.println(value2.getTargetCurrency() + " " + value2.getInverseRate());
//        
//    } catch (IOException e) {
//        // handle the exception
//    }
//}
//
//
//	public static String inputStreamToString(InputStream is) throws IOException {
//	    StringBuilder sb = new StringBuilder();
//	    String line;
//	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
//	    while ((line = br.readLine()) != null) {
//	        sb.append(line);
//	    }
//	    br.close();
//	    return sb.toString();
//	}
//public static void main(String[] args) {
//    System.out.println("Deserializing from XML...");
//    XmlParser parser = new XmlParser();
//    
//}
//}