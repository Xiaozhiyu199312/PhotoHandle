package com.wqdata.web;

import com.wqdata.pojo.CreditAuth;
import com.wqdata.pojo.FaceInfo;
import com.wqdata.service.CreditAuthService;
import com.wqdata.service.FaceInfoService;
import com.wqdata.service.impl.CreditAuthServiceImpl;
import com.wqdata.service.impl.FaceInfoServiceImpl;
import com.wqdata.utils.ConnUtil;
import com.wqdata.utils.DateUtil;
import com.wqdata.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * com.wqdata.web
 * 作者      : 陈晓
 * 描述      : 用户处理本地图片信息加载到数据库
 * 创建日期  : 2018/4/18
 * 修改日期  :
 */
public class PhotoServlet extends HttpServlet {

  private FaceInfoService faceInfoService = new FaceInfoServiceImpl();
  private CreditAuthService creditAuthService = new CreditAuthServiceImpl();
  private ConnUtil connUtil = new ConnUtil();
  private DateUtil dateUtil = new DateUtil();
  private StringUtil stringUtil = new StringUtil();
  private static final String format = "yyyy-MM-dd HH:mm:ss";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doGet(req, resp);
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    String photoAddress = (String) req.getParameter("photoAddress");
    System.out.println("===photoAddress===" + photoAddress);
    try {
      if (stringUtil.isNotEmpty(photoAddress)) {
        getPhoto(photoAddress, req, resp);
      } else {
        sendData("文件路径不能为空！！！", req, resp);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * @param photoPath 文件夹的目录
   * @param req
   * @param resp
   */
  private String getPhoto(String photoPath, HttpServletRequest req, HttpServletResponse resp) throws Exception {
    FaceInfo faceInfo = null;
    String message = "数据已成功全部加载！";
    Connection conn = connUtil.getConn();
    File file1 = new File(photoPath);//File类型可以是文件也可以是文件夹
    File[] fileList = file1.listFiles();//将该目录下的所有文件放置在一个File类型的数组中
    List<File> wjjList = new ArrayList<File>();//新建一个文件夹集合
    for (int i = 0; i < fileList.length; i++) {
      if (fileList[i].isDirectory()) {//判断是否为文件夹
        wjjList.add(fileList[i]);
      }
    }
    for (int i = 0; i < wjjList.size(); i++) {
      File file = wjjList.get(i);
      File[] files = file.listFiles();
      String fileName = file.getName();
      // System.out.println("======文件名称======" + fileName);
      for (int j = 0; j < files.length; ) {
        String name_front = files[j].getName();
        //  System.out.println("===正面===" + name_front);
        if (name_front.endsWith(".jpg") || name_front.endsWith(".png")
                || name_front.endsWith(".gif")) {
          String name_back = files[j + 1].getName();
          String[] split_front = name_front.split("_");
          String[] split_back = name_back.split("_");
          String photo_idCard_front = split_front[1];
          String photo_idCard_back = split_back[1];
          // System.out.println("===身份证===photo_idCard_front===" + photo_idCard_front);
          // System.out.println("===身份证===photo_idCard_back====" + photo_idCard_back);
          if (photo_idCard_back.equals(photo_idCard_front)) {
            try {
              CreditAuth creditAuth = creditAuthService.getCreditAuth(photo_idCard_back, conn);
              if (creditAuth != null) {
                boolean flag = faceInfoService.findFaceInfo(creditAuth.getApplicationNo(), conn);
                if (flag) {
                  faceInfo = new FaceInfo();
                  faceInfo.setRealname(creditAuth.getAgreeName());
                  faceInfo.setApplicationNo(creditAuth.getApplicationNo());
                  faceInfo.setCity(creditAuth.getZoneCode());
                  faceInfo.setIdcard(creditAuth.getIdcard());
                  faceInfo.setIdcardFront("/" + fileName + "!" + name_front);
                  faceInfo.setIdcardBack("/" + fileName + "!" + name_back);
                  String agreeTime = creditAuth.getAgreeTime();
                  String createtime = creditAuth.getCreatetime();
                  String agreeTimeStr = stringUtil.getStr(agreeTime);
                  String createtimeStr = stringUtil.getStr(createtime);
                  if (null != agreeTimeStr && null != createtimeStr) {
                    faceInfo.setIdentifyAt(dateUtil.parseDate(agreeTimeStr, format));
                    faceInfo.setCreateAt(dateUtil.parseDate(createtimeStr, format));
                  } else {
                    /*req.getSession().setAttribute("message", "文件夹'" + fileName + "'中的" + "图片'" + name_back + "'中根据身份证获得t_credit_auth表中的数据有误！！！");
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);*/
                    message = "文件夹'" + fileName + "'中的" + "图片'" + name_back + "'中根据身份证获得t_credit_auth表中的数据有误！！！";
                    sendData(message, req, resp);
                    return null;
                    //break;
                  }
                  int insert = faceInfoService.insert(faceInfo, conn);
                  if (insert > 0) {
                    j = j + 2;
                  } else {
                   /* req.getSession().setAttribute("message", "文件夹'" + fileName + "'中的" + "图片'" + name_back + "'信息插入到数据库出现问题,停止向下添加图片信息数据！");
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);*/
                    message = "文件夹'" + fileName + "'中的" + "图片'" + name_back + "'信息插入到数据库出现问题,停止向下添加图片信息数据！";
                    sendData(message, req, resp);
                    return null;
                    //break;
                  }
                } else {
                  message = "文件夹'" + fileName + "'中的" + "图片'" + name_back + "'的application_no已存在,停止向下添加图片信息数据！";
                  req.getSession().setAttribute("message", message);
                  req.getRequestDispatcher("/index.jsp").forward(req, resp);
                  return null;
                  //sendData(message, req, resp);
                  // break;
                }
              }
            } catch (Exception e) {
              e.printStackTrace();
              break;
            }
          }
        } else {
          j = j + 2;
        }
      }
      sendData(message, req, resp);
    }
    if (null != conn) {
      connUtil.close();
    }
    return null;
  }

  /**
   * 返回值前台的文字信息
   *
   * @param message 文字信息
   * @param req
   * @param resp
   */
  private void sendData(String message, HttpServletRequest req, HttpServletResponse resp) throws Exception {
    req.getSession().setAttribute("message", message);
    req.getRequestDispatcher("/index.jsp").forward(req, resp);
  }


  private static List<String> getAllFile(File mFile, File mlist) {
    List<String> list = new ArrayList<>();
    // 1.获取子目录
    File[] files = mFile.listFiles();
    // 2.判断files是否是空的 否则程序崩溃
    if (files != null) {
      for (File file : files) {
        if (file.isDirectory()) {
          getAllFile(file, mlist);//调用递归的方式
        } else {
          // 4. 添加到集合中去
          String fileName = file.getName();
          if (fileName.endsWith(".jpg") || fileName.endsWith(".png")
                  || fileName.endsWith(".gif")) {
            //mlist.add(file);//如果是这几种图片格式就添加进去
            list.add(fileName);
          }
        }
      }
    }
    return list;
  }

}
