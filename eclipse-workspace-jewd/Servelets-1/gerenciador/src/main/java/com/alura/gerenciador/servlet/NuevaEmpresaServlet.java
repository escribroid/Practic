package com.alura.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class NuevaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("nueva empresa registrada");
		
		String nombreEmpresa = request.getParameter("nombre");
		String paramFechaAbertura = request.getParameter("fecha");
		
		Date fechaAbertura =  null;
		// Parse de Date a String
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			fechaAbertura = sdf.parse(paramFechaAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNombre(nombreEmpresa);
		empresa.setFechaAbertura(fechaAbertura);
		
		DB baseDeDatos = new DB();
		baseDeDatos.agregarEmpresa(empresa);
		
		// Redireccionmiento clientSide de NuevaEmpresaServlet a ListaEmpresasServlet
		response.sendRedirect("listaEmpresas");
		
		// llamar aa JSP
		// con Dispatcher
//		RequestDispatcher rd =  request.getRequestDispatcher("listaEmpresas");
//		
//		request.setAttribute("empresa", empresa.getNombre());
//		rd.forward(request, response);
	}

}
