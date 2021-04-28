package cs544.exercise13_1;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class CustomerAdvise {

	@After("execution(* cs544.exercise13_1.EmailSender.sendEmail(..)) && args(email,message)")
	public void afterAdvice(JoinPoint joinpoint, String email, String message) {
		System.out.printf("%s Method =%s parameter address =%s message= %s\n", new Date(),
				joinpoint.getSignature().getName(), email, message);
		System.out.println(((EmailSender) joinpoint.getTarget()).getOutgoingMailServer());
	}

	@Around("execution(* cs544.exercise13_1.CustomerDAO.*(..))")
	public Object invoke(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();

		long totaltime = sw.getLastTaskTimeMillis();
		// print the time to the console
		System.out.println("Time to execute " + call.getSignature().getName() +" = "+ totaltime + " ms");
		return retVal;
	}

}
