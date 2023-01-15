package com.cisco.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cisco.config.HibernateConfig;
import com.cisco.entity.Subjects;


public class SubjectsDAO {
	public SubjectsDAO() {
		// TODO Auto-generated constructor stub
	}
	public void insertSubjectInDB(Subjects sb) {
		Transaction transaction = null;
		Session dbSession = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			//start the transaction
			transaction = dbSession.beginTransaction();
			//save the object of student
			dbSession.save(sb);
			//commit the transaction
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			dbSession.close();
		}
		
	}
}
