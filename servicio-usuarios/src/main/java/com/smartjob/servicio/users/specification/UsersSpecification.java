package com.smartjob.servicio.users.specification;

import com.smartjob.servicio.users.domain.entity.Auth;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@And({
        @Spec(path = "id", params = "id", spec = Equal.class),
        @Spec(path = "name", params = "name", spec = LikeIgnoreCase.class),
        @Spec(path = "created", params = {"dateFrom", "dateTo"}, spec = Between.class, config = "yyyy-MM-dd"),
})
public interface UsersSpecification extends Specification<Auth> {
}
