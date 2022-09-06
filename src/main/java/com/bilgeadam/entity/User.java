package com.bilgeadam.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String surName;
	private ERole role;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	private boolean enabled;
	@OneToMany(mappedBy = "user")
	private List<SubjectDetail> subjectDetails;

	public User() {

	}

	public User(String name, String surName, ERole role, LocalDate createdDate, LocalDate updatedDate,
			boolean enabled) {
		super();
		this.name = name;
		this.surName = surName;
		this.role = role;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<SubjectDetail> getSubjectDetails() {
		if (subjectDetails == null) {
			subjectDetails = new ArrayList<>();

		}
		return subjectDetails;
	}

	public void setSubjectDetails(List<SubjectDetail> subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surName=" + surName + ", role=" + role + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", enabled=" + enabled + ", subjectDetails="
				+ subjectDetails + "]";
	}

}
