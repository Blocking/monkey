package com.look.monkey.entity;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;

import com.look.monkey.entity.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role extends BaseEntity implements GrantedAuthority{
	
	private static final long serialVersionUID = 7801380365710567192L;

	private String roleName;

	@Override
	public String getAuthority() {
		return roleName;
	}
}
