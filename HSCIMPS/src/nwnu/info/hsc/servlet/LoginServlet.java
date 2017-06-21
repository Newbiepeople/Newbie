package nwnu.info.hsc.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nwnu.info.hsc.dao.UserDao;
import nwnu.info.hsc.entity.User;
import nwnu.info.hsc.listener.UserListener;
import nwnu.info.hsc.utils.MD5;
import nwnu.info.hsc.utils.UserUtil;
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
//	@SuppressWarnings("all")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/heml;charset=utf-8");  
		req.setCharacterEncoding("utf-8"); 
		req.getSession().setMaxInactiveInterval(600);// ����Session�Ĺ���ʱ��Ϊ10����
		String username = req.getParameter("username");
		String password = req.getParameter("password");		
		
		UserDao userDao = new UserDao();
		if (username != null && !username.isEmpty()) {
			User user = new User();
			user = userDao.loginUser(username, MD5.getMD5ofStr(password));			
			if (user != null) {
				if("0".equals(user.getState())){	//����Ա
					System.out.println("��ϲ������¼�ɹ���");
					req.getSession().setAttribute("user", user);
					req.getRequestDispatcher("ChatServlet?action=admin").forward(req, resp);
				}else if("0".equals(user.getStatus())){ //��ͨ�û�
					UserUtil userUtil = UserUtil.getInstance();
					Vector<User> vector = userUtil.getList();
					boolean flag = true; // ����Ƿ��¼�ı���
					if (vector != null && vector.size()>0) {
						System.out.println("vector��size��" + vector.size());
						for (int i = 0; i < vector.size(); i++) {
							System.out.println("vector" + i + ":" + vector.elementAt(i).getUsername()+ " user:" + username);
							if(user.getUsername().equals(vector.elementAt(i).getUsername())){
								req.setAttribute("error", "���û��Ѿ���¼");
								req.getRequestDispatcher("login.jsp").forward(req, resp);
								flag = false;
								break;
							}
						}
					}
					if (flag){
						req.getSession().setAttribute("user", user);
						UserListener ul = new UserListener();
						ul.setUser(user);
						req.getSession().setAttribute("ul", ul);
						userUtil.addUser(user);	
						req.getSession().setAttribute("loginTime", new Date().toLocaleString()); // �����¼ʱ��						
						req.getRequestDispatcher("ChatServlet?action=login").forward(req, resp);
					}		
				}else {
					req.setAttribute("error", "�˻�δ���ã�");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}				
			}else {
				req.setAttribute("error", "�û��������ڻ��������");
				System.out.println("�û��������ڻ��������");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}		
		}
	}
}
