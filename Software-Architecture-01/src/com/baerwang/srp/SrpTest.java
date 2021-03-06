package com.baerwang.srp;

/**
 * 单一职责原则（Simple Responsibility Pinciple，SRP）
 * <p>
 * 单一职责是指不要存在多于一个导致类变更的原因。
 * 假设我们有一个类负责两个职责，一旦发生需求变更，修改其中一个职责的逻辑代码，有可能导致另一个职责的功能发生故障。
 * 这样一来，这个类就存在两个导致类变更的原因。
 * 讲两个职责用两个类来实现，进行解耦。后期需求变更维护互不影响。这样的设计可以降低类的复杂度，提高类的可读性，
 * 提高系统的可维护性，降低变更引起的风险。
 * 总体来说，一个类、接口或方法只负责一项职责。
 * </p>
 *
 * @author baerwang
 * @since 2020/8/24 23:03
 */
public class SrpTest {

    public static void main(String[] args) {
        /*Course course = new Course();
        course.study("直播课");
        course.study("录播课");*/

        LiveCourse liveCourse = new LiveCourse();
        liveCourse.study("直播课");

        ReplayCourse replayCourse = new ReplayCourse();
        replayCourse.study("录播课");
    }
}
