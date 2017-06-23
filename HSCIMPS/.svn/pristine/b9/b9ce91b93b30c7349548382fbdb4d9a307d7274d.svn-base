package nwnu.info.hsc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nwnu.info.hsc.dao.CryptosystemDao;
import nwnu.info.hsc.dao.UserDao;
import nwnu.info.hsc.entity.Cryptosystem;
import nwnu.info.hsc.entity.User;
import nwnu.info.hsc.utils.MD5;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			userRequest(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			userRequest(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void userRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("list".equals(action))
			userList(req, resp);
		else if ("edit".equals(action)) 
			userEdit(req,resp);
		else if ("save".equals(action)) 
			userSave(req,resp);
		else if ("view".equals(action)) 
			userView(req,resp);
		else if ("start".equals(action)) 
			userStart(req,resp);
		else if ("stop".equals(action)) 
			userStop(req,resp);
		else if ("del".equals(action)) 
			userDel(req,resp);
		else if ("pwdChange".equals(action)) 
			pwdChange(req,resp);
		else if ("pwdSave".equals(action)) 
			pwdSave(req,resp);
	}
	/**
	 * 用户列表
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	public static void userList(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("UTF-8");
		int pageNo = 1;
		String pageno=req.getParameter("pageNos");
		if(pageno != null)
			pageNo=Integer.parseInt(pageno);		
		List userList = UserDao.userList(pageNo);
		int recordCount = UserDao.getPage();
		req.setAttribute("recordCount", recordCount);
		req.setAttribute("userList", userList);	
		req.setAttribute("pageNos", pageNo);
		req.getRequestDispatcher("WEB-INF/views/user/user_list.jsp").forward(req, resp);
	}
	
	/**
	 * 修改用户信息
	 * @param req
	 * @param resp
	 */
	@SuppressWarnings("all")
	public static void userEdit(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("UTF-8");		
		User user = null;
		User userSession = (User)req.getSession().getAttribute("user");	
		if (req.getParameter("userId")!="" && req.getParameter("userId")!=null) {
			int userId = new Integer(req.getParameter("userId"));
			user = UserDao.findByUserId(userId);			
		}else				
			user = UserDao.findByUserId(userSession.getUserId());
		CryptosystemDao cryptosystemDao = new CryptosystemDao();
		List cryptosystemList = cryptosystemDao.cryptosystemList();
		req.setAttribute("cryptosystemList", cryptosystemList);
		req.setAttribute("user", user);
		req.setAttribute("state", userSession.getState());
		req.getRequestDispatcher("WEB-INF/views/user/user_edit.jsp").forward(req, resp);
	}
	
	/**
	 * 保存用户信息
	 * @param req
	 * @param resp
	 */
	public static void userSave(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		
		String userId = req.getParameter("userId");
		String username = req.getParameter("username");
		String age = req.getParameter("age");
		String birthDate = req.getParameter("birthDate");
		String telphone = req.getParameter("telphone");
		String occupation = req.getParameter("occupation");
		String homeAddress = req.getParameter("homeAddress");
		Cryptosystem cryptosystem = CryptosystemDao.find(Integer.parseInt(req.getParameter("cryptoId")));
		
		if (userId !="") {
			User user = new User();
			user.setUserId(new Integer(userId));
			user.setUsername(username);
			user.setAge(new Integer(age));
			user.setBirthDate(birthDate);
			user.setTelphone(telphone);
			user.setOccupation(occupation);
			user.setHomeAddress(homeAddress);
			user.setCryptosystem(cryptosystem);
			UserDao.save(user);				
			req.setAttribute("success", "修改成功！");
		}else {
			req.setAttribute("error", "修改失败！");			
		}
		req.getRequestDispatcher("UserServlet?action=view").forward(req, resp);
	}
	
	/**
	 * 删除用户
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	public static void userDel(HttpServletRequest req, HttpServletResponse resp)throws Exception {
		UserDao.delete(Integer.parseInt(req.getParameter("userId")));		
		req.getRequestDispatcher("UserServlet?action=list").forward(req, resp);
	}
	/**
	 * 查看用户信息
	 * @param req
	 * @param resp
	 */
	public static void userView(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		User user = null;
		if (req.getParameter("userId")!="" && req.getParameter("userId")!=null) {
			int userId = new Integer(req.getParameter("userId"));
			user = UserDao.findByUserId(userId);
		}else {
			User userSession = (User)req.getSession().getAttribute("user");		
			user = UserDao.findByUserId(userSession.getUserId());
		}		
		req.setAttribute("user", user);
		req.getRequestDispatcher("WEB-INF/views/user/user_view.jsp").forward(req, resp);
	}
	/**
	 * 更改用户密码
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	public static void pwdChange(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		req.getRequestDispatcher("WEB-INF/views/user/pwd_change.jsp").forward(req, resp);
	}
	/**
	 * 保存用户密码
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	public static void pwdSave(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		User userSession = (User)req.getSession().getAttribute("user");		
		User user = UserDao.findByUserId(userSession.getUserId());
		String oldPassword = req.getParameter("oldPassword");
		String newPassword = req.getParameter("newPassword");
		if (MD5.getMD5ofStr(oldPassword).equals(user.getPassword())) {
			UserDao.updatePwd(user,newPassword);
			req.setAttribute("MsgInfo", "密码修改成功，请重新登录！");
			req.getRequestDispatcher("WEB-INF/views/user/success.jsp").forward(req, resp);
		}else {
			req.setAttribute("MsgInfo", "修改失败，原始密码错误，请重新输入！");
			req.getRequestDispatcher("WEB-INF/views/user/pwd_change.jsp").forward(req, resp);
		}
	}
	
	/**
	 * 停用用户
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	private void userStop(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int userId = new Integer(req.getParameter("userId"));
		UserDao.updateStatus(userId, "1");
		req.getRequestDispatcher("UserServlet?action=list").forward(req, resp);
	}
	/**
	 * 启用用户
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	private void userStart(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int userId = new Integer(req.getParameter("userId"));
		UserDao.updateStatus(userId, "0");
		req.getRequestDispatcher("UserServlet?action=list").forward(req, resp);
	}
	
}
