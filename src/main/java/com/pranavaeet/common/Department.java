package com.pranavaeet.common;

public class Department {
	private String id;
	private String name;
	private String description;
	private String code;
	
	public Department() {
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Department[id=" + id + ", name=" + name + ", description=" + description + ", code=" + code + "]";
	}		
	
	
}
