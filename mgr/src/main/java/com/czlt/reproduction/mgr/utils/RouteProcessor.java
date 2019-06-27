package com.czlt.reproduction.mgr.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

@Component
public final class RouteProcessor implements BeanPostProcessor {
    private static ConcurrentHashMap<String, String> routeMap = new ConcurrentHashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class clazz = bean.getClass();
        Service service = (Service) clazz.getAnnotation(Service.class);
        if (service != null) {
            Method[] methods = clazz.getMethods();
            if (methods != null) {
                for (Method method : methods) {
                    Route route = method.getAnnotation(Route.class);
                    if (route != null) {
                        routeMap.put(beanName + "-" + route.value(), method.getName());
                    }
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public static String getMethodByRoute(String routeLevel1, String routeLevel2) {
        String methodName = "";
        if (StringUtils.isNotBlank(routeLevel1) && StringUtils.isNotBlank(routeLevel2)) {
            methodName = routeMap.get(routeLevel1 + "-" + routeLevel2);
        }
        return methodName;
    }
}
