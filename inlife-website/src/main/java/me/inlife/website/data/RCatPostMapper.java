package me.inlife.website.data;

import me.inlife.website.model.RCatPostKey;

public interface RCatPostMapper {
    int deleteByPrimaryKey(RCatPostKey key);

    int insert(RCatPostKey record);

    int insertSelective(RCatPostKey record);
}