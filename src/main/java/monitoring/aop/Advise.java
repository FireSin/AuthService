package monitoring.aop;

import lombok.NoArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Aspect
@Component
@NoArgsConstructor
public class Advise {
    private static final String LOG_FILENAME = "monitoring-log.txt";

    @Around("@annotation(monitoring.annotation.Monitoring)")
    public Object countExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        Signature signature = proceedingJoinPoint.getSignature();

        String pack = signature.getDeclaringTypeName();
        String method = signature.getName();
        String prefix = (pack.length() != 0) ?
                pack + "." + method :
                method;

        toFile(
                prefix +
                ": " +
                toTimeString(endTime - startTime)
        );

        return object;
    }

    private void toFile(String msg){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILENAME, true))){
            writer.write(msg);
            writer.write("\n");
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
    private String toTimeString(long millis){
        return millis + " ms";
    }

}
