import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class<User> userClass = User.class;
        Field[] declaredFields = userClass.getDeclaredFields();
        Method[] declaredMethods = userClass.getDeclaredMethods();

        for (Field declaredField : declaredFields) {
            Document annotation = declaredField.getAnnotation(Document.class);
            System.out.println("Field= " + declaredField.getName());
            System.out.println("Description= "+annotation.Description());
            System.out.println("Type= " + annotation.ReturnType());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        }

        Method[] declaredMethods1 = User.class.getDeclaredMethods();
        for (Method method : declaredMethods1) {
            System.out.println("----METHOD: " + method.getName());
            if(method.isAnnotationPresent(Document.class))
            {
                Document doc = (Document) method.getAnnotation(Document.class);
                System.out.println("----Description: " +doc.Description());
                System.out.println("----Retrun Type: "+doc.ReturnType());
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
            }
        }
    }
}
