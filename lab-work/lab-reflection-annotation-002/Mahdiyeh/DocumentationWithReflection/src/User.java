public class User {
    @Document(Description = "name of user",ReturnType = "String")
    String name;

    @Document(Description = "age of user",ReturnType = "int")
    int age;

    @Document(Description = "get user from internet",ReturnType = "String")
    public String user(String name){
        return this.name=name;
    }

    @Document(Description = "Summation",ReturnType = "integer")
    public int sum(int a,int b){
        return a+b;
    }
}
