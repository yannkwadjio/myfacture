package com.myfacture.entity;

import com.myfacture.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "utilisateur")
public class Utilisateur implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private Long phoneNumber;
    private String fullName;
    private String password;
    private String passwordConfirmation;
    private int numberConnexion;
    private boolean isActivate;
    private boolean isConnected;
    private String activationCode;
    private String passwordResetCode;
    @ElementCollection
    private Set<Role> role;
    private String Enterprise;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActivate;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActivate;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActivate;
    }

    @Override
    public boolean isEnabled() {
        return isActivate;
    }
}
