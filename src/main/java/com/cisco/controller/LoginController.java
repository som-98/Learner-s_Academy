package com.cisco.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		if(username.equalsIgnoreCase("somnath") && password.equals("somnathhi")) {
			rd = request.getRequestDispatcher("/Director.html");
			
			rd.forward(request, response);
		}
			else {
				PrintWriter out= response.getWriter();
				rd = request.getRequestDispatcher("Home.html");
				rd.include(request, response);
				out.print("<center> <span style='color:red'>Invalid credentials</span> </center>");
			}
		}

}
