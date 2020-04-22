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

@WebServlet("/delete")
public class StudentDelete extends HttpServlet {

	public StudentDelete() {
		System.out.println("StudentDelete.StudentDelete()");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("StudentDelete.doGet()");

		//1. Read ID param from Request URL
		String sid=req.getParameter("id");

		//2. Parse Id to int type
		int id=Integer.parseInt(sid);

		//3. create dao object and call deleteStudent() method
		StudentDAO dao=new StudentDAOimpl();
		String message=dao.deleteStudent(id);

		//4. send this message to UI
		req.setAttribute("message", message);

		//5. read new data from DB table send to UI
		List<Student> list=dao.getAllStudents();
		req.setAttribute("list", list);

		//6. Goto UI page
		RequestDispatcher rd=req.getRequestDispatcher("Data.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("StudentDelete.doPost()");
		doGet(req,resp);
	}

}
