package com.wqdata.utils;

/**
 * com.wqdata.utils
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2018/4/19
 * 修改日期  :
 */
public class StringUtil {

  public String getStr(String str){
    if(isNotEmpty(str)){
      StringBuilder sb = new StringBuilder();
      String[] split = str.split(" ");
      String s = split[0];
      sb.append(s.substring(0,4)).append("-");
      sb.append(s.substring(4,6)).append("-");
      sb.append(s.substring(6,8)).append(" ").append(split[1]);
      return sb.toString();
    }
    return null;
  }

  /**
   * 字符串为空
   *
   * @param str
   * @return
   */
  public boolean isEmpty(String str) {
    if (str == null || "".equals(str.trim())) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * 判断字符串不为空
   *
   * @param str
   * @return
   */
  public boolean isNotEmpty(String str) {
    if ((str != null) && !"".equals(str.trim())) {
      return true;
    } else {
      return false;
    }
  }
}
