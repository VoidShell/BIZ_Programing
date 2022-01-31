package Chapter_09;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] splitLine = line.split(", ");

        StringBuilder stringBuilder = new StringBuilder();
        //(refineField[0], Integer.parseInt(refineField[1]), refineField[2], Integer.parseInt(refineField[3]),

        for (int i = 0; i < splitLine.length; i++) {
            if (splitLine[i].startsWith("S")) {
                stringBuilder.append("refineField[").append(i).append("], ");
                System.out.println(123);
            } else if (splitLine[i].startsWith("i")) {
                stringBuilder.append("Integer.parseInt(refineField[").append(i).append("]), ");
            } else if (splitLine[i].startsWith("l")) {
                stringBuilder.append("Long.parseLong(refineField[").append(i).append("]), ");
            } else if (splitLine[i].startsWith("f")) {
                stringBuilder.append("Float.parseFloat(refineField[").append(i).append("]), ");
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
