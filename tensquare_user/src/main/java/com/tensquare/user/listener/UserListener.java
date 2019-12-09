package com.tensquare.user.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@WebListener
@Slf4j
public class UserListener implements ServletContextListener, ServletRequestListener {

    @Override
    public void contextInitialized(ServletContextEvent servletRequestEvent) {
        log.info("UserListener contextInitialized ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletRequestEvent) {
        log.info("UserListener contextDestroyed ");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request=(HttpServletRequest)servletRequestEvent.getServletRequest();
        log.info("开始--新的请求被创建了："+request.getRequestURL()+"   method: "+request.getMethod() + "remoteAddr  " + request.getRemoteAddr() + " remodeHost " + request.getRemoteHost());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        log.info("UserListener requestDestroyed ");
    }
}
