package nwnu.info.hsc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nwnu.info.hsc.dao.CryptosystemDao;
import nwnu.info.hsc.dao.UserDao;
import nwnu.info.hsc.entity.Cryptosystem;
import nwnu.info.hsc.entity.User;
import nwnu.info.hsc.utils.MD5;
import nwnu.info.hsc.utils.TimeHelper;

public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/heml;charset=utf-8");  
		req.setCharacterEncoding("utf-8"); 
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String sex = req.getParameter("sex");
		String age = req.getParameter("age");
		String birthDate = req.getParameter("birthDate");
		String telphone = req.getParameter("telphone");
		String occupation = req.getParameter("occupation");
		Cryptosystem cryptosystem = CryptosystemDao.find(Integer.parseInt(req.getParameter("cryptoId")));
		String homeAddress = req.getParameter("s_province")+req.getParameter("s_city")+req.getParameter("s_county")+req.getParameter("homeAddress");
		
		UserDao userDao = new UserDao();
		if (username != null && !username.isEmpty()) {
			if(userDao.userIsExist(username)){
				User user = new User();
				user.setUsername(username);
				user.setPassword(MD5.getMD5ofStr(password));
				user.setSex(sex);
				user.setAge(Integer.parseInt(age));
				user.setBirthDate(birthDate);
				user.setTelphone(telphone);
				user.setOccupation(occupation);
				user.setHomeAddress(homeAddress);				
				user.setCreateDate(TimeHelper.getCurrentTime());
				user.setCryptosystem(cryptosystem);
				if ("admin".equals(username)) {
					user.setState("0");
				}else {
					user.setState("1");
				}
				user.setStatus("1");
				userDao.insertUser(user);
				req.setAttribute("info", "恭喜您，注册成功！<br>");
				System.out.println("恭喜您，注册成功！");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}else {
				req.setAttribute("info", "此用户名已存在！");
				req.getRequestDispatcher("register.jsp").forward(req, resp);
			}
		}
		
	}

}
