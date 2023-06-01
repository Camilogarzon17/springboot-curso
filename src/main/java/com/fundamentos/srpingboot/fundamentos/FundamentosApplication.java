package com.fundamentos.srpingboot.fundamentos;

import com.fundamentos.srpingboot.fundamentos.bean.*;
import com.fundamentos.srpingboot.fundamentos.component.ComponentDependency;
import com.fundamentos.srpingboot.fundamentos.component.ComponentTwoImplement;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {  //dependedncia inyectada

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	public FundamentosApplication(@Qualifier("componentTwoImplement")ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { //dependencia utilizada dentro de otro objeto
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
	}
}
