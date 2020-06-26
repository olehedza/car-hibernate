package mate.academy.car.dao.impl;

import java.util.List;
import mate.academy.car.dao.CarDoorDao;
import mate.academy.car.error.DatabaseConnectionException;
import mate.academy.car.lib.Dao;
import mate.academy.car.model.CarDoor;
import mate.academy.car.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class CarDoorDaoImpl implements CarDoorDao {
    private static final Logger LOGGER = Logger.getLogger(CarDoorDaoImpl.class);

    @Override
    public CarDoor add(CarDoor carDoor) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(carDoor);
            transaction.commit();
            LOGGER.info("car door added to DB");
            return carDoor;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseConnectionException("Failed to add car door to DB", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<CarDoor> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<CarDoor> carQuery = session
                    .createQuery("select c from CarDoor c", CarDoor.class);
            return carQuery.getResultList();
        } catch (Exception e) {
            throw new DatabaseConnectionException("Can't get all car doors from DB", e);
        }
    }
}
