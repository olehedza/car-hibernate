package mate.academy.car.dao.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.car.dao.CarDao;
import mate.academy.car.error.DatabaseConnectionException;
import mate.academy.car.model.Car;
import mate.academy.car.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {
    private static final Logger LOGGER = Logger.getLogger(CarDaoImpl.class);

    @Override
    public Car add(Car car) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
            LOGGER.info("car added to DB");
            return car;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseConnectionException("Failed to add car to DB", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Car> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Car> carQuery = session
                    .createQuery("select c from Car c", Car.class);
            return carQuery.getResultList();
        } catch (Exception e) {
            throw new DatabaseConnectionException("Can't get all cars from DB", e);
        }
    }

    @Override
    public Optional<Car> getById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Car> carQuery = session
                    .createQuery("from Car where id = :id", Car.class);
            carQuery.setParameter("id", id);
            return carQuery.uniqueResultOptional();
        } catch (Exception e) {
            throw new DatabaseConnectionException(String
                    .format("Can't get car from DB by id:%d", id), e);
        }
    }

    @Override
    public List<Car> getCarsByEngineType(String engineType) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Car> carQuery = session
                    .createQuery("select c from Car c where c.engineType = :engineType",
                            Car.class);
            carQuery.setParameter("engineType", engineType);
            return carQuery.getResultList();
        } catch (Exception e) {
            throw new DatabaseConnectionException("Can't get all cars from DB", e);
        }
    }
}
