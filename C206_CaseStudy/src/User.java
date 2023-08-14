public class User {
	public String name;
	public int userid;
	public String roles;


public User(String name, int userid, String roles) {
	this.name=name;
	this.userid=userid;
	this.roles=roles;
}

public String getName() {
	return name;
}
public int getUserid() {
	return userid;
}
public String getRoles() {
	return roles;
}
}

