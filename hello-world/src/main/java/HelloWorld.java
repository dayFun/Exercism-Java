public class HelloWorld {

    public static String hello(String name) {
        String hello = "Hello, ";
        if (name == null || name.equals("")) {
            name = "World";
        }
        return hello + name + "!";
    }

}


