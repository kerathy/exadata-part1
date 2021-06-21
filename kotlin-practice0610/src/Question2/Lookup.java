package Question2;

import java.util.HashMap;
import java.util.Scanner;

public class Lookup {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int entries = sc.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < entries; i++) {
            String name = sc.next();
            String phoneNumber = sc.nextLine().substring(1);
            map.put(name, phoneNumber);
        }
        StringBuilder res = new StringBuilder();
        while (sc.hasNext()) {
            String name = sc.nextLine();
            if (name.equals("quit")) {
                break;
            }
            if (map.containsKey(name)) {
                res.append(name + "=" + map.get(name));
                res.append("*");
            } else {
                res.append("Not found");
                res.append("*");
            }
            System.out.println(res.toString());
        }

        for (String s : res.toString().split("\\*")) {
            System.out.println(s);
        }
    }

}
