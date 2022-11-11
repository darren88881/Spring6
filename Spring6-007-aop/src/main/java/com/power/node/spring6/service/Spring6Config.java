package com.power.node.spring6.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @Author darren
 * @Date 2022/11/11 10:59
 */
@Configuration
@ComponentScan({"com.power.node.spring6.service"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Spring6Config {
}
