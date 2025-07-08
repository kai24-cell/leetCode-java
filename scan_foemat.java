import java.util.Scanner;

public class scan_foemat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("何回読み込みますか");
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "行目をどうぞ");
            String line = scan.nextLine();
            System.out.println(line);
        }
        scan.close();
    }
}
