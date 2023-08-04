package org.spring.security02.repository;

import org.spring.security02.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository
public interface MemberRopository extends JpaRepository<MemberEntity,Long> {
  Optional<MemberEntity> findByEmail(String email);
}
