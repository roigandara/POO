package es.imatia.redsocial;

import java.util.HashSet;

public class SocialNetwork {
    //Métodos
    protected static HashSet<String> UserList = new HashSet<>();
    
    
    //Getters & Setters
    public static HashSet<String> getUserList() {
        return UserList;
    }
    public void setUserList(HashSet<String> userList) {
        UserList = userList;
    }
}
