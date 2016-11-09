package org.sean.web;

import org.sean.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sean.W on 2016/11/9.
 */
@RestController
public class StudentController {
    @Autowired
    private BlogService blogService;


}
