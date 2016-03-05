package com.wy.dao;

import com.wy.tool.JDBConnection;
import java.sql.*;
import java.util.*;
import com.wy.domain.MemberForm;

//对会员表的操作
public class MemberDao {
	private Connection connection = null; // 定义连接的对象
	private PreparedStatement ps = null; // 定义预准备的对象
	private JDBConnection jdbc = null; // 定义数据库连接对象

	public MemberDao() {
		jdbc = new JDBConnection();
		connection = jdbc.connection; // 利用构造方法取得数据库连接
	}

	// 以数据库流水号为条件修改会员的密码
	public boolean updatePassword(String password, Integer id) throws SQLException {
		try {
			ps = connection
					.prepareStatement("update tb_member set password=? where id=?");
			ps.setString(1, password);
			ps.setInt(2, id.intValue());
			ps.executeUpdate();
			
			return true;
		} catch (SQLException ex) {
			return false;
		}
		finally 
		{
			ps.close();
			
		}
	}

	// 找回密码之用
	public MemberForm selectFind(String name, String result)
			throws SQLException {
		MemberForm member = null;
		try {
			ps = connection
					.prepareStatement("select * from tb_member where name=? and result=?");
			ps.setString(1, name);
			ps.setString(2, result);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				member = new MemberForm();
				member.setId(Integer.valueOf(rs.getString(1)));
				member.setName(rs.getString(2));
				member.setPassword(rs.getString(3));
				member.setReallyName(rs.getString(4));
				member.setAge(Integer.valueOf(rs.getString(5)));
				member.setProfession(rs.getString(6));
				member.setEmail(rs.getString(7));
				member.setQuestion(rs.getString(8));
				member.setResult(rs.getString(9));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ps.close();
		}
		return member;
	}

	// 全部查询的操作或以会员名称为条件查询信息
	public MemberForm selectMemberForm(String name) throws SQLException {
		MemberForm member = null;
		try {
			ps = connection
					.prepareStatement("select * from tb_member where name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				member = new MemberForm();
				member.setId(Integer.valueOf(rs.getString(1)));
				member.setName(rs.getString(2));
				member.setPassword(rs.getString(3));
				member.setReallyName(rs.getString(4));
				member.setAge(Integer.valueOf(rs.getString(5)));
				member.setProfession(rs.getString(6));
				member.setEmail(rs.getString(7));
				member.setQuestion(rs.getString(8));
				member.setResult(rs.getString(9));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally 
		{
			ps.close();
		}
		return member;
	}

	// 删除操作
	public boolean deleteMember(Integer id) throws SQLException {
		try {
			ps = connection
					.prepareStatement("delete from tb_member where id=?");
			ps.setString(1, id.toString());
			ps.executeUpdate();
			
			return true;
		} catch (SQLException ex) {
			return false;
		}
		finally 
		{
			
			ps.close();
		}
	}

	// 添加信息
	public void insertMember(MemberForm form) throws SQLException {
		try {
			ps = connection
					.prepareStatement("insert into tb_member(name,password,reallyname,age,profession,email,question,result) values (?,?,?,?,?,?,?,?)");
			ps.setString(1, form.getName());
			ps.setString(2, form.getPassword());
			ps.setString(3, form.getReallyName());
			ps.setString(4, form.getAge().toString());
			ps.setString(5, form.getProfession());
			ps.setString(6, form.getEmail());
			ps.setString(7, form.getQuestion());
			ps.setString(8, form.getResult());
			//System.out.println(ps.toString());

			ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally
		{
			ps.close();
		}
	}

	// 以数据库流水号为条件修改信息
	public void updateMember(MemberForm form) throws SQLException {
		try {
			ps = connection
					.prepareStatement("update tb_member set name=?,password=?,reallyName=?,age=?,profession=?,email=?,question=?,result=? where id=?");
			ps.setString(1, form.getName());
			ps.setString(2, form.getPassword());
			ps.setString(3, form.getReallyName());
			ps.setString(4, form.getAge().toString());
			ps.setString(5, form.getProfession());
			ps.setString(6, form.getEmail());
			ps.setString(7, form.getQuestion());
			ps.setString(8, form.getResult());
			ps.setString(9, form.getId().toString());
			ps.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally
		{
			ps.close();
		}
	}

	// 全部查询信息操作
	public List selectMember() throws SQLException {
		List list = new ArrayList();
		MemberForm member = null;
		try {
			ps = connection
					.prepareStatement("select * from tb_member order by id DESC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				member = new MemberForm();
				member.setId(Integer.valueOf(rs.getString(1)));
				member.setName(rs.getString(2));
				member.setPassword(rs.getString(3));
				member.setReallyName(rs.getString(4));
				member.setAge(Integer.valueOf(rs.getString(5)));
				member.setProfession(rs.getString(6));
				member.setEmail(rs.getString(7));
				member.setQuestion(rs.getString(8));
				member.setResult(rs.getString(9));
				list.add(member);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally
		{
			ps.close();
		}
		return list;
	}

	// 以数据库流水号为条件查询信息
	public MemberForm selectOneMember(Integer id) throws SQLException {
		MemberForm member = null;
		try {
			ps = connection
					.prepareStatement("select * from tb_member where id=?");
			ps.setInt(1, id.intValue());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				member = new MemberForm();
				member.setId(Integer.valueOf(rs.getString(1)));
				member.setName(rs.getString(2));
				member.setPassword(rs.getString(3));
				member.setReallyName(rs.getString(4));
				member.setAge(Integer.valueOf(rs.getString(5)));
				member.setProfession(rs.getString(6));
				member.setEmail(rs.getString(7));
				member.setQuestion(rs.getString(8));
				member.setResult(rs.getString(9));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally
		{
			ps.close();
		}
		return member;
	}

}
