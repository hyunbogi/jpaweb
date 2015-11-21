package com.hyunbogi.jpaweb.domain.spec;

import com.hyunbogi.jpaweb.domain.Member;
import com.hyunbogi.jpaweb.domain.Order;
import com.hyunbogi.jpaweb.domain.OrderStatus;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class OrderSpec {
    public static Specification<Order> memberNameLike(final String memberName) {
        return (root, query, cb) -> {
            if (StringUtils.isEmpty(memberName)) {
                return null;
            }

            Join<Order, Member> m = root.join("member", JoinType.INNER);

            return cb.like(m.<String>get("name"), "%" + memberName + "%");
        };
    }

    public static Specification<Order> orderStatusEq(OrderStatus orderStatus) {
        return (root, query, cb) -> {
            if (orderStatus == null) {
                return null;
            }

            return cb.equal(root.get("status"), orderStatus);
        };
    }
}
