package Output;

import Database.Candidates;
import Database.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

public class Statistics {
    public void readCandidate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List candidates = session.createQuery("FROM CANDIDATES").list();
            for (Iterator<Candidates> iterator = candidates.iterator(); iterator.
                    hasNext(); ) {
                Candidates candidate = iterator.next();
                System.out.print("First Name: " + candidate.getFirstName());
                System.out.print("Last Name: " + candidate.getLastName());
                System.out.print("Gender: " + candidate.getGender());
                System.out.print("Ethnicity: " + candidate.getEthnicity());
                System.out.print("Email: " + candidate.getEmail());
                System.out.print("Phone: " + candidate.getPhone());
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
