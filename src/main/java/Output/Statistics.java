package Output;

public class Statistics {
    public void readCandidate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List candidates = session.createQuery("FROM CANDIDATE").list();
            for (Iterator<Car> iterator = cars.iterator(); iterator.
                    hasNext(); ) {
                Application application = iterator.next();
                System.out.print("First Name: " + application.getFirstName());
                System.out.print("Last Name: " + application.getLastName());
                System.out.print("Gender: " + application.getGender());
                System.out.print("Ethnicity: " + application.getEthnicity());
                System.out.print("Email: " + application.getEmail());
                System.out.print("Phone: " + application.getPhone());
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
