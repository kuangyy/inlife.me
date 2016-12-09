package me.inlife.website.data;

import me.inlife.website.model.Tags;

import java.util.List;
import java.util.Map;

@InlifeDB
public interface TagsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tags record);

    int insertSelective(Tags record);

    Tags selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tags record);

    int updateByPrimaryKey(Tags record);






    List<Tags> selectByPage(Map<String,?> map);

    int count(Map<String,?> map);

    List<Map<String,Object>> selectByPostsCount(Map map);


    List<Tags> selectByPostId(List<Long> id);

    Tags selectByName(String name);
}