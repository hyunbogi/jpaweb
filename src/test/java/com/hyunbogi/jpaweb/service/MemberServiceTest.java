package com.hyunbogi.jpaweb.service;

import com.hyunbogi.jpaweb.domain.Member;
import com.hyunbogi.jpaweb.repository.MemberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:appConfig.xml")
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    private Member[] members;

    @Before
    public void setUp() {
        members = new Member[2];
        for (int i = 0; i < members.length; ++i) {
            members[i] = new Member();
            members[i].setName("kim");
        }
    }

    @Test
    @Transactional
    public void signUp() {
        Long saveId = memberService.join(members[0]);
        assertEquals(members[0], memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    @Transactional
    public void duplicateMember() {
        memberService.join(members[0]);
        memberService.join(members[1]);
        fail("Must thorw exception");
    }
}
