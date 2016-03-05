package com.wy.dao;

import com.wy.tool.JDBConnection;
import com.wy.tool.CountTime;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import com.wy.domain.OrderForm;

//订货表的操作
public class OrderDao {
	private Connection connection = null; // 定义连接的对象
	private PreparedStatement ps = null; // 定义预准备的对象
	private JDBConnection jdbc = null; // 定义数据库连接对象
    
	public OrderDao() {
		jdbc = new JDBConnection();
		connection = jdbc.connection; // 利用构造方法取得数据库连接
	}

	// 前台订货查询
	public List selectOrderHead(String name) throws SQLException {
		List list = new ArrayList();
		OrderForm order = null;
		try {
			ps = connection
					.prepareStatement("select * from tb_order where name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order = new OrderForm();
				order.setId(Integer.valueOf(rs.getString(1)));
				order.setNumber(rs.getString(2));
				order.setName(rs.getString(3));
				order.setReallyName(rs.getString(4));
				order.setAddress(rs.getString(5));
				order.setTel(rs.getString(6));
				order.setSetMoney(rs.getString(7));
				order.setPost(rs.getString(8));
				order.setBz(rs.getString(9));
				order.setSign(rs.getString(10));
				order.setCreaTime(rs.getString(11));
				list.add(order);

			}
		} catch (SQLException ex) {
		} finally {
			ps.close();

		}

		return list;
	}

	// 以订货编号为条件查询信息
	public OrderForm selectOrderNumber(String number) throws SQLException {

		OrderForm order = null;
		try {
			ps = connection
					.prepareStatement("select * from tb_order where number=?");
			ps.setString(1, number);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order = new OrderForm();
				order.setId(Integer.valueOf(rs.getString(1)));
				order.setNumber(rs.getString(2));
				order.setName(rs.getString(3));
				order.setReallyName(rs.getString(4));
				order.setAddress(rs.getString(5));
				order.setTel(rs.getString(6));
				order.setSetMoney(rs.getString(7));
				order.setPost(rs.getString(8));
				order.setBz(rs.getString(9));
				order.setSign(rs.getString(10));
				order.setCreaTime(rs.getString(11));

			}
		} catch (SQLException ex) {
		} finally {
			ps.close();

		}

		return order;
	}

	// 出货操作
	public void updateSignOrder(String number) throws SQLException {
		try {
			ps = connection
					.prepareStatement("update tb_order set sign=1 where number=?");
			ps.setString(1, number);
			ps.executeUpdate();
		} catch (SQLException ex) {
		} finally {
			ps.close();

		}

	}

	// 删除订货信息
	public boolean deleteOrder(String number) throws SQLException {
		try {
			ps = connection
					.prepareStatement("delete from tb_order where number=?");
			ps.setString(1, number);
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			return false;
		} finally {
			ps.close();

		}

	}

	// 以订货标记为条件查询信息
	public List selectOrderSign(Integer id) throws SQLException {
		List list = new ArrayList();
		OrderForm order = null;
		try {
			if (id == null) {
				ps = connection
						.prepareStatement("select * from tb_order order by id DESC");
			} else {
				ps = connection
						.prepareStatement("select * from tb_order where sign=? order by id DESC");
				ps.setInt(1, id.intValue());
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order = new OrderForm();
				order.setId(Integer.valueOf(rs.getString(1)));
				order.setNumber(rs.getString(2));
				order.setName(rs.getString(3));
				order.setReallyName(rs.getString(4));
				order.setAddress(rs.getString(5));
				order.setTel(rs.getString(6));
				order.setSetMoney(rs.getString(7));
				order.setPost(rs.getString(8));
				order.setBz(rs.getString(9));
				order.setSign(rs.getString(10));
				order.setCreaTime(rs.getString(11));
				list.add(order);
			}
		} catch (SQLException ex) {
		} finally {
			ps.close();

		}

		return list;
	}

	// 添加的方法
	public void insertOrderDetail(OrderForm form) throws SQLException {
		try {
			ps = connection
					.prepareStatement("insert into tb_order (Number, Name, reallyName, Address, Tel, SetMoney, Post, Bz, Sign, creaTime) values (?,?,?,?,?,?,?,?,?,now())");
			ps.setString(1, form.getNumber());
			ps.setString(2, form.getName());
			ps.setString(3, form.getReallyName());
			ps.setString(4, form.getAddress());
			ps.setString(5, form.getTel());
			ps.setString(6, form.getSetMoney());
			ps.setString(7, form.getPost());
			ps.setString(8, form.getBz());
			ps.setString(9, form.getSign());
			
			//System.out.println(ps.toString());
			ps.executeUpdate();
			
		} catch (SQLException ex) {

		} finally {
			ps.close();

		}

	}
}
