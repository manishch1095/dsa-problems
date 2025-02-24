
import java.util.Arrays;
import java.util.List;

public class MoveZeroesToBack {

    public static void main(String[] args) {
        List<Integer> zeroes = Arrays.asList(1, 0, 2, 3, 0, 4, 0, 1);

        int index = 0;

        for (int i = 0; i < zeroes.size(); i++) {
            if (zeroes.get(i) == 0) {
                index = i;
                break;
            }
        }

        int temp;
        for (int i = index, j = i + 1; j < zeroes.size(); j++) {
            if (zeroes.get(j) != 0) {
                temp = zeroes.get(j);
                zeroes.set(j,zeroes.get(i));
                zeroes.set(i, temp);
                i++;
            }
        }

        System.out.println(zeroes.toString());
    }
}
