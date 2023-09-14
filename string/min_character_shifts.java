package string;
import java.util.Scanner;

public class min_character_shifts {

    public static int main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String test = scanner.nextLine();

            String[] characters = test.split(" ");
            String mainCharacter = characters[0];
            String target = characters[1];

            if (mainCharacter.equals(target)) {
                return 0;
            }

            for (int i = 0; i < mainCharacter.length() - 1; i++) {

                String firstSub = mainCharacter.substring(0, i + 1);
                String secondSub = mainCharacter.substring(i + 1, mainCharacter.length());
                String rotated = secondSub.concat(firstSub);

                if (rotated.equals(target)) {
                    return i + 1;
                }
            }
        }
        return -1;
    }
}

