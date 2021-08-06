package com.fm.newsProject.models.concretes;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","news"})
public class Category extends com.fm.newsProject.core.entities.abstracts.Entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private int id;
	
	@Column(name = "category_name")
	private String categoryName;

	@OneToMany(mappedBy = "category")
	private List<News> news;
}
