package com.vj.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vj.model.Student;
import com.vj.utils.HibernateUtil;

public class StudentDAOimpl implements StudentDAO {

	@Override
	public Integer saveStudent(Student s) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		Integer id=null;
		try (ses){
			tx=ses.beginTransaction();

			//operations
			id=(Integer) ses.save(s);

			tx.commit();

		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<Student> getAllStudents() {
		String HQL=" from "+Student.class.getName();
		//String HQL=" from in.nit.model.Student ";
		Session ses=HibernateUtil.getSf().openSession();
		List<Student> list=null;
		try(ses) {
			Query q=ses.createQuery(HQL);
			list=q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public String deleteStudent(Integer id) {
		String message=null;
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			Student s=new Student();
			s.setStdId(id);
			//This method takes object having PK
			ses.delete(s);
			
			tx.commit();
			message="Student '"+id+"' deleted";
		} catch (Exception e) {
			if(tx!=null & tx.getStatus().canRollback()){
				tx.rollback();
			}
			message="Student '"+id+"' not exist";
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public Student getOneStudent(Integer id) {
				Session ses=HibernateUtil.getSf().openSession();
				Student s=null;
				try(ses) {
					s=ses.get(Student.class, id);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return s;
	}

	@Override
	public String updateStudent(Student s) {
		String msg=null;
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try {
			tx=ses.beginTransaction();
			
			ses.update(s);
			
			tx.commit();
			msg="Student '"+s.getStdId()+"' Updated";
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback())
				tx.rollback();
			msg="Student '"+s.getStdId()+"' Not exist";
			e.printStackTrace();
		}
		return msg;
	}

}
