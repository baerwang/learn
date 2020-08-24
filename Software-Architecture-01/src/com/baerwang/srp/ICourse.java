package com.baerwang.srp;

/**
 * @author baerwang
 * @since 2020/8/24 23:15
 */
public interface ICourse {

    /**
     * 获取基本信息
     */
    String getCourseName();

    /**
     * 获取视频流
     */
    byte[] getCourseVideo();

    /**
     * 学习课程
     */
    void studyCourse();

    /**
     * 退款
     */
    void refundCourse();
}
