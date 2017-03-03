package com.andrewh;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    private static List<Integer> readAsIntegersAndSort(Scanner scToRead, Boolean ascending) {
        String sortOrder;// = null;
        if (ascending) {
            sortOrder = "ascending";
        }
        else {
            sortOrder = "descending";
        }
        System.out.println("Sorting as a set of integers. Order - " + sortOrder);

        if (!(scToRead.hasNextInt())) {
            System.out.println("File has no integers!");
            return(null);
        }

        List<Integer> listToSort = new ArrayList<Integer>();
        while(scToRead.hasNext()) {
            listToSort.add(scToRead.nextInt());
        }
        System.out.println("Reading done");
        System.out.println(listToSort);
        Collections.sort(listToSort);
        if (!ascending) {
            Collections.reverse(listToSort);
        }
        System.out.println("Sorting done");
        return(listToSort);
    }


    private static List<String> readAsStringsAndSort (Scanner scToRead, Boolean ascending) {
        String sortOrder;// = null;
        if (ascending) {
            sortOrder = "ascending";
        }
        else {
            sortOrder = "descending";
        }
        System.out.println("Sorting as a set of strings. Order - " + sortOrder);

        if (!(scToRead.hasNext())) {
            System.out.println("File has no data!");
            return(null);
        }

        List<String> listToSort = new ArrayList<String>();
        while(scToRead.hasNext()) {
            listToSort.add(scToRead.next());
        }
        System.out.println("Reading done");
        System.out.println(listToSort);
        Collections.sort(listToSort);
        if (!ascending) {
            Collections.reverse(listToSort);
        }
        System.out.println("Sorting done");
        return(listToSort);
    }


    private static void writeResultToFile(String outputFile, List<?> contentToWrite) {

        try {
            FileWriter writer = new FileWriter(outputFile);
            for (int i = 0; i < contentToWrite.size(); i++) {
                writer.write(contentToWrite.get(i).toString());
                writer.write("\r\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to write result to output file. Writing was not finished.");
            System.out.println("При записи результатов в выходной файл произошел сбой. Запись не была завершена.");
        }
    }


    public static void main(String[] args) {

        //System.out.println("Count of arguments: " + args.length);


        //args check, проверяем наличие четырех параметров CL (если не 4 - выходим)

        if (args.length != 4) {
            System.out.println("You should pass 4 arguments exactly, but you have passed " + args.length);
            System.out.println("Run: \"sort-it -h\" to get more information\n");
            System.out.println("Вам необходимо передать ровно 4 аргумента, но вы передали " + args.length);
            System.out.println("Запустите: \"sort-it -h\" для получения дополнительной информации");
            //return;
            System.exit(0);
        }


        //check if 1st argument is valid

        if (!(new File(args[0]).exists() && new File(args[0]).isFile())) {
            System.out.println("Input file that you have specified does not exist! (Specified input file is " + args[0] + ")");
            System.out.println("Run: \"sort-it -h\" to get more information\n");
            System.out.println("Указанный вами входной файл не существует! (Указанный входной файл: " + args[0] + ")");
            System.out.println("Запустите: \"sort-it -h\" для получения дополнительной информации");
            System.exit(0);
        }


        //if 3rd argument is not valid (not "-i" or "-s") | проверяем валидность третьего аргумента

        if (!(args[2].equals("-i") || args[2].equals("-s"))) {
            System.out.println("3rd argument should be \"-i\" or \"-s\", but you have passed " + args[2]);
            System.out.println("Run: \"sort-it -h\" to get more information\n");
            System.out.println("3-им аргументом необходимо передать \"-i\" или \"-s\", а вы передали " + args[2]);
            System.out.println("Запустите: \"sort-it -h\" для получения дополнительной информации");
            System.exit(0);
        }


        //if 4th argument is not valid (not "-a" or "-d") | проверяем валидность четвертого аргумента

        if (!(args[3].equals("-a") || args[3].equals("-d"))) {
            System.out.println("4th argument should be \"-a\" or \"-d\", but you have passed " + args[3]);
            System.out.println("Run: \"sort-it -h\" to get more information\n");
            System.out.println("4-ым аргументом необходимо передать \"-a\" или \"-d\", а вы передали " + args[3]);
            System.out.println("Запустите: \"sort-it -h\" для получения дополнительной информации");
            System.exit(0);
        }


        //check if 2nd argument is valid / if specified output file (or directory) already exists

        if (new File(args[1]).exists() && new File(args[1]).isDirectory()) {
            System.out.println("Output file that you have specified can not be created, there is a directory " + args[0] + " (not a file)!");
            System.out.println("Run: \"sort-it -h\" to get more information\n");
            System.out.println("Указанный вами выходной файл не может быть создан, существует такая директория " + args[0] + " (не файл)!");
            System.out.println("Запустите: \"sort-it -h\" для получения дополнительной информации");
            System.exit(0);
        }
        if (new File(args[1]).exists() && new File(args[1]).isFile()) {
            System.out.println("Output file that you have specified does already exist! (Specified output file is " + args[0] + ")");
            System.out.println("If you would like to overwrite it enter \"y\" (or \"Y\"), enter anything else to exit without overwriting.");
            System.out.println("Указанный вами выходной файл уже существует! (Указанный выходной файл: " + args[0] + ")");
            System.out.println("Если вы хотите перезаписать его введите \"y\" (или \"Y\"), введите что угодно другое для выхода без перезаписи.");
            System.out.println("\"Y\"?");
            Scanner userInput = new Scanner(System.in);
            if (!(userInput.nextLine().equalsIgnoreCase("y"))) {
                System.exit(0);
            } else {
                userInput.close();
            }
        }


        //Starting to open&read(&sort) file

        Scanner sc = null;
        try {

            File fileToSort = new File(args[0]);
            sc = new Scanner(fileToSort);
            //Let's use ArrayList 'cause we will fill it from file and will not change number (quantity) of elements
            System.out.println("File opened. (Файл открыт.)");

            if (args[2].equals("-i")) {
                List<Integer> resultIntegersList = new ArrayList<Integer>();
                System.out.println("Starting to read file and sort it as a set of integers");
                resultIntegersList = readAsIntegersAndSort(sc, args[3].equals("-a"));
                System.out.println(resultIntegersList.toString());
                writeResultToFile(args[1], resultIntegersList);
            } else if (args[2].equals("-s")) {
                List<String> resultStringsList = new ArrayList<String>();
                System.out.println("Starting to read file and sort it as a set of strings");
                resultStringsList = readAsStringsAndSort(sc, args[3].equals("-a"));
                System.out.println(resultStringsList.toString());
                writeResultToFile(args[1], resultStringsList);
            }

        } catch (FileNotFoundException e) {

            //e.printStackTrace();
            System.out.println("Error: problems opening input file ! (Ошибка: проблемы при открытии входного файла!)");

        } finally {

            sc.close();

        }

        //TODO If resultIntegersList is not empty (not NUll)??Do it in next try block??

    }
}

