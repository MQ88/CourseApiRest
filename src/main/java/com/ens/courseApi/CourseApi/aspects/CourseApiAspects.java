package com.ens.courseApi.CourseApi.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CourseApiAspects {
	
	Logger log=LoggerFactory.getLogger(CourseApiAspects.class);
	
	@Before("com.ens.courseApi.CourseApi.aspects.Pointcuts.DaoPointcut()")
	public void BeforeDAo(JoinPoint jp)
	{
		log.info("Before Excution of Dao{}",jp);
	}
	
	@After("com.ens.courseApi.CourseApi.aspects.Pointcuts.DaoPointcut()")
	public void AftereDAo(JoinPoint jp)
	{
		log.info("After Excution of Dao{}",jp);
	}
	
	@Before("com.ens.courseApi.CourseApi.aspects.Pointcuts.ServicePointcut()")
	public void BeforeService(JoinPoint jp)
	{
		log.debug("After Excution of Service{}",jp);
	}
	
	@After("com.ens.courseApi.CourseApi.aspects.Pointcuts.ServicePointcut()")
	public void AfterService(JoinPoint jp)
	{
		log.debug("After Excution of Service{}",jp);
	}
	
	@Around("com.ens.courseApi.CourseApi.aspects.Pointcuts.TimeTrack()")
	public Object TrackTime(ProceedingJoinPoint pjp) throws Throwable
	{
		Object o=null;
	  long startTime=System.currentTimeMillis();
	  try {
		o=pjp.proceed();
	} catch (Throwable e) {
		e.printStackTrace();
		throw e;
	}
	  log.info("Method |{}| took time in millsecs : {}",pjp.toShortString(),(System.currentTimeMillis()-startTime));
	  return o;
	}
}
