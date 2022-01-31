package com.mustafin.learningtask.authmicroservice.mapper;

import com.mustafin.learningtask.authmicroservice.enums.Status;
import com.mustafin.learningtask.authmicroservice.models.User;
import com.mustafin.learningtask.authmicroservice.security.SecurityUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

@Mapper(componentModel = "spring", imports = {SimpleGrantedAuthority.class, Set.class, Status.class})
public interface UserMapper{
    String ROLE_PREFIX = "ROLE_";

    @Mapping(target = "username", source = "user.email")
    @Mapping(target = "authorities", expression = "java(Set.of(new SimpleGrantedAuthority(ROLE_PREFIX + user.getRole().name())))")
    @Mapping(target = "active", expression = "java(user.getStatus().equals(Status.ACTIVE))")
    SecurityUser toSecurityUser(User user);
}
