package aplicacionISI;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import aplicacionISI.tuTiendaVJ;
import aplicacionISI.instantGaming;
import aplicacionISI.Juego;


@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public tuTiendaVJ tu_tienda = new tuTiendaVJ();
	public instantGaming instant = new instantGaming();
	public Juego yourGame = new Juego(); 
	public ArrayList<Precios>theMoney = new ArrayList();
	public Precios pA = new Precios(); 
	
	public String busqueda="";
	public String edicion="";
	public String plataforma="";

	public String urlOne   = "https://www.tiendacpu.com/buscar?controller=search&orderby=position&orderway=desc&search_query=loquequieresbsucar&submit_search=";
	public String urlTwo  = "https://www.instant-gaming.com/es/busquedas/?q=loquequieresbsucar";
	JavaCodeSnippet Amazon_Object = new JavaCodeSnippet();

	



private void print(String string) {
		// TODO Auto-generated method stub
		
	}


@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	String buscame = request.getParameter("buscame");
	String plataforma = request.getParameter("plataforma");
	String edicion = request.getParameter("edicion");
	
	yourGame.setNombre(buscame);
	yourGame.setPlataforma(plataforma);
	yourGame.setEdicion(edicion);

	String getInThere = "";
	getInThere = buscame + "+" + plataforma + "+" + edicion;
	try {
		 pA = Amazon_Object.amazon(getInThere);
	} catch (ParserConfigurationException | SAXException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	urlOne = urlOne.replace("loquequieresbsucar", getInThere );
	urlTwo = urlTwo.replace("loquequieresbsucar", getInThere);

	Precios dOne = tu_tienda.tienda(urlOne);
	Precios dTwo = instant.tienda(urlTwo);
	
	this.theMoney.add(dOne);
	this.theMoney.add(dTwo);
	if(!pA.getNombre().isEmpty()) {
		this.theMoney.add(pA);
	}
	yourGame.setMoney(theMoney);
	
	request.setAttribute("yourGame", yourGame);
	response.setContentType("text/plain;charset=UTF-8");
	RequestDispatcher rd = request.getRequestDispatcher("/Games.jsp");
	try {
		rd.forward(request, response);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

    
    
	}



  }