package chapter24;

import java.util.*;

public class hashMapSample {

    public static void main(String[] args) {
        //put(), get(), remove()
        HashMap<String,String> map = new HashMap<>();
        map.put("A","a");
        map.put("B","b");
        map.put("C","c");
        map.put("D","d");
        map.put("A","a1");                  //키 A의 값이 a->a1으로 변경
        map.remove("D");               //D-d 데이터 삭제
        System.out.println(map.get("A"));   //값인 a1 출력
        System.out.println(map.get("D"));   //D라는 키가 없으므로 null 출력

        //keySet() - 리턴타입 : Set
        Set<String> keySet = map.keySet();  //키값만 저장한 Set
        for(String str : keySet){
            System.out.print(str+" ");
        }
        System.out.println();

        //values() - 리턴타입 : Collection
        Collection<String> valueSet = map.values();
        for(String str : valueSet){
            System.out.print(str+" ");
        }
        System.out.println();

        //entrySet() - 리턴타입 : Set
        //entry.getKey(), entry,getValue()
        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        for(Map.Entry<String,String> entry : entrySet){
            System.out.print(entry.getKey()+":"+entry.getValue()+"  ");
        }
        System.out.println();

        //contiansKey(), containsValue()
        System.out.print(map.containsKey("A")+" ");       //true
        System.out.print(map.containsValue("a")+" ");     //false
        System.out.println(map.containsValue("a1"));      //true

        //TreeMap 클래스 사용 -> 정렬된 map
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("a","소문자");
        treeMap.put("1","숫자");
        treeMap.put("A","대문자");
        treeMap.put("가","한글");
        //정렬 순서 : 숫자 -> 대문자 -> 소문자 -> 한글
        Set<Map.Entry<String,String>> treeMapEntry = treeMap.entrySet();
        for(Map.Entry<String,String> tempEntry : treeMapEntry){
            System.out.print(tempEntry.getKey()+":"+tempEntry.getValue()+"  ");
        }
    }
}
