package com.wqdata.service;

import com.wqdata.pojo.FaceInfo;

import java.sql.Connection;

/**
 * com.wqdata.service
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/4/18
 * 修改日期  :
 */
public interface FaceInfoService {

  int insert(FaceInfo faceInfo,Connection conn)throws Exception;

  boolean findFaceInfo(String application_no,Connection conn)throws Exception;
}
