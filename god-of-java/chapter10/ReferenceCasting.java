package chapter10;

public class ReferenceCasting {
    public static void main(String[] args) {
        ReferenceCasting obj = new ReferenceCasting();
        obj.objectCasting1();
        obj.objectCasting2();
        obj.arrayCasting();
    }
    void objectCasting1(){
        System.out.println("자식->부모 캐스팅 불가");

        ParentCasting parent = new ParentCasting();
        ChildCasting child = new ChildCasting();

        ParentCasting temparent = child;            //자->부 가능
        //ChildCasting temchild = parent;           //부->자 불가능

    }
    void objectCasting2(){
        System.out.println("자식->부모 캐스팅 하려면 부모클래스 객체가 실제는 자식클래스 객체여야함");

        ParentCasting infactchild = new ChildCasting();     //겉으론 부모 클래스 같지만 사실 자식 클래스
        ChildCasting child = (ChildCasting) infactchild;    //이런 경우 부->자 캐스팅 가능능
    }
   void arrayCasting(){

        ParentCasting[] parentArray = new ParentCasting[3];
        parentArray[0] = new ParentCasting();
        parentArray[1] = new ChildCasting();
        parentArray[2] = new ParentCasting();

        for(ParentCasting tem : parentArray){
            if(tem instanceof ChildCasting){                        //부모 클래스부터 검사하면 전부 부모 클래스라고 나옴
                System.out.println("This is ChildCasting class");
            }
            else if(tem instanceof ParentCasting){
                System.out.println("This is ParentCasting class");
            }
        }
    }
}
class ParentCasting{
    ParentCasting(){}
}
class ChildCasting extends ParentCasting{
    ChildCasting(){}
}
