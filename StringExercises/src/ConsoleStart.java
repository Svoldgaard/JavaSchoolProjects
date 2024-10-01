import java.util.Scanner;

public class ConsoleStart {
    public static void main(String[] args) {



        //exercise1();
        //exercise2();
        //exercise3();
        //exercise4();
        //exercise5();


    }

    private static void exercise1(){

        //1. From any user input. surround the input with tags like: "input" -> "<input>". Print the result to the screen

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Write something:");
        String input = keyboard.nextLine();
        System.out.println("You wrote this: <" + input + ">");
    }

    private static void exercise2(){

        //2. From any user input. count the amount of characters in the input and write the number of characters to the screen
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Write something:");
        String input = keyboard.nextLine();
        int len = input.length();

        System.out.println(len);

    }

    private static void exercise3() {

        //3. From any user input, seperate each character in the string with a "@"
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Write something:");
        String input = keyboard.nextLine();

        System.out.println(input);
        for (int i = 0; i < input.length(); i++) {
            System.out.print(input.charAt(i) + "@");

        }

    }

    private static void exercise4() {

        //4. From any user input, write the input characters backwards

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Write something:");
        String input = keyboard.nextLine();
        System.out.println(input);

        String str= input, nstr="";
        char ch;

        System.out.print("Original word: ");
        System.out.println(input);

        for (int i=0; i<str.length(); i++)
        {
            ch= str.charAt(i);
            nstr= ch+nstr;
        }
        System.out.println("Reversed word: "+ nstr);

    }

    private static void exercise5() {
        //5. From any user input. Convert the input to morse code in the form "This is cool" -> "- .... .. ... / .. ... / -.-. --- --- .-..", where letter space is "space" and word is "/"
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Write something:");
        String input = keyboard.nextLine();
        System.out.println(input);



    }
}