/**
 * Copyright (c) 2015 All Rights Reserved, ROAM Data, Inc.
 */

package com.avp.tms.dashboard.service;

import org.springframework.stereotype.Service;

import com.avp.tms.dashboard.model.Greeting;

@Service
public class DemoAlive {
    public Greeting getStatus() {
        return new Greeting(0, "Alive");
    }
}
