package nwnu.info.hsc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import nwnu.info.hsc.entity.Cryptosystem;
import nwnu.info.hsc.utils.DBUtil;

public class CryptosystemDao {
	/**
	 * 新增密码体制
	 * @param cryptosystem
	 */
	public void addCryptosystem(Cryptosystem cryptosystem) {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into tb_crypto (cryptoName,englishName,cryptoDesc,createDate) values (?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cryptosystem.getCryptoName());
			ps.setString(2, cryptosystem.getEnglishName());
			ps.setString(3, cryptosystem.getCryptoDesc());
			ps.setString(4, cryptosystem.getCreateDate());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
	}
	/**
	 * 删除密码体制
	 * @param id
	 */
	public void delete(int id) {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from tb_crypto where cryptoId = " + id;
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
	 * 列出所有密码体制
	 * @return
	 */
	@SuppressWarnings("all")
	public List<Cryptosystem> cryptosystemList() {
		Connection conn = DBUtil.getConnection();
		List<Cryptosystem> list = new ArrayList<Cryptosystem>();
		String sql = "select * from tb_crypto order by cryptoId asc";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cryptosystem cryptosystem = new Cryptosystem();
				cryptosystem.setCryptoId(rs.getInt("cryptoId"));
				cryptosystem.setCryptoName(rs.getString("cryptoName"));
				cryptosystem.setEnglishName(rs.getString("englishName"));
				cryptosystem.setCryptoDesc(rs.getString("cryptoDesc"));
				cryptosystem.setCreateDate(rs.getString("createDate"));				
				list.add(cryptosystem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
	/**
	 * 通过id查找密码体制
	 * @param cryptoId
	 * @return
	 */
	public static Cryptosystem find(int cryptoId) {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_crypto where cryptoId = " + cryptoId;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Cryptosystem cryptosystem = new Cryptosystem();
				cryptosystem.setCryptoId(cryptoId);
				cryptosystem.setCryptoName(rs.getString("cryptoName"));
				cryptosystem.setEnglishName(rs.getString("englishName"));
				cryptosystem.setCryptoDesc(rs.getString("cryptoDesc"));
				cryptosystem.setCreateDate(rs.getString("createDate"));
				return cryptosystem;
			}else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
		return null;
	}
	
	public void save(Cryptosystem cryptosystem) {
		Connection conn = DBUtil.getConnection();
		String sql = "update tb_crypto set cryptoName='"+cryptosystem.getCryptoName()
					+"', englishName='" +  cryptosystem.getEnglishName() 
					+ "', cryptoDesc='"+ cryptosystem.getCryptoDesc()
					+"',createDate='"+ cryptosystem.getCreateDate()
					+"' where cryptoId='"+ cryptosystem.getCryptoId() +"'";
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
	 * 计算总页数
	 * @return
	 */
	public static int getPage() {
		Connection conn = DBUtil.getConnection();
		int recordCount=0,t1=0,t2=0;
		String sql = "select count(*) from tb_crypto";
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
	/**
	 * 查询指定页的数据
	 * @param pageNo
	 * @return
	 */
	@SuppressWarnings("all")
	public List<Cryptosystem> cryptosystemList(int pageNo) {
		Connection conn = DBUtil.getConnection();
		List<Cryptosystem> list = new ArrayList<Cryptosystem>();
		int pageSize = 5;
		int page = (pageNo-1)*5;
		String sql = "select * from tb_crypto order by cryptoId limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, page);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cryptosystem cryptosystem = new Cryptosystem();
				cryptosystem.setCryptoId(rs.getInt("cryptoId"));
				cryptosystem.setCryptoName(rs.getString("cryptoName"));
				cryptosystem.setEnglishName(rs.getString("englishName"));
				cryptosystem.setCryptoDesc(rs.getString("cryptoDesc"));
				cryptosystem.setCreateDate(rs.getString("createDate"));				
				list.add(cryptosystem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
}
