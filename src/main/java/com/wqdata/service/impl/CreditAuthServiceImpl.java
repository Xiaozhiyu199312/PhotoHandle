package com.wqdata.service.impl;

import com.wqdata.dao.CreditAuthDao;
import com.wqdata.dao.impl.CreditAuthDaoImpl;
import com.wqdata.pojo.CreditAuth;
import com.wqdata.service.CreditAuthService;

import java.sql.Connection;

/**
 * com.wqdata.service.impl
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/4/18
 * 修改日期  :
 */
public class CreditAuthServiceImpl implements CreditAuthService{

  private CreditAuthDao creditAuthDao= new CreditAuthDaoImpl();

  @Override
  public CreditAuth getCreditAuth(String idCard, Connection conn) throws Exception {
    String sql = "select * from t_credit_auth where IDCARD = ?";
    return creditAuthDao.getCreditAuth(idCard,conn,sql);
  }
}
