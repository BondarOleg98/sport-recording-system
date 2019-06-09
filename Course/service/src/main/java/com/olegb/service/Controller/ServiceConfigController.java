package com.olegb.service.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@RestController
public class ServiceConfigController {

    @Value("${app.service-name}")
    private String serviceName;

    @GetMapping("/service")
    public String getServiceColor() {
        return this.serviceName;
    }

}
