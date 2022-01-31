package Chapter_09;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 99; i++) {
            arrayList.add(scanner.nextLine());
        }

        ArrayList<String> splitArrayList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < arrayList.size(); i++) {
            String[] splitString = arrayList.get(i).trim().split(" ");
            if (splitString[1].equals("int")) {
                stringBuilder.append("pstmt.setInt(").append(i + 1).append(", Integer.parseInt(refineField[").append(i).append("]));");
                splitArrayList.add(stringBuilder.toString());
            } else if (splitString[1].equals("String")) {
                stringBuilder.append("pstmt.setString(").append(i + 1).append(", refineField[").append(i).append("]);");
                splitArrayList.add(stringBuilder.toString());
            } else if (splitString[1].equals("long")) {
                stringBuilder.append("pstmt.setLong(").append(i + 1).append(", Long.parseLong(refineField[").append(i).append("]));");
                splitArrayList.add(stringBuilder.toString());
            } else if (splitString[1].equals("float")) {
                stringBuilder.append("pstmt.setFloat(").append(i + 1).append(", Float.parseFloat(refineField[").append(i).append("]));");
                splitArrayList.add(stringBuilder.toString());
            }
            stringBuilder.setLength(0);
        }
        for (int i = 0; i < splitArrayList.size(); i++) {
            System.out.println(splitArrayList.get(i));
        }
    }
}
