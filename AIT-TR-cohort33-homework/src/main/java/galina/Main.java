package galina;

public class Main {

    public static void main(String[] args) {
        String line = "John F. Kennedy International Airport; JFK;USA";
        String[]  data = line.split(";");

        for (String value : data) {
            System.out.println(value);
        }
    }
}
