package com.vj.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {


	private static SessionFactory sf;

	static {
		sf=new Configuration().configure("com/vj/cfgs/hibernate.cfg.xml").buildSessionFactory();
	}

	public static SessionFactory getSf() {
		return sf;
	}
}
