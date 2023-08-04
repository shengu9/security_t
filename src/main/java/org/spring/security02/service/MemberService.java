package org.spring.security02.service;

import lombok.RequiredArgsConstructor;
import org.spring.security02.dto.MemberDto;
import org.spring.security02.entity.MemberEntity;
import org.spring.security02.repository.MemberRopository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRopository memberRopository;

  private final PasswordEncoder passwordEncoder;
  public void memberInsert(MemberDto memberDto) {

    MemberEntity memberEntity
            = MemberEntity.toMemberEntity(memberDto,passwordEncoder);

    Long memberId= memberRopository.save(memberEntity).getId();

    MemberEntity memberEntity1
            = memberRopository.findById(memberId).orElseThrow(()->{
       throw new IllegalArgumentException("아이디가 없습니다.");
    });


  }
}
