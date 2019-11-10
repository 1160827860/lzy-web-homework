package com.darksouls.controller;

import com.darksouls.entity.task;
import com.darksouls.service.TaskService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.HTML;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static javafx.application.ConditionalFeature.WEB;


@Controller
@RequestMapping("/ITKIM/order/")
public class TaskController {

    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //    @RequestMapping("/ITKIM/orders/assignList")
//    public String taskController() throws ParseException, JsonProcessingException {
//        ResonbodyData ResonbodyData = new ResonbodyData();
//        ResonbodyData.setTotal(1);
//        task one =new task();
//
////        one.setTitle("aaaa");
////        one.setAllfilepath("adfasfsdgfssgd");
////        one.setDevprice(400);
////        one.setDevremark("备注");
////        one.setOrdertag("c++");
////        one.setDocfilepath("asdsafsdgfdgfd");
////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
////        one.setGmtCreate(dateFormat.parse("2018-03-21"));
////        one.getGmtdue(dateFormat.parse("2018-03-21"));
////        one.setId(2048);
////        one.setOrderstatus("未完成");
////        one.setRequirement("为了完成基本数据");
////        one.setRequiretype("基本数据");
////        one.setPickflag(0);
//        ArrayList<task> data1 =new ArrayList<task>();
//        data1.add(one);
//
//        ResonbodyData.setData(data1);
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH"));
//
//        String json = objectMapper.writeValueAsString(ResonbodyData);
//        System.out.println(json);
//        return json;
//    }

    @RequestMapping(value = "create",method = RequestMethod.POST,produces={"text/html;charset=UTF-8;","application/json;"})
    public String order_create(@ModelAttribute task order, HttpServletRequest request) throws JsonProcessingException {

        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String rootpath =   request.getSession().getServletContext().getRealPath("/").replace("/","\\")+ "/update/" + uuid+"/";

        order.setOrder_release_time(new java.sql.Date(System.currentTimeMillis()));

        if (order.isDocEmpty()){

            if(order.isPathEmpty()){
                order.setOrder_doc(null);
                order.setOrder_attachment(null);
            }else {

                File f = new File(rootpath);
                if(!f.exists()){
                    f.mkdir();
                }
                String pathName = order.getAttachment().getOriginalFilename();
                order.setOrder_attachment(uuid+"/"+pathName);
                try {
                    order.getAttachment().transferTo(new File(rootpath+pathName));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }else {
            File f = new File(rootpath);
            if(!f.exists()){
                f.mkdir();
            }
            if(order.isPathEmpty()){
                String docName = order.getDoc().getOriginalFilename();
                order.setOrder_doc(uuid+"/"+docName);
                try {
                    order.getDoc().transferTo(new File(rootpath+docName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                String docName = order.getDoc().getOriginalFilename();
                order.setOrder_doc(uuid+"/"+docName);
                String pathName = order.getAttachment().getOriginalFilename();
                order.setOrder_attachment(uuid+"/"+pathName);
                try {
                    order.getDoc().transferTo(new File(rootpath+docName));
                    order.getAttachment().transferTo(new File(rootpath+pathName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        order.setOrder_status("未完成");



        if(taskService.tast_insert(order)==1){
            return "success";
        }else{
            return "error";
        }

    }

}
