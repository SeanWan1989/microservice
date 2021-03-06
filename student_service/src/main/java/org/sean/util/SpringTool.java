package org.sean.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class SpringTool implements ApplicationContextAware {

     private static ApplicationContext applicationContext; // Spring应用上下文环境

     public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    	 SpringTool.applicationContext = applicationContext;
     }
 
     public static ApplicationContext getApplicationContext() {
            return applicationContext;
     }

      @SuppressWarnings("unchecked")
      public static <T> T getBean(String name) throws BeansException {
    	  return (T) applicationContext.getBean(name);
      }
}
