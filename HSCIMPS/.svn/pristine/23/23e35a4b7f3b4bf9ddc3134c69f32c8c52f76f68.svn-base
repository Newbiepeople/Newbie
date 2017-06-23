package nwnu.info.hsc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nwnu.info.hsc.dao.CryptosystemDao;
import nwnu.info.hsc.entity.Cryptosystem;
import nwnu.info.hsc.utils.TimeHelper;

public class CryptoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		try {
			cryptoRequest(req, resp);
		} catch (Exception e) {
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		try {
			cryptoRequest(req, resp);
		} catch (Exception e) {
			
		}
	}
	
	public void cryptoRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if("list".equals(action))
			cryptoList(req,resp);
		else if ("edit".equals(action)) 
			cryptoEdit(req,resp);
		else if ("save".equals(action))
			cryptoSave(req,resp);
		else if ("del".equals(action))
			cryptoDel(req,resp);
	}
	
	/**
	 * 密码体制列表
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	private void cryptoList(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("UTF-8");
		int pageNo = 1;
		String pageno=req.getParameter("pageNos");
		if(pageno != null)
			pageNo=Integer.parseInt(pageno);
		CryptosystemDao cryptosystemDao = new CryptosystemDao();
		List cryptosystemList = cryptosystemDao.cryptosystemList(pageNo);
		int recordCount = cryptosystemDao.getPage();
		req.setAttribute("recordCount", recordCount);
		req.setAttribute("cryptosystemList", cryptosystemList);
		req.setAttribute("pageNos", pageNo);
		req.getRequestDispatcher("WEB-INF/views/crypto/cryptoSystem_list.jsp").forward(req, resp);
	}
	/**
	 * 密码体制增加或编辑
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	private void cryptoEdit(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("UTF-8");
		int cryptoId = Integer.parseInt(req.getParameter("cryptoId"));
		if(cryptoId > 0){
			Cryptosystem cryptosystem = CryptosystemDao.find(new Integer(cryptoId));
			req.setAttribute("cryptosystem", cryptosystem);
		}
		req.getRequestDispatcher("WEB-INF/views/crypto/cryptoSystem_add.jsp").forward(req, resp);
	}
	/**
	 * 密码体制保存
	 * @param req
	 * @param resp
	 * @throws Exception
	 */	
	public void cryptoSave(HttpServletRequest req, HttpServletResponse resp)throws Exception {
		resp.setContentType("text/heml;charset=utf-8");  
		req.setCharacterEncoding("utf-8"); 
		String cryptoId = req.getParameter("cryptoId");
		String cryptoName = req.getParameter("cryptoName");
		String englishName = req.getParameter("englishName");
		String cryptoDesc = req.getParameter("cryptoDesc");
		
		CryptosystemDao cryptosystemDao = new CryptosystemDao();
		if (cryptoName != null && !cryptoName.isEmpty()) {
			Cryptosystem cryptosystem = new Cryptosystem();			
			cryptosystem.setCryptoName(cryptoName);
			cryptosystem.setEnglishName(englishName);
			cryptosystem.setCryptoDesc(cryptoDesc);
			cryptosystem.setCreateDate(TimeHelper.getCurrentTime());
			if(cryptoId !=""){
				cryptosystem.setCryptoId(new Integer(cryptoId));
				cryptosystemDao.save(cryptosystem);
			}
			else
				cryptosystemDao.addCryptosystem(cryptosystem);
			req.setAttribute("success", "添加成功！");
		}else {
			req.setAttribute("error", "添加失败！");			
		}
		req.getRequestDispatcher("CryptoServlet?action=list").forward(req, resp);		
	}
	
	
	/**
	 * 删除密码体制
	 * @param req
	 * @param resp
	 */
	private void cryptoDel(HttpServletRequest req, HttpServletResponse resp){
		try {
			CryptosystemDao cryptosystemDao = new CryptosystemDao();
			cryptosystemDao.delete(Integer.parseInt(req.getParameter("cryptoId")));
			req.getRequestDispatcher("CryptoServlet?action=list").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
