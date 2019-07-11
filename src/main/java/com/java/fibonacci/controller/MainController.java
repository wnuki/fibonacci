package com.java.fibonacci.controller;

import com.java.fibonacci.model.OperationModel;
import com.java.fibonacci.service.FastFibonacci;
import com.java.fibonacci.service.IterativeFibonacci;
import com.java.fibonacci.service.RecursiveFibonacci;
import com.java.fibonacci.service.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    OperationModel operationModel = new OperationModel();

    @Autowired
    RecursiveFibonacci recursiveFibonacci;

    @Autowired
    IterativeFibonacci iterativeFibonacci;

    @Autowired
    FastFibonacci fastFibonacci;

    @Autowired
    Time time;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("operationModel", operationModel);
        return "index";
    }

    @PostMapping(value = "/", params = "n")
    public String recursive(@ModelAttribute("operationModel") OperationModel operationModel, Model model) {
        model.addAttribute("rResult", recursiveFibonacci.computeFib(operationModel));
        model.addAttribute("iResult", iterativeFibonacci.computeFib(operationModel));
        model.addAttribute("fResult", fastFibonacci.computeFib(operationModel));
        model.addAttribute("rTime", time.recursiveTime() + " ms");
        model.addAttribute("iTime", time.iterativeTime() + " ms");
        model.addAttribute("fTime", time.fastTime() + " ms");
        return "index";
    }
}
