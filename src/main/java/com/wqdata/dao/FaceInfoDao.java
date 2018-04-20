package com.wqdata.dao;

import com.wqdata.pojo.FaceInfo;

import java.sql.Connection;

/**
 * com.wqdata.dao
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/4/18
 * 修改日期  :
 */
public interface FaceInfoDao {

  int insert(FaceInfo faceInfo, String sql,Connection conn) throws Exception;

  boolean findFaceInfo(String application_no, String sql,Connection conn)throws Exception;
}
