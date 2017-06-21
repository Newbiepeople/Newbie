package nwnu.info.hsc.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import nwnu.info.hsc.entity.User;
import nwnu.info.hsc.utils.UserUtil;

public class UserListener implements HttpSessionBindingListener {
	private User user;
	private UserUtil container = UserUtil.getInstance();//获得User类的对象
	
	public UserListener() {
		user = null;
	}
	// 设置在线监听人员
	public void setUser(User user) {
		this.user = user;
	}
	// 获取在线监听
	public User getUser() {
		return this.user;
	}
	// 当Session有对象加入时执行的方法
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("上线用户：" + this.user.getUsername());
	}
	// 当Session有对象移除时执行的方法
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("下线用户：" + this.user.getUsername());
		if (user != null) {
			container.removeUser(user);
		}
	}

}
