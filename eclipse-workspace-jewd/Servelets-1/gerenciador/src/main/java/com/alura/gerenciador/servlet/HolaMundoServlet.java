package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// mapear con anotaciones la URL
//hola
@WebServlet(urlPatterns = "/hola")
public class HolaMundoServlet extends HttpServlet{
	
	//Constructor
	public HolaMundoServlet() {
		System.out.println("Creando Hola Mundo Servlet");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PrintWriter out =resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Hola Mundo! Felicitaciones por crear tu primer Servlet!");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("Se ejecutó el servlet");
		
	}

}

