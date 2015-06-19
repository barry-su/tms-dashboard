/**
 * Copyright (c) 2015 All Rights Reserved, ROAM Data, Inc.
 */

package com.avp.tms.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.avp.tms.dashboard.model.Greeting;
import com.avp.tms.dashboard.model.HelloMessage;
import com.avp.tms.dashboard.service.DemoAlive;
import com.avp.tms.dashboard.service.DemoStatus;

@Controller
public class TerminalStatusChangeController {
    @Autowired
    private MessageSendingOperations<String> messagingTemplate;
    
    @Autowired
    private DemoAlive demoAlive;
    
    @Autowired
    private DemoStatus demoStatus;

    private static boolean runed = false;

    synchronized private void run() {
        if (TerminalStatusChangeController.runed) {
            return;
        }
        TerminalStatusChangeController.runed = true;

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
                    smt.convertAndSend("/topic/terminal/status", demoStatus.getStatus());
                }
            }
        });
        t.start();
    }

    @MessageMapping("/terminal/status")
    @SendTo("/topic/terminal/status")
    public Greeting greeting(HelloMessage message) throws Exception {
        this.run();
        return null;
    }
}
