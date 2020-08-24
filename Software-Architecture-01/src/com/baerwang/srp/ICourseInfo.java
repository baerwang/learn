package com.baerwang.srp;

/**
 * @author baerwang
 * @since 2020/8/24 23:16
 */
public interface ICourseInfo {

    /**
     * 获取基本信息
     */
    String getCourseName();

    /**
     * 获取视频流
     */
    byte[] getCourseVideo();
}
