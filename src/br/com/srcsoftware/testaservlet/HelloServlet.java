package br.com.srcsoftware.testaservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/hello" )
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		String texto = req.getParameter( "texto" );

		PrintWriter html = resp.getWriter();

		html.println( "<!DOCTYPE html>" );
		html.println( "<html>" );
		html.println( "<head>" );
		html.println( "<meta charset='UTF-8'>" );
		html.println( "<title>Insert title here</title>" );
		html.println( "</head>" );
		html.println( "<body>" );
		html.println( "	<label>Texto Digitado: </label>" );
		html.println( "	<input type='text' name='texto' value='" + texto + "'>" );
		html.println( "</body>" );
		html.println( "</html>" );

	}

	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		String texto = req.getParameter( "texto" );

		PrintWriter html = resp.getWriter();

		html.println( "<!DOCTYPE html>" );
		html.println( "<html>" );
		html.println( "<head>" );
		html.println( "<meta charset='UTF-8'>" );
		html.println( "<title>Insert title here</title>" );
		html.println( "</head>" );
		html.println( "<body>" );
		html.println( "	<label>Texto Digitado: </label>" );
		html.println( "	<input type='text' name='texto' value='" + texto + "'>" );
		html.println( "</body>" );
		html.println( "</html>" );
	}

}
