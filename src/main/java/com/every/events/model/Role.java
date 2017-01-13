package com.every.events.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.every.events.utils.JPAInitEMF;

@Entity
@Table
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@Column(name = "ROLE_NAME")
	public String role_name;
	
	@Column(name = "ROLE_DESC")
	public String role_desc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_desc() {
		return role_desc;
	}

	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	
	public Role roleByName(String name) {
		try {
			JPAInitEMF jpa = new JPAInitEMF();
			List<Role> list = jpa.getEm().createQuery("SELECT r from Role r where r.role_name LIKE :n")
					.setParameter("n", name).getResultList();
			Role role = new Role();
			if (list == null) {
				return null;
			}
			else{
				role=list.get(0);
				return role;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No Data Found");
		}
		return null;
	}


}