package com.shicepku.controller;

import com.alibaba.fastjson.JSON;
import com.shicepku.entity.FarmproductionsCategory;
import com.shicepku.entity.Scheduling;
import com.shicepku.entity.Variety;
import com.shicepku.service.FarmproductionsCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/FarmSchedulingCategory")
public class FarmproductionsCategoryControl {
    @Autowired
    private FarmproductionsCategoryService fcService;
    //类别 月产 季产 年产
    @RequestMapping("/updateCategory")
    public void update(@ModelAttribute FarmproductionsCategory farmproductionsCategory){
        System.out.println("进入update方法");
        System.out.println(farmproductionsCategory.getName());
        System.out.println(farmproductionsCategory.getCreateBy());
        System.out.println(farmproductionsCategory.getYlut());
    }
    @RequestMapping("/delectById")
    public  int delectById(int id){
        int res= fcService.FarmproductionsCategoryDeleteById(id);
        return res;
    }
    @RequestMapping("/selectAll")
    public ModelAndView selectAll(Model model){
        List<FarmproductionsCategory> farmproductionsCategoryList=fcService.FarmproductionsCategorySelectAll();
        model.addAttribute("List",farmproductionsCategoryList);
        model.addAttribute("FarmproductionsCategory",new FarmproductionsCategory());
        return new ModelAndView("/category/farmschedulingcategory");
    }
    @RequestMapping("/selectById")
    public FarmproductionsCategory selectById(int id){
        FarmproductionsCategory farmproductionsCategory=fcService.FarmproductionsCategorySelectById(id);
        return farmproductionsCategory;
    }
    @RequestMapping("/insertCategory")
    public int insertCategory(FarmproductionsCategory farmproductionsCategory){
        int res= fcService.FarmproductionsCategoryInsert(farmproductionsCategory);
        return res;
    }

    //zxh
    @RequestMapping("/update")
    public void update(@RequestParam(name = "leibie") String name,
                      @RequestParam(name = "yuechan") String yuechan){
        log.debug("{}",name);
        log.debug("{}",yuechan);
        //return 0;
    }
    @RequestMapping(value = "/getScheduling",method = RequestMethod.POST)
    @ResponseBody
    public List<Variety> getScheduling(Model model, String category){
//        List<Scheduling> schedulingList=fcService.farmproductionsCategorySelectVariety(category);
//        model.addAttribute("schedulingList",schedulingList);
//        return "/category/farmschedulingcategory::scheduling_list";
        List<Variety> varietyList=fcService.farmproductionsCategorySelectVariety(category);
        model.addAttribute("categorylist", varietyList);
       // return "/category/farmschedulingcategory::categorylist";
        return varietyList;
    }
}
