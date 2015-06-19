/**
 * Copyright (c) 2015 All Rights Reserved, ROAM Data, Inc.
 */

package com.avp.tms.dashboard.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlarmController {
    
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/alarmManagement")
    public String index(Model model, Locale local) {
        
        return "alarm_management";
    }
    
    @RequestMapping("/alarmCreation")
    public String create(Model model, Locale local) {
        
        return "alarm_creation";
    }
    
    @RequestMapping("/alarmEdit")
    public String edit(Model model, Locale local) {
        
        return "alarm_edit";
    }
}
