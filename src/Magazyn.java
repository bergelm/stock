import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;

public class Magazyn {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj nazwę pliku (data.csv)");
        String fileName = scanner.nextLine();
        Map<String, Integer> products = readProductsFromFile(fileName);
        printStars(products);

    }


    private static List<String> readFile (String fileName){
        List<String> allLines = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(fileName))){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                allLines.add(line);
            }

        } catch (FileNotFoundException error){
            System.out.println("File not foud");
        } return allLines;
    }


    private static Map<String, Integer> readProductsFromFile(String fileName){
        List<String> fileContent = readFile(fileName);
        Map<String, Integer> result = new HashMap<>();
        for (String row : fileContent){
            String[] read = row.split(";");
            result.put(read[0], Integer.valueOf(read[1]));
        }return result;

    }


    private static void printStars(Map<String, Integer> map){
        map.forEach((x,y)->{
            System.out.printf("%-30s(%d)%s\n", x,y, getStars(y));
        }
    );
    }


    private static String getStars(int number){
        int round = (number +5)/10;
        return String.join("", Collections.nCopies(round, "*"));
    }










}