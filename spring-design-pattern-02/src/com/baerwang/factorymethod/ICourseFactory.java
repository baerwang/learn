package com.baerwang.factorymethod;

import com.baerwang.simplefactory.ICourse;

/**
 * @author baerwang
 * @since 2020/8/28
 */
public interface ICourseFactory {

    ICourse create();
}
