package week9_exception.basic;

public class MonthClass {

    void printMonth(int number) {
        try {
            if (number > 12) {
                throw new Exception("1월에서 12월만 있음");
            }

            System.out.println(number + "월달 입니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("try catch 밖");
    }
}
