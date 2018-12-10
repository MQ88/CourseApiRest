package com.ens.courseApi.CourseApi.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
	
	
	@Pointcut("execution(* com.ens.courseApi.CourseApi.Dao.*.*(..))")
	public void DaoPointcut() {
		
	}

	@Pointcut("execution(* com.ens.courseApi.CourseApi.service.*.*(..))")
	public void ServicePointcut() {
		
	}

	@Pointcut("@annotation(com.ens.courseApi.CourseApi.aspects.TimeTrack)")
	public void TimeTrack()
	{
		
	}
}
