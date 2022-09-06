package com.bilgeadam.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.entity.Answer;
import com.bilgeadam.entity.Lesson;
import com.bilgeadam.entity.Question;
import com.bilgeadam.entity.Subject;
import com.bilgeadam.entity.SubjectDetail;
import com.bilgeadam.entity.User;

public class HibernateUtils {

	// hibernate ile baðlantýmýzý kuracak

	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {
		try {
			Configuration configuration = new Configuration();

			// Entity claslarýmýzý buraya ekliyoruz

			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Subject.class);
			configuration.addAnnotatedClass(SubjectDetail.class);
			configuration.addAnnotatedClass(Answer.class);
			configuration.addAnnotatedClass(Question.class);
			configuration.addAnnotatedClass(Lesson.class);

			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

			return factory;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
