package com.shicepku.controller;

import com.shicepku.entity.FarmproductionsCategory;
import com.shicepku.entity.Variety;
import com.shicepku.service.FarmproductionsCategoryService;
import com.shicepku.service.VarietyService;
import com.shicepku.utils.ImageUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/FarmSchedulingCategory")
public class FarmproductionsCategoryControl {
    @Autowired
    private FarmproductionsCategoryService fcService;
    @Autowired
    private VarietyService vrService;
    @RequestMapping("/insertVariety")
    public String insert(@ModelAttribute Variety Variety){
        System.out.println("进入insert方法");
        int res=vrService.insert(Variety);
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
    /*@RequestMapping("/updateCategory")
    public  String updateCategory(@ModelAttribute FarmproductionsCategory farmproductionsCategory){
        System.out.println(farmproductionsCategory.getYlut());
        System.out.println(farmproductionsCategory.getName());
        return "redirect:/FarmSchedulingCategory/selectAll";
    }*/

    @Autowired
    ImageUpload imageUpload;

    @RequestMapping(value = "/updateCategory",method = RequestMethod.POST)
    public String updateVariety(String createDate, String edescribe, Double ylut, String name, String imgPath){
        FarmproductionsCategory category = new FarmproductionsCategory();
        Timestamp date = Timestamp.valueOf(createDate);
        category.setCreateDate(date);
        category.setEdescribe(edescribe);
        category.setYlut(ylut);
        category.setName(name);
        category.setPicture(imgPath);
        category.setDelFlag(1);
        fcService.updateByName(category);
        System.out.println(date);
        System.out.println(edescribe);
        System.out.println(ylut);
        System.out.println(name);
        System.out.println(imgPath);
        return "redirect:/FarmSchedulingCategory/selectAll";
    }

   /* public static java.sql.Date strToDate(String strDate) {
        String str = strDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");
        java.util.Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
        return date;
    }*/
}
