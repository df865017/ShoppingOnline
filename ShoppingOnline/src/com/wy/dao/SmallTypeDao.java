package com.wy.dao;

import com.wy.tool.CountTime;
import com.wy.tool.JDBConnection;
import java.sql.*;
import java.util.*;
import com.wy.domain.SmallTypeForm;

//����ƷС�����Ϣ�Ĳ���
public class SmallTypeDao {
	private Connection connection = null; // �������ӵĶ���

	private PreparedStatement ps = null; // ����Ԥ׼���Ķ���

	private JDBConnection jdbc = null; // �������ݿ����Ӷ���

	public SmallTypeDao() {
		jdbc = new JDBConnection();
		connection = jdbc.connection; // ���ù��췽��ȡ�����ݿ�����
	}

	// ��С�����ؼ�Ϊ������ѯ��Ϣ
	public List selectOneBigId(Integer bigId) throws SQLException {
		List list = new ArrayList();
		SmallTypeForm small = null;
		try {
			this.ps = connection
					.prepareStatement("select * from tb_smallType where bigId=?");
			ps.setString(1, bigId.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				small = new SmallTypeForm();
				small.setId(Integer.valueOf(rs.getString(1)));
				small.setBigId(Integer.valueOf(rs.getString(2)));
				small.setSmallName(rs.getString(3));
				small.setCreaTime(rs.getString(4));
				list.add(small);
			}
		} catch (SQLException ex) {
		} finally {
			ps.close();

		}

		return list;
	}

	// �����ݿ���ˮ��Ϊ������ѯС��������
	public String selectName(Integer id) throws SQLException {
		String name = null;
		try {
			this.ps = connection
					.prepareStatement("select * from tb_smallType where id=?");
			ps.setString(1, id.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString("smallName");
			}
		} catch (SQLException ex) {
		} finally {
			ps.close();

		}

		return name;
	}

	// ɾ������
	public boolean deleteSmall(Integer id) throws SQLException {
		try {
			ps = connection
					.prepareStatement("delete from tb_smallType where id=?");
			ps.setString(1, id.toString());
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			return false;
		} finally {
			ps.close();

		}

	}

	// �޸Ĳ���
	public void updateSmall(SmallTypeForm form) throws SQLException {
		try {
			ps = connection
					.prepareStatement("update tb_smallType set bigId=?,smallName=? where id=?");
			ps.setString(1, form.getBigId().toString());
			ps.setString(2, form.getSmallName());
			ps.setString(3, form.getId().toString());
			ps.executeUpdate();
		} catch (SQLException ex) {
		} finally {
			ps.close();

		}

	}

	// ��Ӳ���
	public void insertSmall(SmallTypeForm form) throws SQLException {
		try {
			ps = connection.prepareStatement("insert into tb_smallType(bigId,smallName,creaTime) values (?,?,now())");
			ps.setString(1, form.getBigId().toString());
			ps.setString(2, form.getSmallName());
			ps.executeUpdate();
		} catch (SQLException ex) {
		}
		finally 
		{
			ps.close();  
			
		}

	}

	// �����ݿ���ˮ��Ϊ������ѯ��Ϣ
	public SmallTypeForm selectOneBig(Integer id) throws SQLException {
		SmallTypeForm small = null;
		try {
			this.ps = connection
					.prepareStatement("select * from tb_smallType where id=?");
			ps.setString(1, id.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				small = new SmallTypeForm();
				small.setId(Integer.valueOf(rs.getString(1)));
				small.setBigId(Integer.valueOf(rs.getString(2)));
				small.setSmallName(rs.getString(3));
				small.setCreaTime(rs.getString(4));
			}
		} catch (SQLException ex) {
		} finally {
			ps.close();

		}

		return small;
	}

	// ȫ����ѯ�Ĳ���
	public List selectSmall() throws SQLException {
		List list = new ArrayList();
		SmallTypeForm small = null;
		try {
			this.ps = connection
					.prepareStatement("select * from tb_smallType order by id DESC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				small = new SmallTypeForm();
				small.setId(Integer.valueOf(rs.getString(1)));
				small.setBigId(Integer.valueOf(rs.getString(2)));
				small.setSmallName(rs.getString(3));
				small.setCreaTime(rs.getString(4));
				list.add(small);
			}
		} catch (SQLException ex) {
		} finally {
			ps.close();

		}

		return list;
	}
}
