import java.util.Scanner;

public class RpnResolver {
    public static void main(String[] args) {

        System.out.println("Enter RPN expression: ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int result = resolve(input);

    }

    public static Integer resolve(String input) {
        String[] tokens = input.split(" ");

        switch (tokens[2]) {
            case "+":
                return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]);
            case "-":
                return Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[1]);
            default:
                return null;
        }

    }
}