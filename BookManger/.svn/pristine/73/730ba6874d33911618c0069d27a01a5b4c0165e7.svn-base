package com.nwnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nwnu.model.Book;
import com.nwnu.model.BookType;
import com.nwnu.model.StringUtil;

/**
 * 图书Dao类
 * 
 * @author Administrator
 *
 */
public class BookDao {
	public int add(Connection con, Book book) throws Exception {
		String sql = "insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setString(5, book.getBookDesc());
		pstmt.setInt(6, book.getBookTypeId());
		return pstmt.executeUpdate();
	}

	/**
	 * 图书信息查询
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Book book)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_book b,t_bookType bt where b.bookTypeId=bt.id");
		if(StringUtil.isNotEmpty(book.getBookName())){
			sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())){
			sb.append(" and b.author like '%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeId()!=null && book.getBookTypeId()!=-1){
			sb.append(" and b.bookTypeId="+book.getBookTypeId());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 删除图书类别
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql = "delete from t_book where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	/**
	 * 更新图书类别
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Book book)throws Exception{
		String sql = "update t_book set bookName=?,author=?,sex=?,price=?,bookDesc=?,bookTypeId=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setString(5, book.getBookDesc());
		pstmt.setInt(6, book.getBookTypeId());
		pstmt.setInt(7, book.getId());
		return pstmt.executeUpdate();
	}
}