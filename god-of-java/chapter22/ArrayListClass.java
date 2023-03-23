package chapter22;

import java.util.ArrayList;

public class ArrayListClass {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(20);  //숫자를 지정하지 않으면 저장 공간이 10개인 리스트가 만들어짐
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(1,"A1");   //중간에 추가하면 뒤로 하나씩 밀림
        //list.add(5,"D");  인덱스 5가 없는데 추가할려니까 예외가 발생함

        //list에 다른 list2 추가하기 -> list2 값 그대로 있음 *중요*
        ArrayList<String> list2 = new ArrayList<>(20);
        list2.add("0");
        list2.add("1");
        list.addAll(list2);

        //list3에 list 넣기 -> list는 비워짐 *중요*
        ArrayList<String> list3 = new ArrayList<>(list);
        list3.add("good");

        //'=' 사용 -> list의 값만 복사하는게 아니라 참조하고있는 주소까지 사용하는 것
        ArrayList<String> list4 = new ArrayList<>(20);
        list3 = list4;
        list4.add("4");     //list3과 list4가 같은 메모리 주소를 참조하고 있기 때문에 list3도 4만 가지고 있음

        System.out.println("--------list3--------");
        for(String temp : list3){
            System.out.println(temp);
        }
    }
}
