package com.hyunbogi.jpaweb.repository.jpa;

import com.hyunbogi.jpaweb.domain.Item;
import com.hyunbogi.jpaweb.repository.ItemRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemRepositoryJpa implements ItemRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }

    @Override
    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    @Override
    public List<Item> findAll() {
        return em.createQuery("SELECT i FROM Item i", Item.class).getResultList();
    }
}
