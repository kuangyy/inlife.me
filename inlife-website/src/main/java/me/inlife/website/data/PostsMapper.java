package me.inlife.website.data;

import me.inlife.website.model.Posts;

import java.util.List;
import java.util.Map;

public interface PostsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Posts record);

    int insertSelective(Posts record);

    Posts selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Posts record);

    int updateByPrimaryKeyWithBLOBs(Posts record);

    int updateByPrimaryKey(Posts record);





    List<Posts> searchByPage(Map<String,?> map);

    int searchCount(Map<String,?> map);

    List<Posts> selectByTag(Map map);

    int selectByTagCount(Map map);



}