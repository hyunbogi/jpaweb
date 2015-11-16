package com.hyunbogi.jpaweb.repository;

import com.hyunbogi.jpaweb.domain.Member;

import java.util.List;

public interface MemberRepository {
    /**
     * DB에 회원 정보를 저장한다.
     *
     * @param member 저장할 회원 정보
     */
    void save(Member member);

    /**
     * DB에서 회원 정보를 가져온다.
     *
     * @param id 회원의 ID
     * @return 회원 정보
     */
    Member findOne(Long id);

    /**
     * DB에서 모든 회원 정보를 가져온다.
     *
     * @return 모든 회원 정보
     */
    List<Member> findAll();

    /**
     * DB에서 해당하는 이름의 회원 정보를 가져온다.
     *
     * @param name 회원의 이름
     * @return 회원 정보
     */
    List<Member> findByName(String name);
}
