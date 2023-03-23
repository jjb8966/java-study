package chapter21;

import java.io.Serializable;

public class GenericSample {
    public static void main(String[] args){
        GenericSample GS = new GenericSample();
        GS.checkCastingDTO();
    }
    void checkCastingDTO(){
        CastingDTO dto1 = new CastingDTO();
        CastingDTO dto2 = new CastingDTO();
        CastingDTO dto3 = new CastingDTO();
        dto1.setObject(new String("abc"));
        dto2.setObject(new StringBuffer("def"));
        dto3.setObject(new StringBuilder("ghi"));

        //형변환을 해줘야 하는 번거로움이 있다 ----> 제네릭 사용
        String str = (String)dto1.getObject();      //dto1.getObject()는 object를 리턴함
        StringBuffer strBuffer = (StringBuffer) dto2.getObject();
        StringBuilder strBuilder = (StringBuilder) dto3.getObject();

        System.out.println(str);
        System.out.println(strBuffer);
        System.out.println(strBuilder);
    }
}

class CastingDTO implements Serializable{
    private Object object;
    void setObject (Object object){
        this.object = object;
    }
    Object getObject(){
        return object;
    }
}
