package com.bilgeadam.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	private String name;
	private String description;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	private boolean enabled;

	@OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
	List<Subject> subjects;

	public Lesson(String name, String description, LocalDate createdDate, LocalDate updatedDate, boolean enabled) {
		super();
		this.name = name;
		this.description = description;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.enabled = enabled;
	}

	public Lesson() {

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<Subject> getSubjects() {
		if (this.subjects == null) {
			subjects = new ArrayList<>();
		}
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Lesson [id=" + id + ", name=" + name + ", description=" + description + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", enabled=" + enabled + ", subjects=" + subjects + "]";
	}

}
