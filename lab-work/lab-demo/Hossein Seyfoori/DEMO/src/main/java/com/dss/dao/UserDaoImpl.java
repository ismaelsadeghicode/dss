package com.dss.dao;

import com.dss.model.Bank;
import com.dss.model.UserT;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserT> findAllUsers() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery(" from UserT order by id desc ");
        currentSession.flush();
        List<UserT> tblusers = query.list();



        return tblusers;


    }

    @Override
    public UserT getUserById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
//        Query query = currentSession.createQuery(" from UserT u where u.id = id ");
        UserT  user =  (UserT) currentSession.get(UserT.class, id);
        currentSession.flush();
//        UserT user = (UserT) query.getSingleResult();
        return user;
    }

    @Override
    public UserT getUserByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery(" from UserT u where u.email = :email ");
        query.setParameter("email",email);
        UserT user = (UserT) query.uniqueResult();
        if(user == null)
        {
            return null;
        }
        currentSession.flush();

        return user;
    }

    @Override
    public UserT getUserByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery(" from UserT u where u.username = :username ");
        query.setParameter("username",username);
        UserT user = (UserT) query.uniqueResult();

        return user;
    }


    @Override
    public void insertUser(UserT user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
        currentSession.flush();
    }

    @Override
    public void updateUser(UserT tbluser) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(tbluser);
        currentSession.flush();
    }

    @Override
    public void deteleUser(UserT tbluser) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(tbluser);
        currentSession.flush();

    }
}
