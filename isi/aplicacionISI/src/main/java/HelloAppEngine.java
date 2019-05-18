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
	public String urlInicial  = "https://tutiendadevideojuegos.com/buscar?category_id=&controller=search&orderby=position&orderway=desc&search_query=loquequieresbuscar+";


@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	String buscame = request.getParameter("buscame");
	urlInicial = urlInicial.replace("loquequieresbuscar","buscame" );
	tu_tienda.tienda(urlInicial);
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    response.getWriter().print("Hello App Engine!\r\n");
    
	}

  }
