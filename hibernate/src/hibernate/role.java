package hibernate;

import java.util.HashSet;
import java.util.Set;

public class role {
private Integer id;
private String name;
private String memo;
private Set<user> setuser=new HashSet<user>();

@Override
public String toString() {
	return "role [id=" + id + ", name=" + name + ", memo=" + memo + ", setuser=" + setuser + "]";
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMemo() {
	return memo;
}
public void setMemo(String memo) {
	this.memo = memo;
}
public Set<user> getSetuser() {
	return setuser;
}
public void setSetuser(Set<user> setuser) {
	this.setuser = setuser;
}
}
