package Output;

public class AnonymisedCV {

    // query application table to access candidateID and jobID
    public void readApplication() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List applications = session.createQuery("FROM APPLICATION").list();
            for (Iterator<Car> iterator = cars.iterator(); iterator.
                    hasNext(); ) {
                Application application = iterator.next();
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
            for (Iterator<Car> iterator = cars.iterator(); iterator.
                    hasNext(); ) {
                Application application = iterator.next();
                System.out.print("Name: " + application.getName());
                System.out.print("Level: " + application.getLevel());
                System.out.print("Result: " + application.getResult());
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
