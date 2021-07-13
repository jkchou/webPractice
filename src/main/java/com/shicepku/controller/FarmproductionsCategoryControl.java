package com.shicepku.controller;

import com.shicepku.entity.FarmproductionsCategory;
import com.shicepku.service.FarmproductionsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/FarmSchedulingCategory")
public class FarmproductionsCategoryControl {
    @Autowired
    private FarmproductionsCategoryService fcService;
    //类别 月产 季产 年产
//    @RequestMapping("/update")
//    public int  update(int id,FarmproductionsCategory farmproductionsCategory){
//        int res= fcService.FarmproductionsCategoryUpdate(farmproductionsCategory);
//        return res;
//    }
    @RequestMapping("/delectById")
    public  int delectById(int id){
        int res= fcService.FarmproductionsCategoryDeleteById(id);
        return res;
    }
    @RequestMapping("/selectAll")
    public Model selectAll(Model model){
        List<FarmproductionsCategory> farmproductionsCategoryList=fcService.FarmproductionsCategorySelectAll();
        model.addAttribute("List",farmproductionsCategoryList);
        return model;
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
}
