package com.service.ship.repository;

import javax.persistence.EntityManager;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.service.ship.model.UserModel;

@Repository
@Transactional
public class AppUserRepository {
    @Autowired
    private EntityManager entityManager;

    public UserModel findUserAccount(String userName) {
        try {
            String sql = "Select e from " + UserModel.class.getName() + " e " //
                    + " Where e.userName = :userName ";
 
            Query query = entityManager.createQuery(sql, UserModel.class);
            query.setParameter("userName", userName);
 
            return (UserModel) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
