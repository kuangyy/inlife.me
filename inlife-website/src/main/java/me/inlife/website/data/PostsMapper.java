package me.inlife.website.data;

import me.inlife.website.model.Posts;

public interface PostsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Posts record);

    int insertSelective(Posts record);

    Posts selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Posts record);

    int updateByPrimaryKeyWithBLOBs(Posts record);

    int updateByPrimaryKey(Posts record);
}