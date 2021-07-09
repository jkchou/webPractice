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
    @RequestMapping("/selectAll")
    @ResponseBody
    public String selectAll(Model model){
        List<FarmproductionsCategory> farmproductionsCategoryList=fcService.FarmproductionsCategorySelectAll();
        model.addAttribute("List",farmproductionsCategoryList);
        return model.toString();
    }
    @RequestMapping("/selectById")
    @ResponseBody
    public String selectById(int id){
        FarmproductionsCategory farmproductionsCategory=fcService.FarmproductionsCategorySelectById(1);
        return farmproductionsCategory.toString();
    }
}
