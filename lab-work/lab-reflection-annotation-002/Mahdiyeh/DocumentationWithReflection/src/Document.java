import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Retention(RetentionPolicy.RUNTIME)
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD,ElementType.FIELD })
public @interface Document {
    String Description();
    String ReturnType();
}


