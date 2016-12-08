package me.inlife.website.business;

import com.alibaba.fastjson.JSON;
import me.inlife.website.data.PostsMapper;
import me.inlife.website.ibusiness.IPosts;
import me.inlife.website.ibusiness.ITags;
import me.inlife.website.model.Posts;
import me.inlife.website.model.Tags;
import me.inlife.website.model.page.PageWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kuangye on 2016/9/21.
 */
@Service
public class PostsBusiness implements IPosts {

    @Autowired
    PostsMapper postsMapper;
    @Autowired
    ITags iTags;

    public Posts getById(Long id) {
        if (id != null && id > 0) {
            Posts postsModel = postsMapper.selectByPrimaryKey(id);

            List<Tags> tagsModelList = iTags.getByPostId(id);
            postsModel.setTagsList(tagsModelList);

            return postsModel;
        }
        return null;
    }

    public Posts getByIdAddViewCount(Long id) {

        Posts postsModel = this.getById(id);
        if (postsModel != null) {
            Posts model = new Posts();
            model.setId(postsModel.getId());
            model.setViewCount(postsModel.getViewCount() + 1);
            postsMapper.updateByPrimaryKeySelective(model);


            List<Tags> tagsModelList = iTags.getByPostId(id);
            postsModel.setTagsList(tagsModelList);
        }

        return postsModel;
    }

    public boolean add(Posts postsModel) {
        return this.add(postsModel, null);
    }


    public boolean add(Posts postsModel, String tag) {
        if (postsModel != null) {

            //default publish now
            if (postsModel.getPublishTime() == null) {
                postsModel.setPublishTime(new Date());
            }

            int i = postsMapper.insertSelective(postsModel);

            if (StringUtils.hasText(tag)) {
                this.addTag(postsModel.getId(), tag);
            }

            return i > 0;
        }

        return false;
    }

    public boolean update(Posts postsModel) {
        return this.update(postsModel, null);
    }

    public boolean update(Posts postsModel, String tag) {
        if (postsModel != null) {

            if (StringUtils.hasText(tag)) {
                this.addTag(postsModel.getId(), tag);
            }

            return postsMapper.updateByPrimaryKeySelective(postsModel) > 0;
        }

        return false;
    }

    private void addTag(Long id, String tag) {

        iTags.deleteByPostid(id);

        if (StringUtils.hasText(tag)) {
            String[] tags = tag.split("[,，]");

            for (String t : tags) {
                iTags.addTagAndLinkPost(t, id);
            }
        }
    }


    public boolean delete(Long id) {
        if (id != null) {
            return postsMapper.deleteByPrimaryKey(id) > 0;
        }
        return false;
    }



    public Map<String, ?> searchByPage(String word, PageWeb pageWeb) {
        Map<String, Object> result = new HashMap<>();

        Map<String, Object> param = new HashMap<>();
        param.put("word", word);
        param.put("offset", pageWeb.getOffset());
        param.put("limit", pageWeb.getLimit());

        List<Posts> postsModelList = postsMapper.searchByPage(param);
        result.put("postsModelList", postsModelList);

        int count = postsMapper.searchCount(param);
        pageWeb.setPageIndex(pageWeb.getPageIndex());
        pageWeb.setCount(count);

        result.put("pageWeb", pageWeb);

        return result;
    }


    public List<Posts> selectByTag(Long tagId, PageWeb pageWeb) {

        Map<String, Object> param = new HashMap<>();
        param.put("tagId", tagId);
        param.put("offset", pageWeb.getOffset());
        param.put("limit", pageWeb.getLimit());

        return postsMapper.selectByTag(param);
    }

    public  Map<String, ?>  selectByTagWithPage(Long tagId, PageWeb pageWeb) {

        Map<String, Object> result = new HashMap<>();

        Map<String, Object> param = new HashMap<>();
        param.put("tagId", tagId);
        param.put("offset", pageWeb.getOffset());
        param.put("limit", pageWeb.getLimit());

        List<Posts> postsModelList = postsMapper.selectByTag(param);

        result.put("postsModelList", postsModelList);
        int count = postsMapper.selectByTagCount(param);
        pageWeb.setCount(count);
        result.put("pageWeb", pageWeb);

        return result;
    }

}
