package com.andrewh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static String readAsIntegers (File fileToReadAsIntegers, Boolean ascending) {
        String sortOrder = null;
        if (ascending) {
            sortOrder = "ascending";
        }
        else {
            sortOrder = "descending";
        }
        System.out.println("Sorting as a set of integers. Order - " + sortOrder);
        return("Null return.");
    }

    static String readAsStrings (File fileToReadAsStrings, Boolean ascending) {
        String sortOrder = null;
        if (ascending) {
            sortOrder = "ascending";
        }
        else {
            sortOrder = "descending";
        }
        System.out.println("Sorting as a set of strings. Order - " + sortOrder);
        return("Null return.");
    }

    static void writeResultToFile (File fileToWrite) {
        //TODO
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
        if (!(new File(args[0]).exists())) {
            System.out.println("Input file that you have specified does not exist! (Specified input file is " + args[0] + ")");
            System.out.println("Run: \"sort-it -h\" to get more information\n");
            System.out.println("Указанный вами входной файл не существует! (Указанный входной файл: " + args[0] + ")");
            System.out.println("Запустите: \"sort-it -h\" для получения дополнительной информации");
            System.exit(0);
        }

        //check if 2nd argument is valid
        if (new File(args[1]).exists()) {
            System.out.println("Output file that you have specified does already exist! (Specified output file is " + args[0] + ")");
            System.out.println("If you would like to overwrite it press \"y\" (\"Y\"), press any other key to exit without overwriting.");
            System.out.println("Указанный вами выходной файл уже существует! (Указанный выходной файл: " + args[0] + ")");
            System.out.println("Если вы хотите перезаписать его нажмите \"y\" (\"Y\"), нажмите любую другую кнопку для выхода без перезаписи.");
            System.out.println("\"Y\"?");

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

        if (args[2].equals("-i")) {
            //if (args[3])
            //System.out.println("Sorting file as a set of integers");
        } else if (args[2].equals("-s")) {
            //System.out.println("Sorting file as a set of strings");
            //sortAsStrings();
        } else {
            System.out.println("3rd argument should be -i or -s, but you have passed " + args[2]);
            System.out.println("Run: \"sort-it -h\" to get more information\n");
            System.out.println("3-им аргументом нужно передать -i или -s, а вы передали " + args[2]);
            System.out.println("Запустите: \"sort-it -h\" для получения дополнительной информации");
            System.exit(0);
        }

        Scanner sc = null;

        try {

            File fileToSort = new File(args[0]);
            //File fileToSort = new File("inDir.txt");
            //File fileToSort = new File("D:\\in.txt");
            //File fileToSort = new File(sourceDir, inputFile)
            sc = new Scanner(fileToSort);
            System.out.println("File opened. (Файл открыт.)");

            while (sc.hasNext()) {
                //System.out.println(sc.next());
                sc.next();
            }

        } catch (FileNotFoundException e) {

            System.out.println("Error: File not found! (Ошибка: Файл не найден!)");
            //TODO

        } finally {

            sc.close();
            //System.out.println("Ok! File closed. (Файл закрыт.)");

        }
    }
}

