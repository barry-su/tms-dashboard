/**
 * Copyright (c) 2015 All Rights Reserved, ROAM Data, Inc.
 */

package com.avp.tms.dashboard.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avp.tms.dashboard.model.Greeting;
import com.avp.tms.dashboard.model.HelloMessage;
import com.avp.tms.dashboard.service.DashboardStatus;

@Controller
public class DashboardController {
    @Autowired
    private MessageSendingOperations<String> messagingTemplate;
    
    @Autowired
    private MessageSource messageSource;
    
    @Autowired
    private DashboardStatus dashboardStatus;
    
    private static boolean runed = false;

    @RequestMapping("/dashboard")
    public String index(Model model, Locale local) {
        
        return "dashboard";
    }
    
    @RequestMapping("/dashboardHistory")
    public String history(Model model, Locale local) {
        
        return "dashboard_history";
    }
    
    synchronized private void run() {
        if (DashboardController.runed) {
            return;
        }
        DashboardController.runed = true;

        final MessageSendingOperations<String> smt = this.messagingTemplate;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    smt.convertAndSend("/topic/terminal/changestatus", dashboardStatus.getStatus());
                }
            }
        });
        t.start();
    }

    @MessageMapping("/changestatus")
    @SendTo("/topic/terminal/changestatus")
    public Greeting greeting() throws Exception {
        this.run();
        return null;
    }
}
