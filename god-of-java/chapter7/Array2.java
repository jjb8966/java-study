package chapter7;

public class Array2 {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        //int[][] b = {{1,2,3},{4,5}};    // X
        for (int i = 0; i < 2; i++) {                                       //index를 다룰 수 있음
            for (int j = 0; j < 3; j++) {
                System.out.println("a[" + i + "][" + j + "]=" + a[i][j]);
                //System.out.println("b["+i+"]["+j+"]="+b[i][j]);
            }
        }

        for (int[] i : a) {                                                 //배열을 위한 for문
            for (int j : i)                                                 //좀더 편하게 for문을 사용할 수 있다.
                System.out.println(j);
        }
    }
}


