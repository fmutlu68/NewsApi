package com.fm.newsProject.models.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends com.fm.newsProject.core.entities.abstracts.Entity {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "news_id")
	private int newsId;
	
	@Column(name = "comment_writer")
	private String commentWriter;
	
	@Column(name = "comment_content")
	private String commentContent;
	
	@Column(name = "added_date")
	private Date addedDate;
	
	@Column(name = "like_count")
	private int likeCount;
	
	@Column(name = "dislike_count")
	private int dislikeCount;

	@Override
	public String getEntityName() {
		return "Yorum";
	}
}
