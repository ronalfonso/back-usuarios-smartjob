package com.smartjob.servicio.users.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "phones", schema = "auths")
public class Phone implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "number", nullable = true)
    private String number;

    @Column(name = "city_code", nullable = true)
    private String cityCode;

    @Column(name = "country_code", nullable = true)
    private String countryCode;
}
