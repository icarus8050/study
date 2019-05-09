package com.example.jpaedu.service;

import com.example.jpaedu.domain.Member;
import com.example.jpaedu.repository.MemberReposiroty;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberReposiroty memberReposiroty;

    public Member signUp(String name, Integer age) {
        Member memberInfo = Member.builder()
                .name(name)
                .age(age)
                .build();
        return memberReposiroty.save(memberInfo);
    }

    public Member find(Long id) {
        return memberReposiroty.findById(id).orElse(null);
    }

    public Member findByUserName(String name) {
        return memberReposiroty.findByUserName(name);
    }

    //PageRequest는 deprecated 되었다.
    public Page<Member> findByPagingMember(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ?
                0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return memberReposiroty.findAll(pageable);
    }
}
