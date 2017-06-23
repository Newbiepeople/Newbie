package nwnu.info.hsc.servlet;

import it.unisa.dia.gas.jpbc.Element;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nwnu.info.hsc.algorithm.LZT_1;
import nwnu.info.hsc.algorithm.LZT_2;
import nwnu.info.hsc.algorithm.Sys_IDPKC_Params_Gen;
import nwnu.info.hsc.algorithm.Sys_TPKC_Params_Gen;
import nwnu.info.hsc.dao.UserDao;
import nwnu.info.hsc.entity.User;

public class ChatServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private User from; // 发送者
	private User to; // 接收者
	private String content; // 发言内容
	private String sendTime; // 发言时间

	private BigInteger cipher;//签密后的密文
	
	private Map<Integer, Element> pkMap = new HashMap<Integer, Element>();//公钥
	private Map<Integer, Element> skMap = new HashMap<Integer, Element>();//私钥
	
	private void chatRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html;charset=UTF-8");
		String type = req.getParameter("type");
		String action = req.getParameter("action");
		if ("admin".equals(action)) 
			req.getRequestDispatcher("WEB-INF/views/admin/admin.jsp").forward(req, resp);
		else if("frame".equals(action))
			req.getRequestDispatcher("WEB-INF/views/main/frame.jsp").forward(req, resp);
		else if("wel".equals(action))
			req.getRequestDispatcher("WEB-INF/views/admin/welcome.jsp").forward(req, resp);
		else if("leave".equals(action))
			req.getRequestDispatcher("WEB-INF/views/main/leave.jsp").forward(req, resp);
		else if("main".equals(action)){
			req.setAttribute("type", type);
			req.getRequestDispatcher("WEB-INF/views/main/main.jsp").forward(req, resp);
		}
		else if("online".equals(action))
			req.getRequestDispatcher("WEB-INF/views/main/online.jsp").forward(req, resp);		
		else if ("getMessages".equals(action))
			req.getRequestDispatcher("WEB-INF/views/main/content.jsp").forward(req,resp);		
		else if("login".equals(action))
			loginRoom(req,resp);
		else if ("sendMessage".equals(action))
			sendMessage(req,resp);
		else if ("decMessages".equals(action))
			decMessages(req,resp);
	}
	/**
	 * 登录
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	private void loginRoom(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//获取公私钥
		User user = (User)req.getSession().getAttribute("user");
		if (user.getCryptosystem().getCryptoId()==1) {  //基于PKI公钥密码体制
			pkMap.put(user.getUserId(), Sys_TPKC_Params_Gen.gen_PK());
			skMap.put(user.getUserId(), Sys_TPKC_Params_Gen.gen_SK());
		}else if(user.getCryptosystem().getCryptoId()==2){  //基于身份公钥密码体制
			pkMap.put(user.getUserId(), Sys_IDPKC_Params_Gen.gen_Qu(user.getUsername()));
			skMap.put(user.getUserId(), Sys_IDPKC_Params_Gen.gen_Su(user.getUsername()));
		}		
		req.getSession().setAttribute("pk", pkMap.get(user.getUserId()));
		req.getSession().setAttribute("sk", skMap.get(user.getUserId()));
		//显示登入信息
		ServletContext application = getServletContext();
		String sourceMessage = "";
		//判断是否有信息
		if (null != application.getAttribute("message")) 
			sourceMessage = application.getAttribute("message").toString();		
		sourceMessage += "系统公告：<font color='gray'>" + user.getUsername() + "走进了聊天室！</font><br>";
		application.setAttribute("message", sourceMessage);
		
		req.getRequestDispatcher("ChatServlet?action=frame").forward(req, resp);
	}
	
	/**
	 * 发送消息
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	private void sendMessage(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		Random random = new Random();
		String str = req.getParameter("from");
		System.out.println(str);
		from = UserDao.findByUserName(req.getParameter("from")); // 发言人
		to = UserDao.findByUserName(req.getParameter("to")); // 接收者
		content = req.getParameter("content"); // 发言内容
		sendTime = new Date().toLocaleString(); // 发言时间

		ServletContext application = getServletContext();

		String sourceMessage = application.getAttribute("message").toString();
		//PKI------>IBC
		if (from.getCryptosystem().getCryptoId() == 1 && to.getCryptosystem().getCryptoId()==2) 
			cipher = LZT_1.signcrypt(pkMap.get(from.getUserId()), to.getUsername(), content);
		//IBC------>PKI
		if (from.getCryptosystem().getCryptoId() == 2 && to.getCryptosystem().getCryptoId()==1) 
			cipher = LZT_2.signcrypt(skMap.get(from.getUserId()), pkMap.get(to.getUserId()), from.getUsername(), content);
		sourceMessage += "<font color='blue'><strong>" + from.getUsername()
				+ "</strong></font>对<font color='green'>[" + to.getUsername() + "]</font>说："
				+ cipher + "（"
				+ sendTime + "）<a href='ChatServlet?action=decMessages&type=2'>点击查看</a><br/>";
		application.setAttribute("message", sourceMessage);
		req.getRequestDispatcher("ChatServlet?action=getMessages&nocache=" + random.nextInt(10000)).forward(req, resp);
	}
	/**
	 * 解签密
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	private void decMessages(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		resp.setContentType("text/html;charset=UTF-8");
		String type = req.getParameter("type");		
		String target = "";
		//PKI------>IBC
		if (from.getCryptosystem().getCryptoId() == 1 && to.getCryptosystem().getCryptoId()==2) 
			target = LZT_1.unsigncrypt(pkMap.get(from.getUserId()), skMap.get(to.getUserId()), cipher);
		//IBC------>PKI
		if (from.getCryptosystem().getCryptoId() == 2 && to.getCryptosystem().getCryptoId()==1) 
			target = LZT_2.unsigncrypt(skMap.get(from.getUserId()), from.getUsername(), cipher);
		System.out.println("消息"+target);
		req.setAttribute("target", target);
		req.setAttribute("type", type);
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("ChatServlet?action=main").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			chatRequest(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			chatRequest(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
