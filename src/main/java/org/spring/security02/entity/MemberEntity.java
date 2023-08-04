package org.spring.security02.entity;

import lombok.*;
import org.spring.security02.contrant.Role;
import org.spring.security02.dto.MemberDto;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "sec_member_02_t")
public class MemberEntity extends org.spring.security02.entity.BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long id;

  // username,passsord, role
  @Column(length = 255,nullable = false,unique = true)
  private String email; // User username -> UNIQUE

  @Column(nullable = false)
  private String pw;  // User password -> PassWordEncoder -> 반드시 암호화 해야된다.

  //role
  @Enumerated(EnumType.STRING)
  private Role role;


  public static MemberEntity toMemberEntity(MemberDto memberDto,
                                            PasswordEncoder passwordEncoder) {
    MemberEntity memberEntity=new MemberEntity();
    memberEntity.setEmail(memberDto.getEmail());
    // ****** 반드시 비빌번호 암호화
    memberEntity.setPw(passwordEncoder.encode(memberDto.getPw()));
    memberEntity.setRole(Role.MEMBER); //기본이  MEMBER
    return memberEntity;
  }
}
