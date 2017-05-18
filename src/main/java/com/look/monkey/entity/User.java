package com.look.monkey.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.look.monkey.entity.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends BaseEntity implements UserDetails{
	
	private static final long serialVersionUID = 9059490884279123435L;
	
	private String username;
	private String password;
	@Email
	private String email;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Role> role;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return role;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
}
