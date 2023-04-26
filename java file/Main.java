import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Main sourceFile");
            System.exit(1);
        }
        String fileName = null;
        File sourceFile = null;
        try {
            fileName = args[0];
            sourceFile = new File(fileName);
            if (!fileName.endsWith(".arxml")) {
                throw new NotVaildAutosarFileException("Invalid file extension but I handled it");
            }
            if (!sourceFile.exists()) {
                System.out.println("Source file " + fileName + " does not exist");
                System.exit(2);
            }
        }
        catch (NotVaildAutosarFileException ex) {
            fileName = fileName.substring(0, fileName.indexOf(".")) + ".arxml";
        }
        Scanner input = new Scanner(sourceFile);
        ArrayList <Container> arr= new ArrayList<>();
        try{
            if(!input.hasNext())
                throw new EmptyAutosarFileException("Empty File");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(sourceFile);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("CONTAINER");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String UUID=eElement.getAttribute("UUID");
                    String shortName = eElement.getElementsByTagName("SHORT-NAME").item(0).getTextContent();
                    String longName = eElement.getElementsByTagName("LONG-NAME").item(0).getTextContent();
                    arr.add(new Container(shortName,longName,UUID));
                }
            }
            Collections.sort(arr);
        }

        catch (EmptyAutosarFileException | SAXException | ParserConfigurationException ex){
            System.exit(3);
        }
        File outputFile = new File(fileName.substring(0, fileName.indexOf(".")) + "_mod.arxml");
        PrintWriter output = new PrintWriter(outputFile);
        output.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<AUTOSAR>\n");

        for (Container container : arr)
          output.write(container.toString());

        output.write("</AUTOSAR>\n");
        output.close();
    }
}