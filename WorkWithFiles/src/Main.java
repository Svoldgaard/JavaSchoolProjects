import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;


public class Main {
    private static final String fileStringPath = "/Users/majkensvoldgaard/Desktop/Jave School projects/WorkWithFiles/src/MyFile.myBinary";
    private static final Path filePath = Path.of(fileStringPath);

    public static void main(String[] args)  {

        PersonFileManager fileManager = new PersonFileManager((fileStringPath));
        System.out.println(fileManager.getAllPersons());
        Person p3 = new Person(3,"Donald");
        try{
            fileManager.addPerson(p3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(fileManager.getAllPersons());
        //fileManager.updatePerson(new Person(2,"Peter"));

        //System.out.println(fileManager.getPerson(2));


        /*Person p = new Person(1, "Jeppe");
        Person p2 = new Person(2, "Peter");
        Person p3 = new Person(3, "Jane");

        List<Person> persons = new ArrayList<>();
        persons.add(p);
        persons.add(p2);
        persons.add(p3);

        System.out.println(persons);

        savePersons(persons);
        */
        /*
        List<Person> personsFromFile = loadPersons();
        System.out.println(personsFromFile);
        */

        /*printFileContents();
        //addToFile("Some buffered line");
        addTextAtLine("Wierd new nio line write", 1);
        printFileContents();*/


    }

    private static List<Person> loadPersons() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileStringPath))){
            return (List<Person>)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void savePersons(List<Person> persons) {

        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileStringPath));
            oos.writeObject(persons);
        }catch (IOException e){
            e.printStackTrace();
        }


    }



    private static void addTextAtLine(String text, int lineNumber) {

        String fileInput = "";
        try{
            //read the old file
            List<String> allLines = Files.readAllLines(filePath);
            allLines.add(lineNumber,text);

            //creat the new temp file
            Path tempFilePath = Path.of(fileStringPath + "_TEMP");
            Files.createFile(tempFilePath);

            //Add the all lines including new line temp file
            int countLines = 0;
            for (String line : allLines) {
                Files.write(tempFilePath, (line + "\r\n").getBytes(),APPEND);
                countLines++;
            }

            // Overwrite old file with temp file and delete temp
            Files.copy(tempFilePath, filePath, StandardCopyOption.REPLACE_EXISTING);
            Files.deleteIfExists(tempFilePath);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void addToFile(String text) {

        try {
            Files.write(filePath, text.getBytes(), APPEND);
        } catch (IOException e) {
            e.printStackTrace();


        }
    }

    public static void printFileContents () {
        System.out.println("-------");
        try {
            //Files.lines(path.of(filePath).forEach(line -> System.out.println(line)));
            System.out.println(Files.readString(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}