package Database;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Collection;

public class JobsManager {
    public Jobs newJob(int companyID, String jobName, String jobDescription){
        Jobs job = new Jobs(companyID, jobName, jobDescription);

        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(job);
            session.getTransaction().commit();
            session.close();
            return job;
        }
        catch (HibernateException e){
            System.out.println("Hibernate Error!");
            return null;
        }
    }
}
