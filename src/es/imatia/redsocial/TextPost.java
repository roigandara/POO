package es.imatia.redsocial;

import java.time.LocalDate;
import java.util.List;

public class TextPost extends Post {
	private String postText;
	
	

	public String getPostText() {
		return postText;
	}



	public void setPostText(String postText) {
		this.postText = postText;
	}



	public TextPost(LocalDate postDate, List<Comment> postCommentList, String postText) {
		super(postDate, postCommentList);
		this.postText = postText;
	}
	
	
}
