/**
 * Copyright (c) 2015 All Rights Reserved, ROAM Data, Inc.
 */

package com.avp.tms.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@ImportResource("classpath:config/spring-context.xml")
@ComponentScan(basePackages = { "com.avp.tms.dashboard" }, includeFilters = @ComponentScan.Filter(value = Component.class, type = FilterType.ANNOTATION))
@SpringBootApplication
public class TMSDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(TMSDashboardApplication.class, args);
    }
}
