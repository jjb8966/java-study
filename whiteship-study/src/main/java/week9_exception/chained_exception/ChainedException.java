package week9_exception.chained_exception;

import java.util.Scanner;

public class ChainedException {
    public static void main(String[] args) {
        ChainedException ce = new ChainedException();
        Scanner sc = new Scanner(System.in);
        int cause = sc.nextInt();

        try {
            ce.goHome(cause);
        } catch (CantGoHomeException e) {
            System.out.println(e.getCause().getMessage());
        }
    }

    void goHome(int flag) throws CantGoHomeException {
        try {
            if (flag == 1) {
                throw new LoseMoneyException();
            }

            if (flag == 2) {
                throw new ShutDownBusException();
            }

            if (flag == 3) {
                throw new Exception();
            }

            System.out.println("집에 잘 감");
        } catch (LoseMoneyException e) {
            // 원인을 저장
            throw new CantGoHomeException(e);
        } catch (ShutDownBusException e) {
            throw new CantGoHomeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
