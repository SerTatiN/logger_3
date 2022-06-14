package com.company;
import java.io.IOException;
import java.util.Scanner;
public class Main {


            public static void main(String[] args) throws IOException {

             Scanner scanner = new Scanner(System.in);

             int onScr = task3.inputLog(scanner);

             String strLine = task3.inputNum(scanner, onScr);

             String path = task3.inputNameFile(scanner, onScr);
             scanner.close();

             task3.writeFile(strLine, path, onScr);

             int[] arr = task3.getIntFromFile(path, onScr);
             task3.printScreen(arr, onScr);

             task3.max(arr, path, onScr);
             task3.min(arr, path, onScr);
             task3.printMinMax(path, onScr);
            }


}
