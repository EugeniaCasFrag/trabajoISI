import java.io.IOException;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aplicacionISI.scrappingTuTiendaVJ;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {
	
	public scrappingTuTiendaVJ tu_tienda = new scrappingTuTiendaVJ();
	public String busqueda="";
	public String urlInicial  = "https://www.game.es/buscar/loquequieresbuscar/o=0&ca=0000000006:1:GIDS";


@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	String buscame = request.getParameter("buscame");
	urlInicial = urlInicial.replace("loquequieresbuscar", busqueda );
	tu_tienda.tienda(urlInicial);
    
    
	}

  }
