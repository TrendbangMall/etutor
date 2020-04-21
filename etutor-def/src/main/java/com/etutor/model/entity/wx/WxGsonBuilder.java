package com.etutor.model.entity.wx;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author ：Lion
 * @date ：2020/3/31 4:40 下午
 * @description ：
 */
public class WxGsonBuilder {
    private static final GsonBuilder INSTANCE = new GsonBuilder();

    public static Gson create() {
        return INSTANCE.create();
    }
}
