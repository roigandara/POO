package es.imatia.redsocial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Post {
	protected LocalDate postDate;
	protected List<Comment> postCommentList = new ArrayList<Comment>();
	
	// constructor
	public Post(LocalDate postDate, List<Comment> postCommentList) {
		this.postDate = postDate;
		this.postCommentList = postCommentList;
	}


	public LocalDate getPostDate() {
		return postDate;
	}


	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}


	public List<Comment> getPostCommentList() {
		return postCommentList;
	}


	public void setPostCommentList(List<Comment> postCommentList) {
		this.postCommentList = postCommentList;
	}
	
	public void listComments() {
		for (Comment c : postCommentList) {
			System.out.println(c.getCommentDate() + " " + c.getCommentAuthor().getName() + ": " + c.getCommentText());
		}
	}
	
	public void listComments(User user) {
		for (Comment c : postCommentList) {
			if (c.getCommentAuthor() == user) {
				System.out.println(c.getCommentDate() + " " + c.getCommentAuthor().getName() + ": " + c.getCommentText());
			}
		}
	}
	
	public int countComments() {
		return postCommentList.size();
	}
	
	public void deletePost(User user, int index) {
		user.postList.remove(index-1);
	}

}
