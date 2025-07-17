import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class word_count {
    public static void main(String[] args) {
        Print_frecently print = new Print_frecently();
        print.get_and_print();
    }
}

class Print_frecently {
    HashMap<String, Integer> low_and_split_empty = new HashMap<>();
    ArrayList<String> low_and_split_word = new ArrayList<>();

    public void get_and_print() {
        Scanner scan_data = new Scanner(System.in);
        String[] word = scan_data.nextLine().toLowerCase().split(" ");
        low_and_split_word = new ArrayList<>(Arrays.asList(word));
        for (String w : low_and_split_word) {
            if (low_and_split_empty.containsKey(w)) {
                low_and_split_empty.put(w, low_and_split_empty.get(w) + 1);
            } else {
                low_and_split_empty.put(w, 1);
            }
        }
        for (String l : low_and_split_word) {
            System.out.println(l + "は" + low_and_split_empty.get(l) + "個ありました");
        }

        scan_data.close();
    }