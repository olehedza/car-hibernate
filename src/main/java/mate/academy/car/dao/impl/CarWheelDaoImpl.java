package mate.academy.car.dao.impl;

import java.util.List;
import mate.academy.car.dao.CarWheelDao;
import mate.academy.car.error.DatabaseConnectionException;
import mate.academy.car.model.CarWheel;
import mate.academy.car.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CarWheelDaoImpl implements CarWheelDao {
    private static final Logger LOGGER = Logger.getLogger(CarWheelDaoImpl.class);

    @Override
    public CarWheel add(CarWheel carWheel) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(carWheel);
            transaction.commit();
            LOGGER.info("car wheel added to DB");
            return carWheel;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseConnectionException("Failed to add car wheel to DB", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<CarWheel> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<CarWheel> carQuery = session
                    .createQuery("select c from CarWheel c", CarWheel.class);
            return carQuery.getResultList();
        } catch (Exception e) {
            throw new DatabaseConnectionException("Can't get all car wheels from DB", e);
        }
    }
}
