package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carousel")
@CrossOrigin("*")
public class CarouselController {
   @Autowired
   private CarouselService carouselService;
   @GetMapping("getlist")
   public ResultVo list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum , @RequestParam(value = "pageSize",defaultValue = "1") Integer pageSize, Long id) {
      return carouselService.list(pageNum,pageSize,id);
   }
   @PostMapping("add")
  public ResultVo add(@RequestBody Carousel carousel){
      return carouselService.add(carousel);
  }
  @GetMapping("delete")
  public ResultVo del(Integer id){
       return carouselService.del(id);
  }
  @PostMapping("update")
  public ResultVo update(@RequestBody Carousel carousel){
       return carouselService.update(carousel);
  }
  @PostMapping("state")
  public ResultVo state(@RequestBody Carousel id){
       return carouselService.state(id);
  }
   }

