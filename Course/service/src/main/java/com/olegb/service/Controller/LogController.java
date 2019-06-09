package com.olegb.service.Controller;

import com.olegb.service.Model.Log;
import com.olegb.service.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping
    public List<Log> getAllLogs(){

        return logService.getAllLogs();
    }

    @GetMapping("/delete")
    public void deleteLog(){
        logService.deleteLog();
    }
}
