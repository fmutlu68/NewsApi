package com.fm.newsProject.models.concretes;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contents")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","news"})
public class Content extends com.fm.newsProject.core.entities.abstracts.Entity {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "content_first_part")
	private String contentFirstPart;
	
	@Column(name = "content_last_part")
	private String contentLastPart;

	@OneToOne(mappedBy = "content")
	private News news;

	@Override
	public String getEntityName() {
		return "Haber İçeriği";
	}
}
