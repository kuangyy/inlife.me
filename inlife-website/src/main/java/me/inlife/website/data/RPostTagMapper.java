package me.inlife.website.data;

import me.inlife.website.model.RPostTagKey;

import java.util.List;

public interface RPostTagMapper {
    int deleteByPrimaryKey(RPostTagKey key);

    int insert(RPostTagKey record);

    int insertSelective(RPostTagKey record);




    List<Long> selectTagidByPostid(Long id);

    int deleteByPostid(Long id);

}