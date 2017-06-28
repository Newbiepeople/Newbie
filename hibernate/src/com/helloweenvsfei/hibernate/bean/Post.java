package com.helloweenvsfei.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST})
	@JoinTable(
			name = "tb_tag_post", 
			joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id")
	)
	private Set<Tag> tags = new HashSet<Tag>();;

	private String title;

	@Column(columnDefinition="text")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
