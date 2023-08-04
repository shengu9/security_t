package org.spring.security02.dto;

import lombok.*;
import org.spring.security02.contrant.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MemberDto {

  private Long id;

  @Size(min = 3,max = 255)
  private String email; // User username -> UNIQUE

  @NotBlank(message = "비빌번호를 입력하세요.")
  private String pw;  // User password -> PassWordEncoder -> 반드시 암호화 해야된다.

  private Role role;

  private LocalDateTime createTime;

  private LocalDateTime updateTime;

}
