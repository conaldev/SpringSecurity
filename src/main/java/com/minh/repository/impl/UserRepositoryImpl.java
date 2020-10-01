package com.minh.repository.impl;


import com.minh.model.MyUser;
import com.minh.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MyUser> findAll() {
        TypedQuery<MyUser> query = em.createQuery("select u from MyUser u",MyUser.class);
        return query.getResultList();
    }

    @Override
    public MyUser findById(Long id) {
        TypedQuery<MyUser> query = em.createQuery("select u from MyUser u where u.id =: id",MyUser.class);
        query.setParameter("id", id);
        try{
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(MyUser model) {
        if(model != null){
            em.merge(model);
        }else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        MyUser user = findById(id);
        em.remove(user);
    }
}
