package com.wqdata.dao;

import com.wqdata.pojo.CreditAuth;

import java.sql.Connection;

/**
 * com.wqdata.dao
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/4/18
 * 修改日期  :
 */
public interface CreditAuthDao {

  CreditAuth getCreditAuth(String idCard, Connection conn,String sql)throws Exception;
}
