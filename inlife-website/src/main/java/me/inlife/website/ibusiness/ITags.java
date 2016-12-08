package me.inlife.website.ibusiness;


import me.inlife.website.model.Tags;
import me.inlife.website.model.page.PageWeb;

import java.util.List;
import java.util.Map;

/**
 * Created by kuangye on 2016/9/21.
 */
public interface ITags {

    Tags getById(Long id);


    boolean add(Tags tagsModel);

    boolean update(Tags tagsModel);

    boolean delete(Long id);

    Map<String, ?> selectByPage(Tags postsModel, PageWeb pageWeb);


    List<Tags> selectHotTagByPage(PageWeb pageWeb);

    List<Tags> selectHotTagByPage(PageWeb pageWeb, Integer postsCount, boolean needPosts);


    List<Tags> getByPostId(Long id);

    void addTagAndLinkPost(String name, Long postid);

    void deleteByPostid(Long postid);

    Tags getByName(String name);
}
