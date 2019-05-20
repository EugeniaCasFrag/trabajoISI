package aplicacionISI;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class scrappingTuTiendaVJ {
	public void tienda(String buscame){
		print("running...");
		Document document;
		print(buscame);

		try {
			//Get Document object after parsing the html from given url.
			document = Jsoup.connect(buscame).get();
			print("i am here");
			String title = document.title(); //Get title
			print("  Title: " + title); //Print title.
			Elements price = document.select(".product_container:contains(€)"); //Get price
			for (int i=0; i < price.size(); i++) {
				print(price.get(i).text());
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		print("done");
	}
	public static void print(String string) {
		System.out.println(string);
	}
}
