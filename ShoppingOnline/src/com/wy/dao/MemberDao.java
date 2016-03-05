package com.wy.dao;

import com.wy.tool.JDBConnection;
import java.sql.*;
import java.util.*;
import com.wy.domain.MemberForm;

//�Ի�Ա��Ĳ���
public class MemberDao {
	private Connection connection = null; // �������ӵĶ���
	private PreparedStatement ps = null; // ����Ԥ׼���Ķ���
	private JDBConnection jdbc = null; // �������ݿ����Ӷ���

	public MemberDao() {
		jdbc = new JDBConnection();
		connection = jdbc.connection; // ���ù��췽��ȡ�����ݿ�����
	}

	// �����ݿ���ˮ��Ϊ�����޸Ļ�Ա������
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

	// �һ�����֮��
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

	// ȫ����ѯ�Ĳ������Ի�Ա����Ϊ������ѯ��Ϣ
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

	// ɾ������
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

	// �����Ϣ
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

	// �����ݿ���ˮ��Ϊ�����޸���Ϣ
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

	// ȫ����ѯ��Ϣ����
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

	// �����ݿ���ˮ��Ϊ������ѯ��Ϣ
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
