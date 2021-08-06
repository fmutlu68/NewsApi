package com.fm.newsProject.models.concretes;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News extends com.fm.newsProject.core.entities.abstracts.Entity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "number_of_newsviews")
	private int numberOfNewsviews;
	
	@Column(name = "image_link")
	private String imageLink;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "added_date")
	private Date addedDate;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Column(name = "news_type")
	private String newsType;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "writer_id")
	private Writer writer;

	@OneToOne
	@JoinColumn(name = "content_id")
	private Content content;

	@Override
	public String getEntityName() {
		return "Haber";
	}
}
