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
		req.getSession().setMaxInactiveInterval(600);// 设置Session的过期时间为10分钟
		String username = req.getParameter("username");
		String password = req.getParameter("password");		
		
		UserDao userDao = new UserDao();
		if (username != null && !username.isEmpty()) {
			User user = new User();
			user = userDao.loginUser(username, MD5.getMD5ofStr(password));			
			if (user != null) {
				if("0".equals(user.getState())){	//管理员
					System.out.println("恭喜您，登录成功！");
					req.getSession().setAttribute("user", user);
					req.getRequestDispatcher("ChatServlet?action=admin").forward(req, resp);
				}else if("0".equals(user.getStatus())){ //普通用户
					UserUtil userUtil = UserUtil.getInstance();
					Vector<User> vector = userUtil.getList();
					boolean flag = true; // 标记是否登录的变量
					if (vector != null && vector.size()>0) {
						System.out.println("vector的size：" + vector.size());
						for (int i = 0; i < vector.size(); i++) {
							System.out.println("vector" + i + ":" + vector.elementAt(i).getUsername()+ " user:" + username);
							if(user.getUsername().equals(vector.elementAt(i).getUsername())){
								req.setAttribute("error", "该用户已经登录");
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
						req.getSession().setAttribute("loginTime", new Date().toLocaleString()); // 保存登录时间						
						req.getRequestDispatcher("ChatServlet?action=login").forward(req, resp);
					}		
				}else {
					req.setAttribute("error", "账户未启用！");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}				
			}else {
				req.setAttribute("error", "用户名不存在或密码错误！");
				System.out.println("用户名不存在或密码错误！");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}		
		}
	}
}
