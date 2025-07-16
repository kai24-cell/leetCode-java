import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class word_count {
    public static void main(String[] args) {

    }
}

class Print_frecently {
    HashMap<String, Integer> low_and_split_empty = new HashMap<>();
    ArrayList<String> low_and_split_word = new ArrayList<>();

    public void get_and_print() {
        Scanner scan_data = new Scanner(System.in);
        String[] word = scan_data.nextLine().toLowerCase().split(" ");
        low_and_split_word = new ArrayList<>(Arrays.asList(word));
        scan_data.close();
    }

    private void count_data() {

    }
}