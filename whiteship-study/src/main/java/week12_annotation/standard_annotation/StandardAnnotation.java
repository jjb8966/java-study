package week12_annotation.standard_annotation;

public class StandardAnnotation {

    public static void main(String[] args) {
        StandardAnnotation sa = new StandardAnnotation();
        sa.noMoreUse(); // ???? warning 떠야하는데...

    }

    @Deprecated
    void noMoreUse() {
        System.out.println("deprecated");
    }
}
