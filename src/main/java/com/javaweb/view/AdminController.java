package com.javaweb.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@GetMapping("/admin/building-edit")
    public ModelAndView buildingEdit() {
        return new ModelAndView("building-edit");
    }
}
