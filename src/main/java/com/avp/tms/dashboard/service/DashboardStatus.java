/**
 * Copyright (c) 2015 All Rights Reserved, ROAM Data, Inc.
 */
package com.avp.tms.dashboard.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.avp.tms.dashboard.model.Greeting;

@Service
public class DashboardStatus {
    public Greeting getStatus() {
        return new Greeting(0, String.valueOf(new Random().nextInt(3)));
    }
}
