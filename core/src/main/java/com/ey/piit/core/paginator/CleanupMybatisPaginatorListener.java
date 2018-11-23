package com.ey.piit.core.paginator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ey.piit.core.paginator.OffsetLimitInterceptor;

/**
 *
 */
public class CleanupMybatisPaginatorListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        OffsetLimitInterceptor.Pool.shutdownNow();
    }
}
