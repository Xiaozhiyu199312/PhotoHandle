package com.wqdata.service;

import com.wqdata.pojo.CreditAuth;

import java.sql.Connection;

/**
 * com.wqdata.service
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/4/18
 * 修改日期  :
 */
public interface CreditAuthService {

  CreditAuth getCreditAuth(String idCard, Connection conn)throws Exception;
}
