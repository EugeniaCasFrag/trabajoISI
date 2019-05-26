package aplicacionISI;

import java.io.IOException;
import java.util.ArrayList;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class instantGaming {
	public Precios tienda(String buscame){
		print("running...");
		print(buscame);
		Document document= null;
		ArrayList<Precios> juegos = new ArrayList();
		Precios elElegido = new Precios();




		try {
			print(buscame);
			document = Jsoup.connect(buscame).get();
			String title = document.title(); //Get title
			print("  Title: " + title); //Print title.
			Elements price = document.body().select("div.price"); //Get price
			Elements titulos = document.body().select("div.name");
			Elements url = document.body().select("a.cover[href]");
//			Elements foto = document.body().select("img.picture-shadow[src]");
			
			ArrayList<String>enlaces = new ArrayList();
			for(Element i : url) {
				String link = i.attr("href");
				enlaces.add(link);
			}
//			ArrayList<String>fotos = new ArrayList();
//			for(Element i : foto) {
//				String img = i.attr("src");
//				fotos.add(img);
//			}
			
			for (int i=0; i < price.size(); i++) {
				Precios g = new Precios();
				g.setNombre(titulos.get(i).text());
				g.setPrecio(price.get(i).text());
				g.setURL(enlaces.get(i));
				print(price.get(i).text());
//				g.setImagen(fotos.get(i));

				juegos.add(g);
			}
			print(price.get(0).text());

			String first = juegos.get(0).getPrecio();
			String parts[] = first.split("€");
			
			float min = Float.parseFloat(parts[0]);
			float max = 0;
			int indice = 0;
			for(int i = 0; i < juegos.size(); i++) {
				first = juegos.get(i).getPrecio();
				String partes[] = first.split("€");
				max = Float.parseFloat(partes[0]);
				if(min > max) {
					min = max;
					indice = i;
				}
			}
			
			elElegido.setNombre(juegos.get(indice).getNombre());
			elElegido.setPrecio(juegos.get(indice).getPrecio());
			elElegido.setURL(juegos.get(indice).getURL());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		print("done");
		
		return elElegido;
	}
	public static void print(String string) {
		System.out.println(string);
	}
}