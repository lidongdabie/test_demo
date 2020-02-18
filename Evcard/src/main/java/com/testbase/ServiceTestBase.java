/*
package com.testbase;

import com.common.DubboServiceFactory;
import com.common.ServiceFactory;
import com.datadriver.AutoDataDriverBase;

import java.lang.reflect.ParameterizedType;

*/
/**
 * Created by yamimasho on 8/8/16.
 *//*

public abstract class ServiceTestBase<T>   extends AutoDataDriverBase {
    protected T service;
    protected String serviceName;

    public ServiceTestBase(String serviceName) {
        try {
            this.serviceName = serviceName;
            System.out.println("开始初始化远程Dubbo服务连接：" + serviceName);
            DubboServiceFactory<T> factory = ServiceFactory.newDubboInstance(getType());
            service = factory.getService(serviceName);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private Class getType(){
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
        return (Class) type.getActualTypeArguments()[0];
    }
}
*/
