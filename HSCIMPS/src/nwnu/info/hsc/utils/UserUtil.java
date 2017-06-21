package nwnu.info.hsc.utils;

import java.util.Vector;

import nwnu.info.hsc.entity.User;


public class UserUtil {
	private static UserUtil user = new UserUtil();
	private Vector<User> vector = null;
	
	private UserUtil(){
		this.vector = new Vector<User>();
	}
	
	public static UserUtil getInstance(){
		return user;
	}
	
	// 增加用户
	public boolean addUser(User user) {
		if (user != null) {
			this.vector.add(user);
			return true;
		} else {
			return false;
		}
	}
	// 获取用户列表
	public Vector<User> getList() {
		return vector;
	}
	// 移除用户
	public void removeUser(User user) {
		if (user != null) {
			vector.removeElement(user);
		}
	}	
}
