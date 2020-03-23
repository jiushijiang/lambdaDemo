package com.mybatisplus.utils;

public class StrUtil {


    public static String getNextOrgNo(String orgNo){

        //转换成Integer
        if (orgNo.length()<2){

            return null;
        }
        //截取后两位
        Integer num=Integer.valueOf(orgNo.substring(orgNo.length()-2,orgNo.length()));
        num=num+1;

        String numStr=num.toString();
        if (numStr.length()<2){
            numStr="0"+numStr;
        }

        //替换
        StringBuffer orgAfter=new StringBuffer(orgNo.substring(0,orgNo.length()-2));

        //转换
        orgAfter.append(numStr);
        return orgAfter.toString();
    }
}
