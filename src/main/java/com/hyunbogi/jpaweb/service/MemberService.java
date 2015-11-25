package com.hyunbogi.jpaweb.service;

import com.hyunbogi.jpaweb.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface MemberService {
    /**
     * 회원으로 가입한다.
     *
     * @param member 가입할 회원 정보
     * @return 가입한 회원의 ID
     */
    Long join(Member member);

    /**
     * 모든 회원 정보를 가져온다.
     *
     * @return 모든 회원들의 정보
     */
    @Transactional(readOnly = true)
    List<Member> findMembers();

    /**
     * 회원 정보를 가져온다.
     *
     * @param memberId 가져올 회원의 ID
     * @return 회원 정보
     */
    @Transactional(readOnly = true)
    Member findOne(Long memberId);
}
