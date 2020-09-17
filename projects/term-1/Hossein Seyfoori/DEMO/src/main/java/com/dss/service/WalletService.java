package com.dss.service;

import com.dss.dao.UserDao;
import com.dss.dao.UserDaoImpl;
import com.dss.model.UserT;
import com.dss.model.Wallet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional
public class WalletService {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserDao userDao;
    Logger logger = Logger.getLogger(WalletService.class.getName());
    public int checkExistWallet(int user_id)
    {

        Session currentSession = sessionFactory.getCurrentSession();
        NativeQuery sqlQuery = currentSession.createSQLQuery("select wallet_id from usert_wallet where usert_id =" + user_id);
        List resultList = sqlQuery.getResultList();
//        System.out.println("resultList = " + resultList.size());
        return resultList.size();
    }

    public ModelAndView create(String name,HttpSession session){
        Session currentSession = sessionFactory.getCurrentSession();

        int user_id=0;
        if(session.getAttribute("user_id") !=null)
        {
            user_id = (int) session.getAttribute("user_id");
        }




        if(name.equals(""))
        {
            return new ModelAndView("/wallet","message","نام کیف پول خال است.");
        }

        UserT user = userDao.getUserById(user_id);

        ModelAndView mv = new ModelAndView("/wallet");
        Query query = currentSession.createQuery(" from Wallet u where u.name = :name ");
        query.setParameter("name",name);
        Optional optional =  query.uniqueResultOptional();
        if(optional.isPresent())
        {
            return new ModelAndView("/wallet","message","این نام کیف پول وجود دارد");
        }

        Wallet wallet = new Wallet();
        wallet.setName(name);
        currentSession.save(wallet);
        mv.addObject("user",user);
        return mv;
    }

    public List<Wallet> allWallets()

    {
        Session currentSession = sessionFactory.getCurrentSession();
        Query from_wallet = currentSession.createQuery("from Wallet");
        List list = from_wallet.list();
        return list;
    }

    public String delete(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        Wallet wallet = currentSession.find(Wallet.class, id);
        currentSession.delete(wallet);
        return "redirect:/wallet";
    }

}
