package nwnu.info.hsc.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import nwnu.info.hsc.entity.User;
import nwnu.info.hsc.utils.UserUtil;

public class UserListener implements HttpSessionBindingListener {
	private User user;
	private UserUtil container = UserUtil.getInstance();//���User��Ķ���
	
	public UserListener() {
		user = null;
	}
	// �������߼�����Ա
	public void setUser(User user) {
		this.user = user;
	}
	// ��ȡ���߼���
	public User getUser() {
		return this.user;
	}
	// ��Session�ж������ʱִ�еķ���
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("�����û���" + this.user.getUsername());
	}
	// ��Session�ж����Ƴ�ʱִ�еķ���
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("�����û���" + this.user.getUsername());
		if (user != null) {
			container.removeUser(user);
		}
	}

}
