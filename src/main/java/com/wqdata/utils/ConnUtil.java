package com.wqdata.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * com.wqdata.utils
 * 作者      : 陈晓
 * 描述      :数据库操作类
 * 创建日期  : 2018/4/18
 * 修改日期  :
 */
public class ConnUtil {

  public static final String url = "jdbc:mysql://127.0.0.1/uplback";
  public static final String name = "com.mysql.jdbc.Driver";
  public static final String user = "root";
  public static final String password = "password";

  public static Connection conn = null;

  /**
   * 建立数据库连接
   *
   * @return
   */
  public Connection getConn() {
    try {
      Class.forName(name);//指定连接类型
      conn = DriverManager.getConnection(url, user, password);//获取连接
    } catch (Exception e) {
      e.printStackTrace();
    }
    return conn;
  }

  /**
   * 关闭数据库连接
   */
  public void close() {
    try {
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /*public static void main(String[] args) {
    Connection conn = getConn();
    if (conn != null) {
      System.out.println("99999999");
      close();
    } else {
      System.out.println("11111111");
    }

  }*/
}
