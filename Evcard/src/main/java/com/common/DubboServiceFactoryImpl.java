/*
package com.common;

import com.dianping.dpsf.api.ProxyFactory;
import org.apache.commons.lang.StringUtils;

*/
/**
 * Created by jinwei on 8/3/17.
 *//*

public class DubboServiceFactoryImpl<T> implements DubboServiceFactory {

    private Class<T> serviceClass;

    public DubboServiceFactoryImpl(Class<T> tClass) {
        serviceClass = tClass;
    }

    @Override
    public T getService(String serviceName) {
        return getRemoteService(serviceName, "hessian", "sync", 8000);
    }

    public T getRemoteService(String serviceName, String serialize, String callMethod, int timeout) {
        T proxy = null;
        if (StringUtils.isEmpty(serviceName) || StringUtils.isEmpty(serialize) ||
                StringUtils.isEmpty(callMethod)) {
            System.err.println("parameter is empty.");
            return proxy;
        }

        ProxyFactory<T> proxyFactory = new ProxyFactory<T>();

        proxyFactory.setIface(serviceClass);
        proxyFactory.setServiceName(serviceName);
        proxyFactory.setSerialize(serialize);
        proxyFactory.setCallMethod(callMethod);
        proxyFactory.setTimeout(timeout);
        try {
            proxyFactory.init();
            proxy = proxyFactory.getProxy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proxy;
    }

}
*/
