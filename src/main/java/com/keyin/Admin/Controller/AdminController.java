package com.keyin.Admin.Controller;

import com.keyin.Admin.Admin;
import com.keyin.Admin.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    //    ;Repository - - - -
    @Autowired
    private AdminRepository repo;
}

