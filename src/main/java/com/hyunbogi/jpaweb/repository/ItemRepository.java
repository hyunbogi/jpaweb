package com.hyunbogi.jpaweb.repository;

import com.hyunbogi.jpaweb.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
