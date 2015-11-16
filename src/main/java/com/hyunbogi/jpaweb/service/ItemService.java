package com.hyunbogi.jpaweb.service;

import com.hyunbogi.jpaweb.domain.Item;

import java.util.List;

public interface ItemService {
    /**
     * 상품을 저장한다.
     *
     * @param item 상품 정보
     */
    void saveItem(Item item);

    /**
     * 모든 상품을 조회한다.
     *
     * @return 모든 상품 정보
     */
    List<Item> findItems();

    /**
     * 상품 ID에 해당하는 상품을 조회한다.
     *
     * @param itemId 상품 ID
     * @return 상품 정보
     */
    Item findOne(Long itemId);
}
