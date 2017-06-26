package com.helloweenvsfei.petstore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_category")
public class CategoryEO implements Serializable {

	private static final long serialVersionUID = -703304755562889369L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id")
	private CategoryEO parent;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
	private Set<CategoryEO> subCategories = new HashSet<CategoryEO>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private List<PetEO> pets = new ArrayList<PetEO>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int hashCode() {
		return (this.id == null) ? 0 : this.id.hashCode();
	}

	public boolean equals(Object object) {
		if (object instanceof CategoryEO) {
			final CategoryEO obj = (CategoryEO) object;
			return (this.id != null) ? this.id.equals(obj.id)
					: (obj.id == null);
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryEO getParent() {
		return parent;
	}

	public void setParent(CategoryEO parent) {
		this.parent = parent;
	}

	public Set<CategoryEO> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<CategoryEO> subCategories) {
		this.subCategories = subCategories;
	}

	public List<PetEO> getPets() {
		return pets;
	}

	public void setPets(List<PetEO> pets) {
		this.pets = pets;
	}

}
