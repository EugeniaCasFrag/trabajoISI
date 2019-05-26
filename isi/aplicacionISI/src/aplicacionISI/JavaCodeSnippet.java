package aplicacionISI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * This class shows how to make a simple authenticated call to the
 * Amazon Product Advertising API.
 *
 * See the README.html that came with this sample for instructions on
 * configuring and running the sample.
 */
public class JavaCodeSnippet {

    /*
     * Your Access Key ID, as taken from the Your Account page.
     */
    private static final String ACCESS_KEY_ID = "AKIAJ2M7Z62GFWKITXBA";

    /*
     * Your Secret Key corresponding to the above ID, as taken from the
     * Your Account page.
     */
    private static final String SECRET_KEY = "ASJo63DLv+0IaNwTp1j4ytzQvkUaM+AXNlbAOBVa";

    /*
     * Use the end-point according to the region you are interested in.
     */
    private static final String ENDPOINT = "webservices.amazon.es";
    
    public ArrayList<String> preciosAmazon=new ArrayList<String>();
    public ArrayList<String> NombresAmazon=new ArrayList<String>();
    public ArrayList<String> urlsAmazon=new ArrayList<String>();
    public ArrayList<String> urlsImagenesAmazon=new ArrayList<String>();
    public String elTitulo,laUrl,elPrecio;
    public String preciofinal;
    
    
    public  Precios amazon(String modelo) throws ParserConfigurationException, SAXException {

        /*
         * Set up the signed requests helper.
         */
    	SignedRequestHelper helper;
        Precios p = new Precios();


        try {
            helper = SignedRequestHelper.getInstance(ENDPOINT, ACCESS_KEY_ID, SECRET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        String requestUrl = null;

        Map<String, String> params = new HashMap<String, String>();

        params.put("Service", "AWSECommerceService");
        params.put("Operation", "ItemSearch");
        params.put("AWSAccessKeyId", "AKIAJ2M7Z62GFWKITXBA");
        params.put("AssociateTag", "ikor0b-21");
        params.put("SearchIndex", "VideoGames");
        params.put("Keywords", modelo);
        params.put("ResponseGroup", "Images,ItemAttributes,Offers");

        requestUrl = helper.sign(params);

        System.out.println("Signed URL: \"" + requestUrl + "\"");
        
        //Almacenamos la informacion 
        DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        db = dbf.newDocumentBuilder();
        org.w3c.dom.Document doc1=null;
        try {
        		doc1 = db.parse(requestUrl);
                NodeList nameOfModel= doc1.getElementsByTagName("Title"); 
              //Extraemos el título

                for(int i=0;i<nameOfModel.getLength();i++)
                {
                  org.w3c.dom.Element el = (org.w3c.dom.Element)nameOfModel.item(i);
                  NombresAmazon.add(el.getFirstChild().getNodeValue());
                }
                System.out.println("Títulos :" + NombresAmazon);
                
                //Extraemos el precio
                nameOfModel= doc1.getElementsByTagName("FormattedPrice");
                for(int i=0;i<nameOfModel.getLength();i++)
                {
                  
                  org.w3c.dom.Element el = (org.w3c.dom.Element)nameOfModel.item(i);
                  preciosAmazon.add(el.getFirstChild().getNodeValue());
                }
                System.out.println("Precio" + preciosAmazon);
                
              //Extraemos la URL del terminal en Amazon
                nameOfModel= doc1.getElementsByTagName("DetailPageURL");
                for(int i=0;i<nameOfModel.getLength();i++)
                {
                  
                  org.w3c.dom.Element el = (org.w3c.dom.Element)nameOfModel.item(i);
                  urlsAmazon.add(el.getFirstChild().getNodeValue());
                }
                System.out.println("Link" + urlsAmazon);
                
              
               
                        laUrl = urlsAmazon.get(0);
        		        elTitulo = NombresAmazon.get(0);
        		        elPrecio = preciosAmazon.get(0);
        		        
        		        p.setNombre(elTitulo);
        		        p.setPrecio(elPrecio);
        		        p.setURL(laUrl);



        	} catch (IOException e) {
        		e.printStackTrace();
        }
        
        		        
      
      return   p;
    }
}