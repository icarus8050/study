package com.edu.jpatraining.service;

import com.edu.jpatraining.domain.Member;
import com.edu.jpatraining.domain.request.ModifyMemberDto;

public interface MemberService {

    Member findById(Long id);
    Member modifyMember(Long id, ModifyMemberDto modifyMemberDto);
}
