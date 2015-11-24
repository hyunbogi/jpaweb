package com.hyunbogi.jpaweb.service.impl;

import com.hyunbogi.jpaweb.domain.Item;
import com.hyunbogi.jpaweb.repository.ItemRepository;
import com.hyunbogi.jpaweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
