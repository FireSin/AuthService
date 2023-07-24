package monitoring;

import org.springframework.stereotype.Component;

@Component("CLS")
public class Cls {
    @monitoring.annotation.Monitoring
    public void meth(){

    }
}
