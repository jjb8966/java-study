package chapter22;

import java.util.ArrayList;

public class ArrayListClass2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        String[] temp = new String[3];
        String[] StringArray = list.toArray(temp);

        String[] tempUnder = new String[2];
        String[] StringArray2 = list.toArray(tempUnder);

        System.out.println("--------StringArray--------");
        for(String str : StringArray){
            System.out.println(str);
        }
        System.out.println("--------StringArray2--------");
        for(String str : StringArray2){
            System.out.println(str);
        }
    }
}
