package com.wqdata.service.impl;

import com.wqdata.dao.FaceInfoDao;
import com.wqdata.dao.impl.FaceInfoDaoImpl;
import com.wqdata.pojo.FaceInfo;
import com.wqdata.service.FaceInfoService;

import java.sql.Connection;

/**
 * com.wqdata.service.impl
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/4/18
 * 修改日期  :
 */
public class FaceInfoServiceImpl implements FaceInfoService {

  private FaceInfoDao faceInfoDao = new FaceInfoDaoImpl();

  @Override
  public int insert(FaceInfo faceInfo,Connection conn) throws Exception {
    String sql = "insert into faceinfo(realname,idcard,city,application_no,idcard_front,idcard_back,identify_at,create_at) values(?,?,?,?,?,?,?,?)";
    return faceInfoDao.insert(faceInfo,sql,conn);
  }

  @Override
  public boolean findFaceInfo(String application_no, Connection conn) throws Exception {
    String sql = "select * from faceinfo where application_no = ?";
    return faceInfoDao.findFaceInfo(application_no,sql,conn);
  }
}
