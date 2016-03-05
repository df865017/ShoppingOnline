package com.wy.dao;

import java.sql.*;
import java.util.*;
import com.wy.domain.ManagerForm;
import com.wy.tool.JDBConnection;

//�Թ���Ա�Ĳ���
public class ManagerDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public ManagerDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }

  //�Թ���Ա���Ĳ�ѯ����
  public void insertManager(ManagerForm form) throws SQLException {
    try {

      ps = connection.prepareStatement("insert into tb_manager(account,password,name,sign) values (?,?,?,?)");
      ps.setString(1, form.getAccount());
      ps.setString(2, form.getPassword());
      ps.setString(3, form.getName());
      ps.setInt(4, 0);
      ps.executeUpdate();
    }
    catch (SQLException ex) {
    }
	finally 
	{
		ps.close();
		
	}

  }

  //�޸Ĺ���Ա����ķ���
  public void updateManagerPassword(ManagerForm form) throws SQLException {
    try {
      ps = connection.prepareStatement("update tb_manager set password=? where account=?");
      ps.setString(1, form.getPassword());
      ps.setString(2,form.getAccount());
      ps.executeUpdate();
    }
    catch (SQLException ex) {
    }
	finally 
	{
		ps.close();
		
	}

  }


  //ɾ������Ա�Ĳ���
  public void deleteManager(Integer id) throws SQLException {
    try {
      ps = connection.prepareStatement("delete from tb_manager where id=?");
      ps.setInt(1, id.intValue());
      ps.executeUpdate();
    }
    catch (SQLException ex) {
    }
	finally 
	{
		ps.close();
		
	}

  }

  //��ѯȫ������Ա����Ϣ
  public List selectManager() throws SQLException {
    List list = new ArrayList();
    ManagerForm manager = null;
    try {
      ps = connection.prepareStatement("select * from tb_manager order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        manager = new ManagerForm();
        manager.setId(Integer.valueOf(rs.getString(1)));
        manager.setAccount(rs.getString(2));
        manager.setPassword(rs.getString(3));
        manager.setName(rs.getString(4));
        manager.setSigh(Integer.valueOf(rs.getString(5)));
        list.add(manager);
      }
    }
    catch (SQLException ex) {
    }
	finally 
	{
		ps.close();
		
	}

    return list;
  }

//�Թ���Ա�˺�Ϊ������ѯ����Ա��Ϣ
  public ManagerForm selectOne(String account) throws SQLException {
    ManagerForm manager = null;
    try {
      ps = connection.prepareStatement("select * from tb_manager where account=?");
      ps.setString(1, account);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        manager = new ManagerForm();
        manager.setId(Integer.valueOf(rs.getString(1)));
        manager.setAccount(rs.getString(2));
        manager.setPassword(rs.getString(3));
        manager.setName(rs.getString(4));
        manager.setSigh(Integer.valueOf(rs.getString(5)));
      }
    }
    catch (SQLException ex) {
    }
	finally 
	{
		ps.close();
		
	}

    return manager;
  }



}