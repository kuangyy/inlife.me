package me.inlife.website.data;

import me.inlife.website.model.Tags;

public interface TagsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tags record);

    int insertSelective(Tags record);

    Tags selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tags record);

    int updateByPrimaryKey(Tags record);
}