package com.mustafin.learningtask.authmicroservice.security;

import com.mustafin.learningtask.authmicroservice.enums.Role;
import com.mustafin.learningtask.authmicroservice.enums.Status;
import com.mustafin.learningtask.authmicroservice.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
public class SecurityUser implements UserDetails {
    private final String ROLE_PREFIX = "ROLE_";

    private Long id;
    private Role role;
    private String username;
    private String password;
    private Set<SimpleGrantedAuthority> authorities;
    private boolean isActive;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public Long getId() { return id;}

    public Role getRole() { return role;}
}
