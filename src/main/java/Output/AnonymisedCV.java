package Output;

import Database.Applications;
import Database.HibernateUtil;
import Database.Qualifications;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

public class AnonymisedCV {

    // query application table to access candidateID and jobID
    public void readApplication() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List applications = session.createQuery("FROM APPLICATIONS").list();
            for (Iterator<Applications> iterator = applications.iterator(); iterator.
                    hasNext(); ) {
                Applications application = iterator.next();
                System.out.print("CandidateID: " + application.getCandidateID());
                System.out.print("ApplicationID: " + application.getJobID());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // query qualification table with applicationID to access all qualifications
    public void readQualifications() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List qualifications = session.createQuery("FROM QUALIFICATIONS").list();
            for (Iterator<Qualifications> iterator = qualifications.iterator(); iterator.
                    hasNext(); ) {
                Qualifications qualification = iterator.next();
                System.out.print("Name: " + qualification.getName());
                System.out.print("Level: " + qualification.getLevel());
                System.out.print("Result: " + qualification.getResult());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
