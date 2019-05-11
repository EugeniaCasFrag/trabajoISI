package aplicacionISI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class http_servlet{
	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{processRequest(request, response)};
}
