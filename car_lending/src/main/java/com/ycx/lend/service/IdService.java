package com.ycx.lend.service;

import org.apache.ibatis.annotations.Param;

/**
 * @Author ycx
 * @Date 2022/1/24 19:23
 * @Description
 */
public interface IdService {
    String getMaxId(String tableName, String idName);

    String getMinId(String tableName, String idName);
}
