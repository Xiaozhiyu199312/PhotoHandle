package com.wqdata.dao.impl;

import com.wqdata.dao.FaceInfoDao;
import com.wqdata.pojo.FaceInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;


/**
 * com.wqdata.dao.impl
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/4/18
 * 修改日期  :
 */
public class FaceInfoDaoImpl implements FaceInfoDao {

  private PreparedStatement preparedStatement = null;

  @Override
  public int insert(FaceInfo faceInfo, String sql, Connection conn) throws Exception {
    if (conn != null) {
      preparedStatement = conn.prepareStatement(sql);
      preparedStatement.setString(1, faceInfo.getRealname());
      preparedStatement.setString(2, faceInfo.getIdcard());
      preparedStatement.setString(3, faceInfo.getCity());
      preparedStatement.setString(4, faceInfo.getApplicationNo());
      preparedStatement.setString(5, faceInfo.getIdcardFront());
      preparedStatement.setString(6, faceInfo.getIdcardBack());
      java.sql.Date sqlDate1 = new java.sql.Date(faceInfo.getIdentifyAt().getTime());
      java.sql.Date sqlDate2 = new java.sql.Date(faceInfo.getCreateAt().getTime());
      Timestamp ts1 = new Timestamp(sqlDate1.getTime());
      Timestamp ts2 = new Timestamp(sqlDate2.getTime());
      preparedStatement.setTimestamp(7, ts1);
      preparedStatement.setTimestamp(8, ts2);
    }
    return preparedStatement.executeUpdate();
  }

  @Override
  public boolean findFaceInfo(String application_no, String sql, Connection conn) throws Exception {
    boolean flag = true;
    int id = 0;
    if (conn != null) {
      preparedStatement = conn.prepareStatement(sql);
      preparedStatement.setString(1, application_no);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        id = rs.getInt("id");
      }
    }
    if (id > 0) {
      flag = false;
    }
    return flag;
  }
}
