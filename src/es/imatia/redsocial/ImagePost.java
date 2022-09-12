package es.imatia.redsocial;

import java.time.LocalDate;
import java.util.List;

public class ImagePost extends Post {
	private String imageTitle;
	private int imageWidth;
	private int imageHeight;
	// Array? ^
	
	// CONSTRUCTOR IMAGE
	public ImagePost(LocalDate postDate, List<Comment> postCommentList, String imageTitle, int imageWidth, int imageHeight) {
		super(postDate, postCommentList);
		this.imageTitle = imageTitle;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}

	public String getImageTitle() {
		return imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
	

	
	
	

	
	
}
