package com.lmpeixoto.reservation.restaurant_reservation_system.dao;

import com.lmpeixoto.reservation.restaurant_reservation_system.dao.interfaces.ReservationDAO;
import com.lmpeixoto.reservation.restaurant_reservation_system.entities.Reservation;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ReservationImpl implements ReservationDAO {

    private EntityManager entityManager;

    @Autowired
    public ReservationImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Reservation theReservation) {

        entityManager.persist(theReservation);

    }

    @Override
    public Reservation findReservationById(int theId) {
        return entityManager.find(Reservation.class, theId);
    }

    @Override
    @Transactional
    public void deleteReservationById(int theId) {
        Reservation tempReservation = entityManager.find(Reservation.class, theId);
        entityManager.remove(tempReservation);
    }
}
