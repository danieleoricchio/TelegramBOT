/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author oricchio_daniele
 */
public class ParseXml {

    public static Location getLocation(String citta) {
        try {
            URL url = new URL("https://nominatim.openstreetmap.org/search?q=" + citta + "&format=xml&addressdetails=1");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            var document = builder.parse(url.openStream());
            Element root = document.getDocumentElement(), element = null;
            NodeList nList = document.getElementsByTagName("place");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                element = (Element) node;
                Location location = new Location(Double.parseDouble(element.getAttribute("lat")),
                        Double.parseDouble(element.getAttribute("lon")), element.getAttribute("display_name"));
                return location;
            }
        } catch (IOException ex) {
            Logger.getLogger(ParseXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ParseXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ParseXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Location getLocation(double lat, double lon) {
        try {
            URL url = new URL("https://nominatim.openstreetmap.org/reverse?lat=" + lat + "&lon=" + lon + "&format=xml&addressdetails=1");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            var document = builder.parse(url.openStream());
            Element root = document.getDocumentElement(), element = null;
            NodeList nList = document.getElementsByTagName("place");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                element = (Element) node;
                Location location = new Location(Double.parseDouble(element.getAttribute("lat")),
                        Double.parseDouble(element.getAttribute("lon")), element.getAttribute("display_name"));
                return location;
            }
        } catch (IOException ex) {
            Logger.getLogger(ParseXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ParseXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ParseXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
