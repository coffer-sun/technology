package com.fanpin.util;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fanpin.entity.User;
import com.fanpin.service.ILoginSvc;

/**
 * @Component <context:component-scan base-package="com.fanpin.*" />    （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
 * @Aspect 切面 作用是把当前类标识为一个切面供容器读取
 * 优先级：before优先around优先after
 * */
@Component
@Aspect
public class TransactionAdvice {
	//@Resource的作用相当于@Autowired，只不过@Autowired按byType自动注入，而@Resource默认按 byName自动注入罢了。
	@Resource
	private ILoginSvc loginSvc;
	
	//用户需要验证身份才能操作，定义切点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	//@Pointcut("execution(* com.fanpin.controller.ProductController.showphone(..))")
	public void aopCheckLogin() {}
	
	//@Before("aopCheckLogin()")
	public String before()
	{
		System.out.println("前置通知被执行！！！");
		
		HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
		HttpSession session = request.getSession();
		if(session.getAttribute("myinfo")!=null) {
			System.out.println("用户已登录！");
		}else {
			System.out.println("用户未登录！");
		}
		return null;
	}
	public void after()
	{
		System.out.println("后置通知被执行！！！（无论是否出现异常都被执行）");
	}
	public void afterReturning()
	{
		System.out.println("后置通知被执行！！！（出现异常不执行）");
	}
	public void afterException()
	{
		System.out.println("异常通知被执行！！！");
	}
	public Object around(ProceedingJoinPoint point) throws Throwable
	{
		System.out.println("环绕前执行的内容");
		Object proceed = point.proceed();
		System.out.println("环绕后执行的内容");
		return proceed;
	}

}
