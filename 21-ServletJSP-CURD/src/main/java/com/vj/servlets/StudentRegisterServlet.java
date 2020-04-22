package com.vj.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vj.dao.StudentDAO;
import com.vj.dao.StudentDAOimpl;
import com.vj.model.Student;

@WebServlet("/register")
public class StudentRegisterServlet extends HttpServlet{

	public StudentRegisterServlet() {
		System.out.println("StudentRegisterServlet.StudentRegisterServlet()");
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("StudentRegisterServlet.doGet()");
		//1. Read Form Data
		String  s1=req.getParameter("sid");
		String  stdName=req.getParameter("sname");
		String  s2=req.getParameter("sfee");

		//2. Parse Data if required
		int stdId=Integer.parseInt(s1);
		double stdFee=Double.parseDouble(s2);

		//3. Create Model class object and set data to it
		Student sob=new Student();
		sob.setStdId(stdId);
		sob.setStdName(stdName);
		sob.setStdFee(stdFee);

		//4. Create Dao object and call saveStudent
		StudentDAO dao=new StudentDAOimpl();
		Integer id=dao.saveStudent(sob);

		//5. construct message and send to UI
		String message="Student saved with Id:"+id;
		req.setAttribute("msg", message);


		//6. Move to JSP Page using Dispatcher
		RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);


	}


	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("StudentRegisterServlet.doPost()");
		doGet(req,resp);
	}
}
