package com.keyin.Gate.Controller;

import com.keyin.Gate.Gate;
import com.keyin.Gate.Repository.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/gate")
public class GateController {

//    ;Repository - - - -
    @Autowired
    private GateRepository repo;
}
