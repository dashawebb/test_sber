package Test.task.controller;

import Test.task.config.model.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("status", createTable.createTableStatus());
        return "create";
    }



}
