package me.inlife.website.ibusiness;

import me.inlife.website.model.Posts;
import me.inlife.website.model.page.PageWeb;

import java.util.List;
import java.util.Map;

/**
 * Created by kuangye on 2016/9/21.
 */
public interface IPosts {

    Posts getById(Long id);

    Posts getByIdAddViewCount(Long id);

    boolean add(Posts postsModel);

    boolean update(Posts postsModel);

    boolean add(Posts postsModel, String tag);

    boolean update(Posts postsModel, String tag);

    boolean delete(Long id);

    Map<String, ?> selectByPage(Posts postsModel, Posts pageWeb);

    Map<String, ?> searchByPage(String word, Posts pageWeb);


    List<Posts> selectByTag(Long tagId, PageWeb pageWeb);

    Map<String, ?> selectByTagWithPage(Long tagId, PageWeb pageWeb);

}
