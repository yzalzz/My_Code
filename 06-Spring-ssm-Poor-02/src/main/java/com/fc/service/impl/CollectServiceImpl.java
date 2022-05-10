package com.fc.service.impl;

import com.fc.dao.CollectionMapper;
import com.fc.entity.Collection;
import com.fc.service.CollectService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectionMapper collectionMapper;


    @Override
    public ResultVo list(Integer pageNum, Integer pageSize, Long id) {
        List<Collection> collections;
        ResultVo resultVo;
        try {
            if (id == null) {
                //开启分页
                PageHelper.startPage(pageNum, pageSize);

                collections = collectionMapper.selectByExample(null);

            } else {
                Collection collection = collectionMapper.selectByPrimaryKey(id);

                collections = new ArrayList<>();

                collections.add(collection);
            }
            PageInfo<Collection> pageInfo = new PageInfo<>(collections);

            DataVo<Collection> dataVo = new DataVo<>(pageInfo.getTotal(), collections, pageNum, pageSize);

            resultVo = new ResultVo(200, "获取成功", true, dataVo);
        } catch (Exception e) {
            resultVo = new ResultVo(400, "获取失败", false, null);
        }
        return resultVo;
    }


    @Override
    public ResultVo add(Collection collection) {
        if (collection.getCreateTime() == null) {
            collection.setCreateTime(new Date());
        }
        int affect = collectionMapper.insertSelective(collection);
        ResultVo resultVo;
        if (affect > 0) {
            resultVo = new ResultVo(200, "添加成功", true, collection);
        } else {
            resultVo = new ResultVo(400, "添加失败", false, null);
        }
        return resultVo;

    }

    @Override
    public ResultVo del(Collection id) {
        int affect = collectionMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if (affect>0){
            resultVo = new ResultVo(200, "删除成功", true, null);
        }else {
            resultVo = new ResultVo(400, "删除失败", false, null);
        }
        return resultVo;

    }
}