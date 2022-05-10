package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
@Autowired
    private CarouselMapper carouselMapper;
    @Override
    public ResultVo list(Integer pageNum, Integer pageSize, Long id) {
        //
        List<Carousel> carousels;
        ResultVo resultVo;
        try {
            if (id==null){
                //开启分页
                PageHelper.startPage(pageNum,pageSize);

                carousels=carouselMapper.selectByExample(null);
            }else {
                Carousel result = carouselMapper.selectByPrimaryKey(id);
                //把查到的id存到list
                carousels=new ArrayList<>();
                carousels.add(result);
            }
            PageInfo<Carousel> pageInfo = new PageInfo<>(carousels);
            DataVo<Carousel> dataVo = new DataVo<Carousel>(pageInfo.getTotal(),carousels,pageNum,pageSize);

            resultVo = new ResultVo(200, "查询成功", true, dataVo);

        }catch (Exception e){
            resultVo = new ResultVo(400, "失败", false, null);
        }


        return resultVo;

    }

    @Override
    public ResultVo add(Carousel carousel) {
        if (carousel.getAvailable()==null){
            carousel.setAvailable(false);
        }
        int affect = carouselMapper.insertSelective(carousel);
        ResultVo resultVo;
        if (affect>0){
            resultVo=new ResultVo(200,"添加成功",true,carousel);
        }else {
            resultVo=new ResultVo(400,"添加失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo del(Integer id) {
        int affect = carouselMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if (affect>0){
            resultVo=new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo=new ResultVo(400,"删除失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo update(Carousel carousel) {
        int affect = carouselMapper.updateByPrimaryKeySelective(carousel);
        ResultVo resultVo;

        if (affect>0){
            resultVo=new ResultVo(200,"用户修改成功",true,carousel);
        }else {
            resultVo=new ResultVo(400,"用户修改失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo state(Carousel id) {
        int affect = carouselMapper.state(id);
        ResultVo resultVo;
        if (affect>0){
            resultVo=new ResultVo(200,"设置成功",true,"");
        }else {
            resultVo=new ResultVo(400,"设置失败",false,null);
        }

return resultVo;
    }

}
