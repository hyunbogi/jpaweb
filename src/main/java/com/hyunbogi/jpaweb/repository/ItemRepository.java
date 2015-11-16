package com.hyunbogi.jpaweb.repository;

import com.hyunbogi.jpaweb.domain.Item;

import java.util.List;

public interface ItemRepository {
    /**
     * DB에 상품 정보를 저장한다.
     *
     * @param item 상품 정보
     */
    void save(Item item);

    /**
     * DB에서 상품 정보를 조회한다.
     *
     * @param id 상품 ID
     * @return 상품 정보
     */
    Item findOne(Long id);

    /**
     * DB에서 모든 상품의 정보를 조회한다.
     *
     * @return 모든 상품 정보
     */
    List<Item> findAll();
}
