package com.hyunbogi.jpaweb.domain;

import com.hyunbogi.jpaweb.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@ToString
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    @Getter
    @Setter
    private Long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "price")
    @Getter
    @Setter
    private int price;

    @Column(name = "stock_quantity")
    @Getter
    @Setter
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    @Getter
    @Setter
    private List<Category> categories = new ArrayList<>();

    /**
     * 재고 수량을 증가시킨다.
     *
     * @param quantity 재고 수량
     */
    public void addStock(int quantity) {
        stockQuantity += quantity;
    }

    /**
     * 재고 수량을 감소시킨다.
     *
     * @param quantity 재고 수량
     */
    public void removeStock(int quantity) {
        int restStock = stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        stockQuantity = restStock;
    }
}
