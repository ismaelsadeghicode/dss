package com.dss.sales.services;

import com.dss.sales.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@EnableTransactionManagement
public class DataService {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public String increaseWalletCash(long cash,Users user){
        Session session=sessionFactory.getCurrentSession();
        long cashTemp = user.getWallet();
        long cashNow = cashTemp + cash;
        user.setWallet(cashNow);
        session.saveOrUpdate(user);
        session.flush();
        return "Cash has been increased!";
    }

    @Transactional
    public List<Users> findAllUsers(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Users order by id desc ");
        List<Users> list = query.list();
        session.flush();
        return list;
    }

    @Transactional
    public String findAndCheckUser(String username, String password){
        Session session = sessionFactory.getCurrentSession();
        Query query = null;
        Query query1 = null;
        query = session.createQuery("from Users u WHERE u.username = :user").setParameter("user",username);
        Users user1 = (Users) query.uniqueResult();
        if(user1!=null) {
            if (user1.getPassword()==password) {
                System.out.println("Welcome!");
                session.flush();
                return "Welcome!";
            }else {
                System.out.println("Wrong password!");
                session.flush();
                return "Wrong password!";
            }
        }else {
            System.out.println("User doesn't exist");
            session.flush();
            return "User doesn't exist";
        }
    }

    @Transactional
    public String checkAndCreateUser(String username,String password){
        Session session = sessionFactory.getCurrentSession();
        Query query=null;
        Query query1=null;
        query=session.createQuery("from Users u WHERE u.username = :user").setParameter("user",username);
        Users user1 = (Users) query.uniqueResult();
        if(user1!=null){
            session.flush();
            return "User Exist!";
        }else{
            Users newUser = new Users();
            newUser.setUsername(username);
            newUser.setPassword(password);
            addUser(newUser);
            session.flush();
            return "Welcome";
        }
    }

    @Transactional
    public Users findUserById(int id){
        Session session = sessionFactory.getCurrentSession();
        Users user1 = (Users) session.get(Users.class,id);
        session.flush();
        return user1;
    }

    @Transactional
    public  Users findUserByEmail(String email){
        Session session = sessionFactory.getCurrentSession();
        Users user1 = (Users) session.get(Users.class,email);
        session.flush();
        return user1;
    }

    @Transactional
    public Users findUserByUsername(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Users u WHERE u.username = :user").setParameter("user",username);
        Users user1 = (Users) query.uniqueResult();
        return user1;
    }

    @Transactional
    public void addUser(Users user){
        Session session= sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        session.flush();
    }

    @Transactional
    public void editUser(Users user){
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        session.flush();
    }

    @Transactional
    public void deleteUser(Users user){
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
        session.flush();
    }
}
