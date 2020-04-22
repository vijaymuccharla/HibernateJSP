package com.vj.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vj.dao.StudentDAO;
import com.vj.dao.StudentDAOimpl;
import com.vj.model.Student;

@WebServlet("/getall")
public class StudentsList extends HttpServlet {

	public StudentsList() {
		System.out.println("StudentsList.StudentsList()");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("StudentsList.doGet()");
		
		
		//1. create object to DAO
				StudentDAO dao=new StudentDAOimpl();
				
				//2. call method: getAllStudents
				List<Student> list=dao.getAllStudents();
				
				//3. Send data to UI as attribute
				req.setAttribute("list", list);
				
				//4. Goto UI Page : Data.jsp
				RequestDispatcher rd=req.getRequestDispatcher("Data.jsp");
				rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("StudentsList.doPost()");
		doGet(req,resp);
	}
}
