package com.fm.newsProject.models.concretes;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "writers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","news"})
public class Writer extends com.fm.newsProject.core.entities.abstracts.Entity {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int writerId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "background")
	private String background;
	
	@Column(name = "introduce")
	private String introduce;
	
	@Column(name = "image_link")
	private String imageLink;

	@OneToMany(mappedBy = "writer")
	private List<News> news;

	@Override
	public String getEntityName() {
		return "Yazar";
	}
}
