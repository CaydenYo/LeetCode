import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        System.out.println("请输入圆的半径:");
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        for (int y = 0; y <= 2 * r; y += 2) {//y的步长为2,改变y的步长可以将圆形变成椭圆
            int x = (int)Math.round(r - Math.sqrt(2 * r * y - y * y));
            int len = 2 * (r - x);

            for (int i = 0; i <= x; i++) {
                System.out.print(' ');
            }
            System.out.print('*');

            for (int j = 0; j <= len; j++) {
                System.out.print(' ');
            }

            System.out.println('*');

        }
    }
}
