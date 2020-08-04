package Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath*:Bean.xml");
                Calls calls = (Calls) context.getBean("calls");
                calls.setCalls("Hey");
        System.out.println(calls.getCalls());
    }
}
