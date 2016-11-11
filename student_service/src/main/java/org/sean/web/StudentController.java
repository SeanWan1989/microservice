package org.sean.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.sean.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sean.W on 2016/11/9.
 */
@RestController
public class StudentController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/blog")
    @HystrixCommand(fallbackMethod = "defaultfallback",commandKey = "blogGroup",groupKey = "blog")
    public String blog(){
        return blogService.show("1");
    }

    @RequestMapping("/blog1")
    @HystrixCommand(fallbackMethod = "defaultfallback",commandKey = "blogGroup",groupKey = "blog1",commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
    })
    public String blog1(){
        return blogService.show("1");
    }

    public String defaultfallback(){
        return "失败了进入降级方法！";
    }
}
