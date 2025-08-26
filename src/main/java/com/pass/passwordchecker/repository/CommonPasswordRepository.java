package com.pass.passwordchecker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pass.passwordchecker.entity.CommonPassword;
import java.util.Optional;

@Repository
public interface CommonPasswordRepository extends JpaRepository<CommonPassword, Long> {
    Optional<CommonPassword> findByPassword(String password);
}