package com.vj.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vj.dao.StudentDAO;
import com.vj.dao.StudentDAOimpl;
import com.vj.model.Student;

/**
 * Servlet implementation class StudentEditShowServlet
 */
public class StudentEditShowServlet extends HttpServlet {

	public StudentEditShowServlet() {
		System.out.println("StudentEditShowServlet.StudentEditShowServlet()");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. Read Parameter Id
				String sid=req.getParameter("id");
				
				//2. Parse Id to int type
				int id=Integer.parseInt(sid);
				//3. create Dao object
				StudentDAO dao=new StudentDAOimpl();
				
				//4. call getOneStudent method
				Student s=dao.getOneStudent(id);
				
				//5. send data to UI
				req.setAttribute("ob", s);
				
				//6. Dispatch to Edit Page
				RequestDispatcher rd=req.getRequestDispatcher("Edit.jsp");
				rd.forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
