package com.fm.newsProject.models.dtos;

import java.util.Date;
import java.util.List;

import com.fm.newsProject.core.entities.abstracts.Dto;
import com.fm.newsProject.models.concretes.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDto implements Dto{
	private int newsId;
	private int writerId;
	private int contentId;
	private String newsImageLink;
	private String newsTitle;
	private String writerName;
	private String newsContent;
	private List<Comment> comments;
	private Date addedDate;
	private Date updatedDate;
}
