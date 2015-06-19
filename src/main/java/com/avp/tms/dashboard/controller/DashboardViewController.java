/**
 * Copyright (c) 2015 All Rights Reserved, ROAM Data, Inc.
 */
package com.avp.tms.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avp.tms.dashboard.model.EstateTreeNode;
import com.avp.tms.dashboard.model.RestReturn;
import com.avp.tms.dashboard.model.SeverityQuantity;
import com.avp.tms.dashboard.model.Status;
import com.avp.tms.dashboard.model.Terminal;



@RestController
@RequestMapping("/dashboard")
public class DashboardViewController {

    /**
     * When the user opens the Dashboard view, get the terminal information
     * based on the login information. (session)
     * 
     * @return EstateTreeNode is a recursive node that contains information
     *         of all the Estates and Terminals.
     * 
     */
//    @CallPrologue
    // need to send to specific message broker????????
    // @SendTo("/status/")
    @RequestMapping(value = "/estate", method = RequestMethod.GET)
    public EstateTreeNode getEstateTree() {
        EstateTreeNode estateTreeNode=new EstateTreeNode();
        return estateTreeNode;

    }

    /**
     * We provide status for each terminal in all estates that we display.
     * 
     * @return
     *
     */
    @MessageMapping("/status")
    @SendTo("/terminal/status")
    public List<Status> getTerminalStatus() {
        List<Status> status=new ArrayList<>();
        return status;
    }
    
    
    @RequestMapping(value = "/terminal/realTime", method = RequestMethod.GET)
    public RestReturn<Terminal> findRealTimeTerminalsByCondition(
            @RequestParam(value = "store", required = false) String store,
            @RequestParam(value = "severity", required = false) String severity,
            @RequestParam(value = "eventType", required = false) String eventType,
            @RequestParam(value = "event", required = false) String event,
            @RequestParam(value = "terminal", required = false) String terminal
          ){
        RestReturn<Terminal> restReturn=new RestReturn<>();
        
        return restReturn;
    }
    
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/terminal/realTime", method = RequestMethod.PUT)
    public RestReturn realTimeTerminalAlertOperation(
            @RequestParam(value = "flag", required = false) String flag,
            @RequestParam(value = "alertId", required = false) String alertId
            ){
        RestReturn restReturn=new RestReturn();
        return restReturn;
    }
    
    @RequestMapping(value = "/terminal/realTime/SeverityQuantity", method = RequestMethod.GET)
    public RestReturn<SeverityQuantity> getRealTimeSeverityQuantity(
            @RequestParam(value = "store", required = false) String store
            ){
        RestReturn<SeverityQuantity> restReturn=new RestReturn<>();
        return restReturn;
    }
    
    @RequestMapping(value = "/terminal/history", method = RequestMethod.GET)
    public RestReturn<Terminal> findHistoryTerminalsByCondition(
            @RequestParam(value = "dateFrom", required = false) String dateFrom,
            @RequestParam(value = "dateTo", required = false) String dateTo,
            @RequestParam(value = "store", required = false) String store,
            @RequestParam(value = "severity", required = false) String severity,
            @RequestParam(value = "eventType", required = false) String eventType,
            @RequestParam(value = "event", required = false) String event,
            @RequestParam(value = "terminal", required = false) String terminal
          ){
        RestReturn<Terminal> restReturn=new RestReturn<>();
        return restReturn;
    }
    
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/terminal/history", method = RequestMethod.PUT)
    public RestReturn historyTerminalAlertOperation(
            @RequestParam(value = "flag", required = false) String flag,
            @RequestParam(value = "alertId", required = false) String alertId
            ){
        RestReturn restReturn=new RestReturn();
        return restReturn;
    }
    
    @RequestMapping(value = "/terminal/history/SeverityQuantity", method = RequestMethod.GET)
    public RestReturn<SeverityQuantity> getHistorySeverityQuantity(
        @RequestParam(value = "store", required = false) String store
        ){
        RestReturn<SeverityQuantity> restReturn=new RestReturn<>();
         return restReturn;
    }
    

}