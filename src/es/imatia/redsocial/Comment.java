package es.imatia.redsocial;

import java.time.LocalDate;

public class Comment {
	protected String commentText;
	protected LocalDate commentDate;
	protected User commentAuthor;
	
	public Comment(String commentText, LocalDate commentDate, User commentAuthor) {
		super();
		this.commentText = commentText;
		this.commentDate = commentDate;
		this.commentAuthor = commentAuthor;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public LocalDate getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(LocalDate commentDate) {
		this.commentDate = commentDate;
	}

	public User getCommentAuthor() {
		return commentAuthor;
	}

	public void setCommentAuthor(User commentAuthor) {
		this.commentAuthor = commentAuthor;
	}
	
	
	
}
