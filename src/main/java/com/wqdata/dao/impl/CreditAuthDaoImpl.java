package com.wqdata.dao.impl;

import com.wqdata.dao.CreditAuthDao;
import com.wqdata.pojo.CreditAuth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * com.wqdata.dao.impl
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/4/18
 * 修改日期  :
 */
public class CreditAuthDaoImpl implements CreditAuthDao {

  @Override
  public CreditAuth getCreditAuth(String idCard, Connection conn,String sql) throws Exception {
    PreparedStatement ps = conn.prepareStatement(sql);
    CreditAuth creditAuth = new CreditAuth();
    ps.setString(1,idCard);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){

      //Retrieve by column name
      creditAuth.setAgreeName(rs.getString("AGREE_NAME"));
      creditAuth.setIdcard(rs.getString("IDCARD"));
      creditAuth.setApplicationNo(rs.getString("APPLICATION_NO"));
      creditAuth.setAgreeTime(rs.getString("AGREE_TIME"));
      creditAuth.setCreatetime(rs.getString("CREATETIME"));
      creditAuth.setUpdatetime(rs.getString("UPDATETIME"));
      creditAuth.setZoneCode(rs.getString("ZONE_CODE"));
      creditAuth.setSignedFile(rs.getString("SIGNED_FILE"));
      /*String agreeName = rs.getString("AGREE_NAME");
      String idcard = rs.getString("IDCARD");
      String applicationNo = rs.getString("APPLICATION_NO");
      String agreeTime = rs.getString("AGREE_TIME");
      String createtime = rs.getString("CREATETIME");
      String updatetime = rs.getString("UPDATETIME");
      String zoneCode = rs.getString("ZONE_CODE");
      String signedFile = rs.getString("SIGNED_FILE");*/
    }
    return creditAuth;
  }
}
