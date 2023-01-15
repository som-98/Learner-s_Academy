package com.cisco.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.cfg.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.cisco.config.HibernateConfig;
import com.cisco.entity.*;
import com.cisco.DAO.*;

/**
 * Servlet implementation class Backend
 */
public class Backend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Backend() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname1=null;
		Classes classes = new Classes();
		classes.setClass_id(Integer.parseInt(request.getParameter("classes1")));
		if(classes.getClass_id()==1)
		{
			cname1="Java";
		}
		else if(classes.getClass_id()==2)
		{
			cname1="Machine Learning";
		}
		else if(classes.getClass_id()==3)
		{
			cname1="Data Science";
		}
		else if(classes.getClass_id()==4)
		{
			cname1="Fundamentals of Programming";
		}
		else if(classes.getClass_id()==5)
		{
			cname1="GATE Computer science";
		}
		else if(classes.getClass_id()==6)
		{
			cname1="Cloud";
		}
		else if(classes.getClass_id()==7)
		{
			cname1="Databases";
		}
		else if(classes.getClass_id()==8)
		{
			cname1="Interview Preparation";
		}
		classes.setClass_name(cname1);
		

		Teachers teachers = new Teachers();
		
		String tname=null;
		int tid=0;
		teachers.setTeacher_id(Integer.parseInt(request.getParameter("teacher")));

		if(teachers.getTeacher_id()==1)
		{
			tname="Aishwarya";
		}
		else if(teachers.getTeacher_id()==2)
		{
		tname="Reena";
		}
		else if(teachers.getTeacher_id()==3)
		{
		tname="Siddhant";
		}
		else if(teachers.getTeacher_id()==4)
		{
		tname="Lata";
		}
		else if(teachers.getTeacher_id()==5)
		{
		tname="Umesh";
		}
		teachers.setTeacher_name(tname);	
		
		Subjects Subjects1 = new Subjects();
		Subjects Subjects2 = new Subjects();
		Subjects Subjects3 = new Subjects();
		Subjects Subjects4 = new Subjects();
		Subjects Subjects5 = new Subjects();
		Subjects Subjects6 = new Subjects();
		Subjects Subjects7 = new Subjects();
		Subjects Subjects8 = new Subjects();
		
		teachers.getLac().add(classes);
		classes.setLat(teachers);
		String[] checkbox;
		checkbox = request.getParameterValues("subject");

		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
//		Configuration con = new Configuration().configure("/com/hibernate/hibernate.cfg.xml").addAnnotatedClass(Classes.class).addAnnotatedClass(StudentClasses.class).
//		addAnnotatedClass(Students.class)
//		.addAnnotatedClass(Teachers.class)
//		.addAnnotatedClass(Subjects.class);
//		SessionFactory sf = con.buildSessionFactory();
//		
//		Session session = sf.openSession();
//		
//		Transaction tx = session.beginTransaction();
//		SubjectsDAO sb = new SubjectsDAO();
		
		
		for(int i = 0;i<checkbox.length;i++)
		{
			PrintWriter out = response.getWriter();
			out.println("top"+checkbox[i]);
			if(checkbox[i].equals("1"))
			{
				//out.println(checkbox[i]);
				Subjects1.setSubject_id(1);
				Subjects1.setSubject_name("Core Java");
				classes.getLas().add(Subjects1);
				Subjects1.setLacc(classes);
			    session.save(Subjects1);
//				sb.insertSubjectInDB(Subjects1);
							
			}
			else if(checkbox[i].equals("2"))
			{
				//out.println(checkbox[i]);
				Subjects2.setSubject_id(2);
				Subjects2.setSubject_name("Advanced Java");
				classes.getLas().add(Subjects2);
				Subjects2.setLacc(classes);
			    session.save(Subjects2);
								
			}
			else if(checkbox[i].equals("3"))
			{
			
				//out.println(checkbox[i]);
				Subjects3.setSubject_id(3);
				Subjects3.setSubject_name("Enterprise Java");
				classes.getLas().add(Subjects3);
				Subjects3.setLacc(classes);
			    session.save(Subjects3);
								
			}
			else if(checkbox[i].equals("4"))
			{
		
				Subjects4.setSubject_id(4);
				Subjects4.setSubject_name("AWS");
				classes.getLas().add(Subjects4);
				Subjects4.setLacc(classes);
			   // session.save(Subjects4);
							
			}
			else if(checkbox[i].equals("5"))
			{
		
				Subjects5.setSubject_id(5);
				Subjects5.setSubject_name("Azure");
				classes.getLas().add(Subjects5);
				Subjects5.setLacc(classes)				;
			   session.save(Subjects5);
							
			}
			else if(checkbox[i].equals("6"))
			{
			
				Subjects6.setSubject_id(6);
				Subjects6.setSubject_name("Python");
				classes.getLas().add(Subjects6);
				Subjects6.setLacc(classes);
			    session.save(Subjects6);
							
			}
			else if(checkbox[i].equals("7"))
			{
		
				Subjects7.setSubject_id(7);
				Subjects7.setSubject_name("MySQL");
				classes.getLas().add(Subjects7);
				Subjects7.setLacc(classes);
			    //session.save(Subjects7);
							}
			else if(checkbox[i].equals("8"))
			{
				Subjects8.setSubject_id(8);
				Subjects8.setSubject_name("Algo and DS");
				classes.getLas().add(Subjects8);
				Subjects8.setLacc(classes);
			    session.save(Subjects8);
			}
		}
		
//
//		StudentDAO sdao = new StudentDAO();
//		ClasssesDAO cdao = new ClasssesDAO();
//		cdao.insertSubjectInDB(classes);
//		sdao.insertTeachersInDB(teachers);
		
		session.save(classes);
		session.save(teachers);
		transaction.commit();
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("admin-teachers.html");
		rd.include(request, response);
		PrintWriter out1 = response.getWriter();
		out1.print("<center> <span style='color:white'>Successfully Registered</span> </center>");
		
//	
//	    session.save(Subjects2);
//	    session.save(Subjects3);
//	    session.save(Subjects4);
//	    session.save(Subjects5);
//	    session.save(Subjects6);
//	    session.save(Subjects7);
//	    session.save(Subjects8);
//
//		
//		tx.commit();
	
	

	}

	}


