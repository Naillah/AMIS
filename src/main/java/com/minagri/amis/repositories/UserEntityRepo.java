package com.minagri.amis.repositories;

import com.minagri.amis.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity, Long> {

    boolean existsByIdentificationDocNumber(String identificationDocNumber);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
