package com.fm.newsProject.models.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "news_sites")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsSite extends com.fm.newsProject.core.entities.abstracts.Entity {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "editor_in_chief")
	private String editorInChief;
	
	@Column(name = "web_site")
	private String WebSite;
	
	@Column(name = "popularity")
	private int popularity;

	@Override
	public String getEntityName() {
		return "Haber Sitesi";
	}
}
