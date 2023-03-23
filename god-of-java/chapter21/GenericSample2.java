package chapter21;

public class GenericSample2 {
    public static void main(String[] args) {
        GenericSample2 gs2 = new GenericSample2();
        gs2.callWildcardMethod();
    }
    void callWildcardMethod(){
        WildcardGeneric<String> wildcard = new WildcardGeneric<String>();
        wildcard.setWildcard("A");
        wildcardStringMethod(wildcard);
    }
    void wildcardStringMethod(WildcardGeneric<?> c){
        Object str = c.getWildcard();
        System.out.println(str);
    }
}

class WildcardGeneric<W>{
    W wildcard;
    void setWildcard(W wildcard){
        this.wildcard = wildcard;
    }
    W getWildcard(){
      return wildcard;
    }
}
