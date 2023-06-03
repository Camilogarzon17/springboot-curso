package com.fundamentos.srpingboot.fundamentos;

import com.fundamentos.srpingboot.fundamentos.bean.*;
import com.fundamentos.srpingboot.fundamentos.component.ComponentDependency;
import com.fundamentos.srpingboot.fundamentos.component.ComponentTwoImplement;
import com.fundamentos.srpingboot.fundamentos.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {  //dependedncia inyectada

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWhitProperties myBeanWhitProperties;
	private UserPojo userPojo;
	public FundamentosApplication(@Qualifier("componentTwoImplement")ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWhitProperties myBeanWhitProperties, UserPojo userPojo){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWhitProperties = myBeanWhitProperties;
		this.userPojo = userPojo;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { //dependencia utilizada dentro de otro objeto
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWhitProperties.function());;
		System.out.println(userPojo.getEmail() +"-" + userPojo.getPassword() +"-"+ userPojo.getAge());
		try{
			//error
			int value = 10 / 0;
			LOGGER.debug("my value " + value);
		}catch (Exception e){
			LOGGER.error("This error aplication the division whit 0"+ e.getMessage());
		}

	}
}
