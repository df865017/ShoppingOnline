package com.wy.dao;

import java.sql.*;
import java.util.*;

import com.wy.tool.JDBConnection;
import com.wy.domain.LinkForm;

//对友情连接网站表的操作
public class LinkDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public LinkDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }

  //删除的方法
  public void deleteLink(Integer id) throws SQLException {
    try {
      ps = connection.prepareStatement("delete from tb_link where id=?");
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



//添加的方法
  public void insertLink(LinkForm form) throws SQLException {
    try {
      ps = connection.prepareStatement("insert into tb_link(linkName,linkAddress) values (?,?)");
      ps.setString(1, form.getLinkName());
      ps.setString(2, form.getLinkAddress());
      ps.executeUpdate();

    }
    catch (SQLException ex) {
    }
	finally 
	{
		ps.close();
		
	}

  }




//全部查询的方法
  public List selectLink() throws SQLException {
    List list = new ArrayList();
    LinkForm link = null;
    try {
      ps = connection.prepareStatement("select * from tb_link order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        link = new LinkForm();
        link.setId(Integer.valueOf(rs.getString(1)));
        link.setLinkName(rs.getString(2));
        link.setLinkAddress(rs.getString(3));
        list.add(link);
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
