package com.fundamentos.srpingboot.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements  MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

     private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("we have entered the method printWithDependency ");
        int number = 1;
        LOGGER.debug(" number sent as a parameter to the operation is: " + number);
        System.out.println("result: " + myOperation.sum(number));
        System.out.println("Hello world from the implementation of a good with dependency");
    }
}
