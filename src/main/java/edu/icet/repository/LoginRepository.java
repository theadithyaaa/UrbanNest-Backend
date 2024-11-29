package edu.icet.repository;

import edu.icet.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository <LoginEntity, String> {
    Optional<LoginEntity> findByEmailOrPassword(String email, String password);
    LoginEntity findByEmail(String email);

    //LoginEntity findByEmailOrPassword(String email);
    //LoginEntity.findByEmail(String email);
}
