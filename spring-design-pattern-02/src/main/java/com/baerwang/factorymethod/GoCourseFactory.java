package com.baerwang.factorymethod;

import com.baerwang.simplefactory.GoCourse;
import com.baerwang.simplefactory.ICourse;

/**
 * @author baerwang
 * @since 2020/8/28
 */
public class GoCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new GoCourse();
    }

}
