package Question4;

public class Question4 {


    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        String res = zigZagPrint(str, 3);
        System.out.println(res);

    }

    public static String zigZagPrint(String s, int rows) {
        if (rows == 1) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[rows];
        for (int i = 0; i < rows; i++) {
            sb[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            int index = i % (2 * rows - 2);
            index = index < rows ? index : 2 * rows - 2 - index;
            sb[index].append(s.charAt(i));
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < rows; i++) {
            res.append(sb[i]);
        }

        return res.toString();
    }
}
