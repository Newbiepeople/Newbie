package nwnu.info.hsc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import nwnu.info.hsc.entity.User;
import nwnu.info.hsc.utils.DBUtil;
import nwnu.info.hsc.utils.MD5;

public class UserDao {
	/**
	 * 用户新增
	 * @param user
	 */
	public void insertUser(User user) {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into tb_user(username,password,sex,age,birthDate,telphone,occupation,homeAddress,createDate,cryptoId,state,status)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSex());
			ps.setInt(4, user.getAge());
			ps.setString(5, user.getBirthDate());
			ps.setString(6, user.getTelphone());
			ps.setString(7, user.getOccupation());
			ps.setString(8, user.getHomeAddress());
			ps.setString(9, user.getCreateDate());
			ps.setInt(10, user.getCryptosystem().getCryptoId());
			ps.setString(11, user.getState());
			ps.setString(12, user.getStatus());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
	}
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户对象
	 */
	public User loginUser(String username, String password) {
		User user = null;
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_user where username = ? and password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();// 执行查询获取结果集			
			if (rs.next()) {// 判断结果集是否有效
				user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setBirthDate(rs.getString("birthDate"));
				user.setTelphone(rs.getString("telphone"));
				user.setOccupation(rs.getString("occupation"));
				user.setHomeAddress(rs.getString("homeAddress"));
				user.setCreateDate(rs.getString("createDate"));
				user.setCryptosystem(CryptosystemDao.find(Integer.parseInt(rs.getString("cryptoId"))));
				user.setState(rs.getString("state"));
				user.setStatus(rs.getString("status"));
				rs.close();
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
		return user;
	}
	
	
	/**
	 * 判断用户是够存在
	 * @param username 用户名
	 * @return 布尔值
	 */
	public boolean userIsExist(String username) {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_user where username = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return true;// 如果无效则证明此用户名可用
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
		return false;
	}
	/**
	 * 查询指定页的数据
	 * @param pageNo
	 * @return
	 */
	public static List<User> userList(int pageNo) {
		Connection conn = DBUtil.getConnection();
		List<User> list = new ArrayList<User>();
		int pageSize = 5;
		int page = (pageNo-1)*5;
		String sql = "select * from tb_user order by userId limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, page);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setBirthDate(rs.getString("birthDate"));
				user.setOccupation(rs.getString("occupation"));
				user.setHomeAddress(rs.getString("homeAddress"));
				user.setCreateDate(rs.getString("createDate"));
				user.setCryptosystem(CryptosystemDao.find(Integer.parseInt(rs.getString("cryptoId"))));
				user.setTelphone(rs.getString("telphone"));
				user.setStatus(rs.getString("status"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
	/**
	 * 删除用户信息
	 * @param id
	 * @return
	 */
	public static void delete(int id) {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from tb_user where userId = " + id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
	}
	/**
	 * 通过id查找用户
	 * @param userId
	 * @return
	 */
	public static User findByUserId(int userId) {
		User user = null;
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_user where userId = " + userId;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();// 执行查询获取结果集
			if (rs.next()) {// 判断结果集是否有效
				user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setBirthDate(rs.getString("birthDate"));
				user.setTelphone(rs.getString("telphone"));
				user.setOccupation(rs.getString("occupation"));
				user.setHomeAddress(rs.getString("homeAddress"));
				user.setCreateDate(rs.getString("createDate"));
				user.setCryptosystem(CryptosystemDao.find(Integer.parseInt(rs.getString("cryptoId"))));
				user.setState(rs.getString("state"));
				user.setStatus(rs.getString("status"));
				rs.close();
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
		return user;
	}
	/**
	 * 通过id查找用户
	 * @param userId
	 * @return
	 */
	public static User findByUserName(String username) {
		User user = null;
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_user where username = '" + username + "'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();// 执行查询获取结果集
			if (rs.next()) {// 判断结果集是否有效
				user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setBirthDate(rs.getString("birthDate"));
				user.setTelphone(rs.getString("telphone"));
				user.setOccupation(rs.getString("occupation"));
				user.setHomeAddress(rs.getString("homeAddress"));
				user.setCreateDate(rs.getString("createDate"));
				user.setCryptosystem(CryptosystemDao.find(Integer.parseInt(rs.getString("cryptoId"))));
				user.setState(rs.getString("state"));
				user.setStatus(rs.getString("status"));
				rs.close();
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
		return user;
	}
	/**
	 * 保存用户信息
	 * @param user
	 */
	public static void save(User user) {		
		Connection conn = DBUtil.getConnection();
		String sql = "update tb_user set username='"+user.getUsername()
					+"', age='" +  user.getAge() 
					+ "', birthDate='"+ user.getBirthDate()
					+"',telphone='"+ user.getTelphone()
					+"',occupation='"+ user.getOccupation()
					+"',homeAddress='"+ user.getHomeAddress()
					+"',cryptoId='"+ user.getCryptosystem().getCryptoId()
					+"' where userId='"+ user.getUserId() +"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);			
			ps.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	/**
	 * 保存新密码
	 * @param newPassword
	 */
	public static void updatePwd(User user,String newPassword) {
		Connection conn = DBUtil.getConnection();
		String sql = "update tb_user set password='"+MD5.getMD5ofStr(newPassword)
		+"' where userId='"+ user.getUserId() +"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);			
			ps.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	/**
	 * 更改用户状态
	 * @param id
	 * @param status
	 */
	public static void updateStatus(int id, String status){
		Connection conn = DBUtil.getConnection();
		String sql = "update tb_user set status='" + status +"' where userId = '" + id +"'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
	}
	/**
	 * 计算总页数
	 * @return
	 */
	public static int getPage() {
		Connection conn = DBUtil.getConnection();
		int recordCount=0,t1=0,t2=0;
		String sql = "select count(*) from tb_user";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			recordCount = rs.getInt(1);
			t1 = recordCount%5;
			t2 = recordCount/5;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
		if (t1!=0) 
			t2=t2+1;
		return t2;
	}
	
}
