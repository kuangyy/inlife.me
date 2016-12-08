package me.inlife.website.data;

import me.inlife.website.model.RPostTagKey;

public interface RPostTagMapper {
    int deleteByPrimaryKey(RPostTagKey key);

    int insert(RPostTagKey record);

    int insertSelective(RPostTagKey record);
}