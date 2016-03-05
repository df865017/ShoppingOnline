package com.wy.dao;

import com.wy.tool.JDBConnection;
import java.sql.*;
import java.util.*;
import com.wy.domain.OrderDetailForm;

//订货明细表的操作
public class OrderDetailDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public OrderDetailDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }
public List selectOrderDetailNumber(String number) throws SQLException{
  List list =new ArrayList();
  OrderDetailForm orderDetail=null;
  try {
    ps = connection.prepareStatement("select * from tb_orderDetail where orderNumber=?");
    ps.setString(1,number);
    ResultSet rs=ps.executeQuery();
    while(rs.next()){
      orderDetail=new OrderDetailForm();
      orderDetail.setId(Integer.valueOf(rs.getString(1)));
      orderDetail.setOrderNumber(rs.getString(2));
      orderDetail.setGoodsId(Integer.valueOf(rs.getString(3)));
      orderDetail.setPrice(Float.parseFloat(rs.getString(4)));
      orderDetail.setNumber(Integer.parseInt(rs.getString(5)));
      list.add(orderDetail);
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


//添加的方法
  public void insertOrderDetail(OrderDetailForm form) throws SQLException {
    try {
      ps = connection.prepareStatement("insert into tb_orderDetail(orderNumber, goodsId, price,number) values (?,?,?,?)");
      ps.setString(1, form.getOrderNumber());
      ps.setString(2, form.getGoodsId().toString());
      ps.setFloat(3, form.getPrice());
      ps.setInt(4, form.getNumber());
      ps.executeUpdate();
    }
    catch (SQLException ex) {
    }
	finally 
	{
		ps.close();
		
	}
  }

  //删除子表的操作
  public void deleteOrderDetail(String number) throws SQLException{
    try {
      ps = connection.prepareStatement("delete from tb_orderDetail where orderNumber=?");
      ps.setString(1,number);
      ps.executeUpdate();
    }
    catch (SQLException ex) {
    }
	finally 
	{
		ps.close();
		
	}


  }

}
