package com.company;
//Задание 3
//Пользователь вводит с клавиатуры набор чисел и путь к файлу для сохранения полученных данных. Необходимо
//■ Сохранить все полученные числа;
//■ Найти максимум, минимум. Эти значения сохранить в том же файле;
//■ Отобразить числа;
//■ Отобразить максимум и минимум;
//■ Создать класс для логгирования операций. При создании объекта класса нужно уточнить куда производится
//логгирование: экран или файл. В программе можно создать только один объект класса. Все действия
//в программе необходимо логгировать с помощью объекта этого класса.

import java.io.*;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.nio.file.StandardOpenOption;
        import java.util.Arrays;
import java.util.Scanner;

public class task3 {
    private static void log(String str, int onScr) throws IOException {
        boolean onScreen;
        if (onScr != 0) onScreen = true;
        else onScreen = false;
        Logger.getLogger(onScreen).log(str);
    }

    public static int inputLog(Scanner scanner) throws IOException {
        System.out.print("Выбор места логирования: 0 - в файл, 1 - на экран  ");
        int onScr = scanner.nextInt();

        log(" Запущен метод inputLog(): Выбор места логирования: 0 - в файл, 1 - на экран \"  " + onScr, onScr);
        return onScr;
    }

    public static String inputNum(Scanner scanner, int onScr) throws IOException {

        System.out.print("Введите числа:  ");
        String strLine = scanner.nextLine();
        strLine = scanner.nextLine();

        log(" Запущен метод inputNum(): Ввод чисел: " + strLine + "\"  ", onScr);
        return strLine;
    }

    public static String inputNameFile(Scanner scanner, int onScr) throws IOException {

        System.out.print("Введите путь и имя файла:  ");
        String strLine = scanner.nextLine();

        log(" Запущен метод inputNameFile() для ввода имени файла для сохранения чисел:  " + strLine + "\"  ", onScr);
        return strLine;
    }

    public static void writeFile(String str, String path, int onScr) throws IOException {
        FileWriter fWr = new FileWriter(path, false);

        fWr.write(str);
        fWr.close();
        log(" Запущен метод writeFile(): записывает строку  \"" + str + "\"  в файл  " + path, onScr);
    }

    public static int[] getIntFromFile(String path, int onScr) throws IOException {
        BufferedReader bR = new BufferedReader(new FileReader(path));
        String str = bR.readLine();
        String[] strArr = str.split(" ");
        int[] arrInt = new int[strArr.length];

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = Integer.parseInt(strArr[i]);
        }
        log(" Запущен метод getIntFromFile(): считывает строку  \"" + str + "\"  из файла  " + path, onScr);
        return arrInt;
    }

    public static void printScreen(int[] arr, int onScr) throws IOException {
        System.out.println(Arrays.toString(arr));
        log(" Запущен метод printScreen(): отображает на экран введенные числа", onScr);
    }

    private static void writeMinMax(String minMax, int value, String path) throws IOException {
        Files.writeString(Paths.get(path), "\n" + minMax + " " + value, StandardOpenOption.APPEND);
    }

    public static void max(int[] arr, String path, int onScr) throws IOException {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        log(" Запущен метод min(): находит максимум " + max, onScr);
        writeMinMax("max", max, path);
        log(" Запущен метод writeMinMax(): записывает максимум " + max + " в файл  " + path, onScr);
    }

    public static void min(int[] arr, String path, int onScr) throws IOException {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        log(" Запущен метод min(): находит минимум " + min, onScr);
        writeMinMax("min", min, path);
        log(" Запущен метод writeMinMax(): записывает минимум " + min + " в файл  " + path, onScr);
    }

    public static void printMinMax(String path, int onScr) throws IOException {
        BufferedReader bR = new BufferedReader(new FileReader(path));
        String str;
        while ((str = bR.readLine()) != null) {
            if (str.split(" ")[0].equals("max")) {
                System.out.println("Максимум = " + str.split(" ")[1]);
            }
            if (str.split(" ")[0].equals("min")) {
                System.out.println("Минимум = " + str.split(" ")[1]);
            }
        }
        log(" Запущен метод minMax(): считывает максимум и минимум из файла  " + path + "  и выводит на экран ", onScr);
    }

}