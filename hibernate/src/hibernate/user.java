package hibernate;

import java.util.HashSet;
import java.util.Set;

public class user {
private int uid;
private String username;
private String password;
private Set<role> setrole=new HashSet<role>();
public String toString() {
	return "user [uid=" + uid + ", username=" + username + ", password=" + password + "]";
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Set<role> getSetrole() {
	return setrole;
}
public void setSetrole(Set<role> setrole) {
	this.setrole = setrole;
}
}
