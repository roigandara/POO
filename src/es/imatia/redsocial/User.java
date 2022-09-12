package es.imatia.redsocial;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class User {
	protected String name;
	protected List<User> followList = new ArrayList<User>();
	protected List<Post> postList = new ArrayList<Post>();
	protected String option = "";
	
	// CONSTRUCTOR
	public User(String name) {
		this.name = name;
	}
	
	// GETTERS SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPostList() {
		return postList;
	}
	
	public Post getPost(int number) {
		return postList.get(number);
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	// METHODS
	public List<User> getFollowList() {
		return followList;
	}

	public void setFollowList(List<User> followList) {
		this.followList = followList;
	}
	
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	// Comenzar a seguir usuario
	public void follow(User user) {
		Set<User> set = new HashSet<User>(followList);
		if(set.add(user) == true) {
			this.followList.add(user);
			System.out.println("Comezouse a seguir a " + user.getName());
		} else {
			System.out.println("Xa se estaba seguindo a " + user.getName());
		}

	}
	

	// Dejar de seguir usuario
	public void unfollow(User user) {
		if (this.followList.remove(user)) {
			this.followList.remove(user);
			System.out.println("Deixouse de seguir a " + user.getName());
		} else {
			System.out.println("Non estabas seguindo previamente a " + user.getName());
		}
	}
	
	// postea publicaciones
	public void postsList() {
        int i=1;
        for (Post p : postList) {
            if (p instanceof TextPost) {
                System.out.println(i + ".  (Texto: )" + p.getPostDate() + "  -  " + ((TextPost) p).getPostText());
            } else if(p instanceof ImagePost) {
                System.out.println(i + ".  (Imaxe: )" + p.getPostDate() + "  -  " + ((ImagePost) p).getImageTitle());
            } else if(p instanceof VideoPost) {
                System.out.println(i + ".  (Vídeo: )" + p.getPostDate() + "  -  " + ((VideoPost) p).getVideoTitle());
            }
            i++;
        }
    }
	

	
}
