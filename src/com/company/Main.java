package com.company;
import java.io.IOException;
import java.util.Scanner;
public class Main {


            public static void main(String[] args) throws IOException {

               Scanner scanner = new Scanner(System.in);

                System.out.print("Введите числа:  ");
                String strLine = scanner.nextLine();

                System.out.print("Введите путь и имя файла:  ");
                String path = scanner.nextLine();

                System.out.print("Выбор места логирования: 0 - в файл, 1 - на экран:  ");
                int  onScr = scanner.nextInt();
                scanner.close();

                task3.writeFile(strLine,path,onScr);

                int[] arr = task3.getIntFromFile(path, onScr);
                task3.print(arr, onScr);

                task3.max(arr, path, onScr);
                task3.min(arr, path, onScr);
                task3.printMinMax(path, onScr);
            }


}
