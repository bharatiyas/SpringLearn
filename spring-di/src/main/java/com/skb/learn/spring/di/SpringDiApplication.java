package com.skb.learn.spring.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.skb.learn.spring.di.controller.ConstructorInjectedController;
import com.skb.learn.spring.di.controller.MyController;
import com.skb.learn.spring.di.controller.PropertyInjectedController;
import com.skb.learn.spring.di.controller.SetterInjectedController;
import com.skb.learn.spring.di.property.CustomPropsInApplicationProperties;
import com.skb.learn.spring.di.property.CustomPropsInApplicationYaml;
import com.skb.learn.spring.di.property.FakeDataSource;
import com.skb.learn.spring.di.property.FakeJmsBroker;

@SpringBootApplication
public class SpringDiApplication {

	public static void main(String[] args) {
		// run() returns an ApplicationContext to work with
		ApplicationContext ctx = SpringApplication.run(SpringDiApplication.class, args);
		
		// By default Spring creates a bean with a name starting with class name starting with leading lower case char.
		// Since it is strogly typed hence we need to type cast it
		// We are not using 'new' operator to get an instance
		MyController controller = (MyController) ctx.getBean("myController");
		
		controller.sayHello();
		
		//System.out.println("PropertyInjectedController - " + ctx.getBean(PropertyInjectedController.class).sayHello());
		//System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
		
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println("DB Password = " + fakeDataSource.getPassword());
		
		FakeJmsBroker fakeJmsBroker = ctx.getBean(FakeJmsBroker.class);
		System.out.println("JMS Password = " + fakeJmsBroker.getPassword());
		
		CustomPropsInApplicationProperties customProps = ctx.getBean(CustomPropsInApplicationProperties.class);
		System.out.println("First Name = " + customProps.getFirstName());
		
		CustomPropsInApplicationYaml customPropsYaml = ctx.getBean(CustomPropsInApplicationYaml.class);
		System.out.println("YAML First Name = " + customPropsYaml.getFirstName());
		
	}
}
