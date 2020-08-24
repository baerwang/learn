package com.baerwang.service.impl;

import com.baerwang.annotation.Service;
import com.baerwang.service.DayService;

import java.util.Arrays;

@Service
public class DayServiceImpl implements DayService {

    @Override
    public boolean find(String name) {
        for (String s :  Arrays.asList("变天","李四","张三","哭唧唧")) {
            if (s.equals(name)) {
                return true;
            }
        }
        return false;
    }

}
