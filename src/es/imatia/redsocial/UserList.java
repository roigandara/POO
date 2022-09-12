package es.imatia.redsocial;
import java.util.List;

public class UserList {
	private List<User> userList;
	
	// CONSTRUCTOR
	public UserList(List<User> userList) {
		this.userList = userList;
	}

	// GETTER SETTERS
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	// DEVUELVE USUARIO
	public User findUserByName (String  name) {
		User userFind = null;
		for (User user : this.userList ) {
			if (user.getName().equals(name)) {
				userFind = user;
			}
		}
		return userFind;
	}
	
	public void addUser (String name) {
		User inputName = new User(name);
		this.userList.add(inputName);
		
	}
	
	public void deleteUser (String name) {
		for (User u : userList) {
			if (u.getName() == name) {
				userList.remove(u);
			}
		}
	}

}
