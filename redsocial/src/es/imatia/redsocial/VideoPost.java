package es.imatia.redsocial;

import java.time.LocalDate;
import java.util.List;

public class VideoPost extends Post {
	private String videoTitle;
	private String quality; // array?
	private int duration; // time?
	
	public VideoPost(LocalDate postDate, List<Comment> postCommentList, String videoTitle, String quality, int duration) {
		super(postDate, postCommentList);
		this.videoTitle = videoTitle;
		this.quality = quality;
		this.duration = duration;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	
	
}
