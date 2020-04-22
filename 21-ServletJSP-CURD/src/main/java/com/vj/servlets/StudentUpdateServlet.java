package com.vj.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vj.dao.StudentDAO;
import com.vj.dao.StudentDAOimpl;
import com.vj.model.Student;

public class StudentUpdateServlet extends HttpServlet {
	
//	Read form data-> Object->update in DB
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. Read Form data as params
				String sid=req.getParameter("sid");
				String stdName=req.getParameter("sname");
				String sfee=req.getParameter("sfee");

				//2. parse data if required
				int stdId=Integer.parseInt(sid);
				double stdFee=Double.parseDouble(sfee);

				//3. create Model class object
				Student s=new Student();
				s.setStdId(stdId);
				s.setStdName(stdName);
				s.setStdFee(stdFee);

				//4. create dao object
				StudentDAO dao=new StudentDAOimpl();

				//5. call update method
				String msg=dao.updateStudent(s);

				//6. send message to UI
				req.setAttribute("message", msg);

				//7. Read new records and send to UI
				List<Student> list=dao.getAllStudents();
				req.setAttribute("list", list);

				//8. Dispatch to UI
				RequestDispatcher rd=req.getRequestDispatcher("Data.jsp");
				rd.forward(req, resp);
				
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
