package com.smartjob.servicio.users.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
public class Mapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    /**
     * Mapea una entidad a un DTO
     */
    public static <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

    /**
     * Mapea una lista de entidades a una lista de DTOs
     */
    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }

    /**
     * Mapea una pageable de entidades a un pageable de DTOs
     */
    public static <D, T> Page<D> mapPage(Page<T> entityPage, Class<D> outClass) {
        List<D> dtoList = entityPage.getContent().stream()
                .map(entity -> modelMapper.map(entity, outClass))
                .collect(Collectors.toList());

        return new PageImpl<>(dtoList, entityPage.getPageable(), entityPage.getTotalElements());
    }
}
