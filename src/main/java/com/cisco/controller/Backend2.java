package com.cisco.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cisco.config.Hibernate2;
import com.cisco.entity.Classes;
import com.cisco.entity.LAStudents;


/**
 * Servlet implementation class Backend2
 */
public class Backend2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Backend2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname2=null;
		LAStudents stud= new LAStudents();
		stud.setRollno(Integer.parseInt(request.getParameter("rollno")));
		stud.setStudent_name(request.getParameter("name"));
		int cid= (Integer.parseInt(request.getParameter("classes2")));
		if(cid==1)
		{
			cname2="Java";
		}
		else if(cid==2)
		{
			cname2="Machine Learning";
		}
		else if(cid==3)
		{
			cname2="Data Science";
		}
		else if(cid==4)
		{
			cname2="Fundamentals of Programming";
		}
		else if(cid==5)
		{
			cname2="GATE Computer science";
		}
		else if(cid==6)
		{
			cname2="Cloud";
		}
		else if(cid==7)
		{
			cname2="Databases";
		}
		else if(cid==8)
		{
			cname2="Interview Preparation";
		}
		Classes cc = new Classes();
		cc.setClass_id(cid);
		cc.setClass_name(cname2);
		cc.setLas(null);
		cc.setLat(null);
		stud.setLa(cc);
		
		Session session = Hibernate2.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
				
		session.save(cc);
		session.save(stud);


		transaction.commit();
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("Students.html");
		rd.include(request, response);
		PrintWriter out1 = response.getWriter();
		out1.print("<center> <span style='color:white'>Successfully Registered</span> </center>");
		

	}

	}


