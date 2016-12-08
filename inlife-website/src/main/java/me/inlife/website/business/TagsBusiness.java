package me.inlife.website.business;

import me.inlife.website.data.RPostTagMapper;
import me.inlife.website.data.TagsMapper;
import me.inlife.website.ibusiness.IPosts;
import me.inlife.website.ibusiness.ITags;
import me.inlife.website.model.Posts;
import me.inlife.website.model.Tags;
import me.inlife.website.model.page.PageWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/23.
 */
@Service
public class TagsBusiness implements ITags {

    @Autowired
    IPosts iPosts;

    @Autowired
    TagsMapper tagsMapper;
    @Autowired
    RPostTagMapper rPostTagMapper;

    public Tags getById(Long id) {
        if (id != null && id > 0) {
            return tagsMapper.selectByPrimaryKey(id);
        }
        return null;
    }


    public boolean add(Tags tagsModel) {
        if (tagsModel != null) {
            return tagsMapper.insertSelective(tagsModel) > 0;
        }
        return false;
    }

    public boolean update(Tags tagsModel) {
        if (tagsModel != null) {
            return tagsMapper.updateByPrimaryKeySelective(tagsModel) > 0;
        }
        return false;
    }

    public boolean delete(Long id) {
        if (id != null) {
            return tagsMapper.deleteByPrimaryKey(id) > 0;
        }
        return false;
    }

    public Map<String, ?> selectByPage(Tags postsModel, PageWeb pageWeb) {
        Map<String, Object> result = new HashMap<>();

        Map<String, Object> param = new HashMap<>();
        param.put("model", postsModel);
        param.put("offset", pageWeb.getOffset());
        param.put("limit", pageWeb.getLimit());

        List<Tags> tagsModelList = tagsMapper.selectByPage(param);
        result.put("tagsModelList", tagsModelList);

        int count = tagsMapper.count(param);
        pageWeb.setPageIndex(pageWeb.getPageIndex());
        pageWeb.setCount(count);

        result.put("pageWeb", pageWeb);

        return result;
    }


    public List<Tags> selectHotTagByPage(PageWeb pageWeb) {
        return this.selectHotTagByPage(pageWeb, 0, false);
    }

    public List<Tags> selectHotTagByPage(PageWeb pageWeb, Integer postsCount, boolean needPosts) {

        List<Tags> tagsModelList = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();

        if (pageWeb != null) {
            map.put("offset", pageWeb.getOffset());
            map.put("limit", pageWeb.getLimit());
        }

        //获取 hot tag
        List<Map<String, Object>> mapList = tagsMapper.selectByPostsCount(map);

        if (mapList != null && mapList.size() > 0) {
            for (Map<String, Object> result : mapList) {
                //set tag
                Tags tagsModel = new TagsModel();
                tagsModel.setId((Long) result.get("id"));
                tagsModel.setSimbol((String) result.get("simbol"));
                tagsModel.setName((String) result.get("name"));

                if (needPosts) {
                    postsCount = postsCount == null ? 0 : postsCount;
                    //set posts
                    PageWeb pageWeb1 = new PageWeb();
                    pageWeb1.setPageSize(postsCount);

                    List<Posts> postsModels = iPosts.selectByTag(tagsModel.getId(), pageWeb1);
                    tagsModel.setPostsModelList(postsModels);
                }

                tagsModelList.add(tagsModel);
            }
        }

        return tagsModelList;
    }


    public List<Tags> getByPostId(Long id) {
        if (id != null) {

            List<Long> ids = rPostTagMapper.selectTagidByPostid(id);
            if (ids != null && ids.size() > 0) {
                return tagsMapper.selectByPostId(ids);
            }
        }
        return null;
    }

    public List<TagsModel> getByBookId(Long id){
        if (id != null) {

            List<Long> ids = rBookTagModelMapper.selectTagidByBookid(id);
            if (ids != null && ids.size() > 0) {
                return tagsModelMapper.selectByPostId(ids);
            }
        }
        return null;
    }


    public void addTagAndLinkPost(String name, Long postid) {

        TagsModel tagsModel = tagsModelMapper.selectByName(name);

        Long tagid;
        if (tagsModel != null) {
            tagid = tagsModel.getId();
        } else {
            TagsModel model = new TagsModel();
            model.setName(name);
            model.setSimbol(Chinese2Pinyin.cn2Spell(name));
            tagsModelMapper.insertSelective(model);

            tagid = model.getId();
        }


        RPostTagModelKey rPostTagModelKey = new RPostTagModelKey();
        rPostTagModelKey.setPostId(postid);
        rPostTagModelKey.setTagId(tagid);
        rPostTagModelMapper.insert(rPostTagModelKey);
    }


    public void deleteByPostid(Long postid) {
        rPostTagModelMapper.deleteByPostid(postid);
    }

    public TagsModel getByName(String name) {
        if (StringUtils.hasText(name)) {
            return tagsModelMapper.selectByName(name);
        }
        return null;
    }
}





