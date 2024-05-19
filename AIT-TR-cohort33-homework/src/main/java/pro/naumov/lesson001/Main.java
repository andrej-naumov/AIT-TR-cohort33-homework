package pro.naumov.lesson001;

    public class Main {

        static StringBuilder formattedNumber = new StringBuilder();

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLUE = "\u001B[34m";


        public static void main(String[] args) {

            formattedNumber.append(ANSI_BLUE).append("Hello Java - Pro =)").append(ANSI_RESET);
            System.out.println(formattedNumber.toString());
        }
    }


