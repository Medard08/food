package org.polytech.persistence;

import org.polytech.buisness.User;

import javax.persistence.EntityManager;

public class JpaUserRepository implements UserRepository {
    private  EntityManager entityManager;

    public JpaUserRepository(EntityManager entityManager){
        this.entityManager.getTransaction().begin();
        this.entityManager = entityManager;
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void save(User user) {
        this.entityManager.persist(user);
    }

    @Override
    public void findById(Long id) {

    }
}
