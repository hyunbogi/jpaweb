package com.hyunbogi.jpaweb.repository;

import com.hyunbogi.jpaweb.domain.Order;
import com.hyunbogi.jpaweb.repository.custom.CustomOrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderRepository
        extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order>, CustomOrderRepository {
}
