package com.smartjob.servicio.users.repository;

import com.smartjob.servicio.users.domain.entity.Auth;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Repository
public interface AuthRepository extends JpaRepository<Auth, UUID> {

    Page<Auth> findAll(Specification<Auth> spec, Pageable pageable);

    Optional<Auth> findByEmail(String email);

}
