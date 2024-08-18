package com.smartjob.servicio.users.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", schema = "auths")
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "el nombre es requerido")
    private String name;


    @Column(name = "email", nullable = false)
    @NotNull(message = "El correo es requerido")
    @Email(message = "Debe ser un correo valido ej: aaaaaaa@dominio.cl")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_phones", schema = "auths",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id", referencedColumnName = "id"))
    private List<Phone> phones;

    @Column(name = "created", nullable = false)
    @CreationTimestamp
    private LocalDate created;

    @Column(name = "modified", nullable = false)
    @UpdateTimestamp
    private LocalDateTime modified;

}
