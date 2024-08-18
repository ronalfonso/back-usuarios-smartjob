package com.smartjob.servicio.users.repository;

import com.smartjob.servicio.users.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByEmail(String email);

}
