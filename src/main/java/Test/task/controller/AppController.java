package Test.task.controller;

import Test.task.config.model.CreateTable;
import Test.task.config.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {

    //http://localhost:8080/
//     public String hello(Model model){
//        model.addAttribute("hello", "My first spring application");
//        return "index";
//    }
    @Autowired
    private CreateTable createTable;

    @RequestMapping("/")
    public String createTableStatus(Model model) {
//        model.addAttribute("status", createTable.createTableStatus());
        createTable.createTableStatus();
        createTable.insertIntoTableRow1();
        createTable.insertIntoTableRow2();
        createTable.insertIntoTableRow3();
        List<Order> orders = createTable.select();
        model.addAttribute("row_00", "Article Name Shelf Box");
        model.addAttribute("row_01", orders.get(0).toString());
        model.addAttribute("row_02", orders.get(1).toString());
        model.addAttribute("row_03", orders.get(2).toString());


        return "index";
    }



}
