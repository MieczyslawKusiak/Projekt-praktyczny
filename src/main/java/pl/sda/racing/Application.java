package pl.sda.racing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.File;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        final Pigeon pigeon = new Pigeon();
        pigeon.setName("Bielik");
        pigeon.setOwner("Janusz");
        SessionFactory sessionFactory = new Configuration().configure(new File("resources/hibernate.cfg.xml")).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(pigeon);
        transaction.commit();
        session.close();
        Session session1 = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session1.getCriteriaBuilder();
        CriteriaQuery<Pigeon> cr = criteriaBuilder.createQuery(Pigeon.class);
        Root<Pigeon> root = cr.from(Pigeon.class);
        Query<Pigeon> query = session1.createQuery(cr);
        List<Pigeon> result = query.getResultList();
        criteriaBuilder.createQuery(Pigeon.class);
        for (Pigeon pigeon1 : result) {
            System.out.println(result);
        }
        sessionFactory.close();
    }
}




