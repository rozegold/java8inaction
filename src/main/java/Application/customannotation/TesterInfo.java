package Application.customannotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TesterInfo {


    public enum Priority {
        MEDIUM,
        HIGH,
        LOW
    }



    Priority priority() default Priority.MEDIUM;
    String[] tags() default "";
    String createdBy() default "Shreya";
    String lastModified() default "16/09/1989";




}
