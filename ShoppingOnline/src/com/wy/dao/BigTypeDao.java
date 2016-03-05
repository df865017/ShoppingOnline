package com.wy.dao;

import com.wy.tool.CountTime;
import com.wy.tool.JDBConnection;
import java.sql.*;
import java.util.*;
import com.wy.domain.BigTypeForm;

//����Ʒ�������Ϣ�Ĳ���
public class BigTypeDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public BigTypeDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }


//�����ݿ���ˮ��Ϊ������ѯ����������
  public String selectName(Integer id) throws SQLException {
    String name = null;
    try {
      this.ps = connection.prepareStatement("select * from tb_bigType where id=?");
      ps.setString(1, id.toString());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        name = rs.getString("bigName");
      }
    }
    catch (SQLException ex) {
    }
	finally 
	{
		ps.close();
		
	}

    return name;
  }

//ɾ������
  public boolean deleteBig(Integer id) throws SQLException {
    try {
      ps = connection.prepareStatement("delete from tb_bigType where id=?");
      ps.setString(1, id.toString());
      ps.executeUpdate();
      return true;
    }
    catch (SQLException ex) {
      return false;
    }
	finally 
	{
		ps.close();
		
	}

  }


  //��Ӳ���
  public void insertBig(String name) throws SQLException {
    try {
      ps = connection.prepareStatement("insert into tb_bigType(bigName,creaTime) values (?,now())");
      ps.setString(1, name);
      ps.executeUpdate();
     
    }
    catch (SQLException ex) {
    }
	finally 
	{
		ps.close();
		
	}

  }

  //ȫ����ѯ�Ĳ���
  public List selectBig() throws SQLException {
    List list = new ArrayList();
    BigTypeForm big = null;
    try {
      this.ps = connection.prepareStatement("select * from tb_bigType order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        big = new BigTypeForm();
        big.setId(Integer.valueOf(rs.getString(1)));
        big.setBigName(rs.getString(2));
        big.setCreaTime(rs.getString(3));
        list.add(big);
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

}
