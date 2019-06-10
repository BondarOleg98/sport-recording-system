package com.olegb.client.Controller;

import com.olegb.client.Client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private RestClient restClient;

    @GetMapping
    public ModelAndView getAllLogs(){
        ModelAndView model = new ModelAndView("Log.jsp");
        model.addObject("ListLog",restClient.getAllLogs());
        return model;
    }
    @GetMapping("/delete")
    public ModelAndView deleteLog() {
        restClient.deleteLog();
        return new ModelAndView("redirect:/log");
    }
}
