package com.fc.service;

import com.fc.entity.Carousel;
import com.fc.vo.ResultVo;

public interface CarouselService {

    ResultVo list(Integer pageNum, Integer pageSize, Long id);



    ResultVo add(Carousel carousel);

    ResultVo del(Integer id);

    ResultVo update(Carousel carousel);

    ResultVo state(Carousel id);
}
