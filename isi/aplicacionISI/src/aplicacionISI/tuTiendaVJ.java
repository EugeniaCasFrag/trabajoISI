package aplicacionISI;

import java.io.IOException;
import java.util.ArrayList;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class tuTiendaVJ {
	public Precios tienda(String buscame){
		print("running...");
		print(buscame);
		Document document= null;
		ArrayList<Precios> juegos = new ArrayList();
		Precios elElegido = new Precios();

<<<<<<< HEAD
		try {
			print(buscame);
			document = Jsoup.connect(buscame).get();
			String title = document.title(); //Get title
			print("  Title: " + title); //Print title.
			Elements price = document.body().select("span.price.product-price"); //Get price
			Elements titulos = document.body().select("a.product-name");
			Elements url = document.body().select("a.product-name[href]");
//			Elements foto = document.body().select("img#bigpic[src]");


			ArrayList<String>enlaces = new ArrayList();
			for(Element i : url) {
				String link = i.attr("href");
				enlaces.add(link);
			}
//			ArrayList<String>fotos = new ArrayList();
//			for(Element i : foto) {
//
//				String img = i.attr("src");
//				print("---------------------------->" + img);
//				fotos.add(img);
//			}
			print("estoy vacia?" + titulos.isEmpty());

			if(!price.isEmpty()) {
				for (int i=0; i < price.size(); i++) {
					Precios g = new Precios();
					g.setNombre(titulos.get(i).text());
					g.setPrecio(price.get(i).text());
					g.setURL(enlaces.get(i));
//					g.setImagen(fotos.get(i));
					juegos.add(g);
				}		
				
			}
			
//			print(price.get(0).text());

			
			int indice = 0;
			
			if(!juegos.isEmpty()) {
				int tam = 0;
				if(juegos.size()>= 6) {
					tam = 6;
				}else {
					tam = juegos.size();
				}
				String first = juegos.get(0).getPrecio();
				first = first.replace(",", ".");
				String parts[] = first.split(" ");
				float min = Float.parseFloat(parts[0]);
				float max = 0;
				for(int i = 0; i < tam; i++) {
					first = juegos.get(i).getPrecio();
					first = first.replace(",", ".");
					String partes[] = first.split(" ");
					max = Float.parseFloat(partes[0]);
//					print("min "+ min);
//					print("max "+ max);
//					print(juegos.get(i).getPrecio());
					if(min > max) {
						min = max;
						indice = i;
					}
				}
			}

			
			elElegido.setNombre(juegos.get(indice).getNombre());
			elElegido.setPrecio(juegos.get(indice).getPrecio());
			elElegido.setURL(juegos.get(indice).getURL());
//			print("el elegido-> "+elElegido.getPrecio());
=======




		try {
			print(buscame);
			document = Jsoup.connect(buscame).get();
			String title = document.title(); //Get title
			print("  Title: " + title); //Print title.
			Elements price = document.body().select("span.price.product-price"); //Get price
			Elements titulos = document.body().select("a.product-name");
			Elements url = document.body().select("a.product-name[href]");
			
			ArrayList<String>enlaces = new ArrayList();
			for(Element i : url) {
				String link = i.attr("href");
				enlaces.add(link);
			}
			
			if(!price.isEmpty()) {
				for (int i=0; i < price.size(); i++) {
					Precios g = new Precios();
					g.setNombre(titulos.get(i).text());
					g.setPrecio(price.get(i).text());
					g.setURL(enlaces.get(i));
					juegos.add(g);
				}		
				
			}
			
			print(price.get(0).text());

			
			int indice = 0;
			
			if(!juegos.isEmpty()) {
				int tam = 0;
				if(juegos.size()>= 6) {
					tam = 6;
				}else {
					tam = juegos.size();
				}
				String first = juegos.get(0).getPrecio();
				first = first.replace(",", ".");
				String parts[] = first.split(" ");
				float min = Float.parseFloat(parts[0]);
				float max = 0;
				for(int i = 0; i < tam; i++) {
					first = juegos.get(i).getPrecio();
					first = first.replace(",", ".");
					String partes[] = first.split(" ");
					print("--------------------_>"+partes[0]);
					max = Float.parseFloat(partes[0]);
					print("min "+ min);
					print("max "+ max);
					print(juegos.get(i).getPrecio());
					if(min > max) {
						min = max;
						indice = i;
					}
				}
			}

			
			elElegido.setNombre(juegos.get(indice).getNombre());
			elElegido.setPrecio(juegos.get(indice).getPrecio());
			elElegido.setURL(juegos.get(indice).getURL());
			print("el elegido-> "+elElegido.getPrecio());
>>>>>>> branch 'master' of https://github.com/EugeniaCasFrag/trabajoISI.git
			
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