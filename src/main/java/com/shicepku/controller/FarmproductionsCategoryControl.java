package com.shicepku.controller;

import com.shicepku.entity.FarmproductionsCategory;
import com.shicepku.entity.Variety;
import com.shicepku.service.FarmproductionsCategoryService;
import com.shicepku.service.VarietyService;
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
    private VarietyService vrService;
    @RequestMapping("/insertVariety")
    public String insert(@ModelAttribute Variety Variety){
        System.out.println("进入insert方法");
                System.out.println(Variety.toString());
        int res=vrService.insert(Variety);
//        System.out.println(Variety.getName());
//        System.out.println(Variety.getGrowthCycle());
//        System.out.println(Variety.getYlut());
//        System.out.println(Variety.getMatureIn());
//        System.out.println(Variety.getRemarks());
//        System.out.println(Variety.getCategory());
        return "redirect:/FarmSchedulingCategory/selectAll";
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
        model.addAttribute("Variety",new Variety());
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
//    @RequestMapping("/update")
//    public void update(@RequestParam(name = "leibie") String name,
//                      @RequestParam(name = "yuechan") String yuechan){
//        log.debug("{}",name);
//        log.debug("{}",yuechan);
//        //return 0;
//    }
    @RequestMapping(value = "/getScheduling",method = RequestMethod.POST)
//    @ResponseBody
    public String getScheduling(Model model, String category){
        List<Variety> schedulingList=fcService.farmproductionsCategorySelectVariety(category);
        model.addAttribute("categorylists", schedulingList);
       return "/category/farmschedulingcategory::category_list";
//        return schedulingList;
    }
    @RequestMapping(value = "/deleteVariety",method = RequestMethod.POST)
    public String deleteVariety(String varietyName){
//        System.out.println(varietyName);
        int res= fcService.deleteByVarietyName(varietyName);
        return "redirect:/FarmSchedulingCategory/selectAll";
    }
    @RequestMapping(value = "/deleteCategory",method = RequestMethod.POST)
    public String deleteCategory(String categoryName){
//        System.out.println(categoryName);
        int res= fcService.deleteByCategoryName(categoryName);
        System.out.println(res);
        return "redirect:/FarmSchedulingCategory/selectAll";
    }
    @RequestMapping( "/searchCategory")
    public ModelAndView searchCategory(Model model,@RequestParam(value = "categoryName") String category_name) {
        List<FarmproductionsCategory> farmproductionsCategoryList=fcService.FarmproductionsCategorySearch(category_name);
        System.out.println(category_name);
//        System.out.println(farmproductionsCategoryList.toString());
        model.addAttribute("List",farmproductionsCategoryList);
        model.addAttribute("Variety",new Variety());
        return new ModelAndView("/category/farmschedulingcategory");
//        return new ModelAndView("/category/farmschedulingcategory");
    }
}
