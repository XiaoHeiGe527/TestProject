package com.dmm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DMM
 * @create 2019/7/24
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String show(Model model){

        model.addAttribute("name","力王");

        return "index";
    }
    @RequestMapping("/up")
    public String ff(){
       return "up";
    }

    @RequestMapping("/tableColumns")
    public String tableColumns(Model model){

        model.addAttribute("aa",get2());
        model.addAttribute("fenDatas",get());

        return "tableColumns";
    }

    public List<Map> get(){

        List<Map> list=new ArrayList<>();

        for(int i=0;i<100;i++){
            List<String> list1=get2();

            Map map=new HashMap();

            for (int j=0;j<get2().size();j++){

                map.put(list1.get(j),"杜明明--->"+i+"<------>"+j);

            }

            list.add(map);
        }
        return list;
    }

    public List<String> get2(){

        List<String> list=new ArrayList();
        for(int i=0;i<20;i++){
            list.add("曹艳涛喜欢玩女人，玩的自己都知道是谁的"+i);
        }
        return list;
    }



}

