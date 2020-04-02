package Database;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Manager {
    public Boolean dbInsert(Object obj) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            System.out.println("Hibernate Error!");
            return false;

        }
    }
    public Qualifications newQualification(int applicationID, String name, String level, String result){
        Qualifications qualification = new Qualifications(applicationID, name, level, result);
        if(dbInsert(qualification)) {
            return qualification;
        }
        else return null;

    }
    public Applications newApplication(int candidateID, int jobID){
        Applications application = new Applications(candidateID, jobID);
        if(dbInsert(application)) {
            return application;
        }
        else return null;

    }
    public Candidates newCandidate(String firstName, String lastName, String gender, String ethnicity, String
        email, String phone){
            Candidates candidate = new Candidates(firstName, lastName, gender, ethnicity, email, phone);
            if(dbInsert(candidate)) {
                return candidate;
            }
            else return null;
    }
    public Companies newCompany (String name, String phone, String email){
        Companies company = new Companies(name, phone, email);
        if(dbInsert(company)) {
            return company;
        }
        else return null;

    }
    public Jobs newJob ( int companyID, String jobName, String jobDescription){
        Jobs job = new Jobs(companyID, jobName, jobDescription);
        if(dbInsert(job)) {
            return job;
        }
        else return null;
    }
}

