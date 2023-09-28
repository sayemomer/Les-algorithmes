import java.util.Scanner;

public class auto_complete {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            String word = sc.nextLine();
            String[] words = word.split(",");
            int counter = 0;
            for (int i = 0; i < words.length; i++) {
                String tempStr = "";
                String[] wrdStr = words[i].split("");
                for (int j = 0; j < wrdStr.length; j++) {
                    int autoCounter = 0;
                    tempStr += wrdStr[j];

                    for (int j2 = 0; j2 < words.length; j2++) {

                        if (words[j2].startsWith(tempStr, 0)) {
                            autoCounter++;
                        }

                    }
                    if (autoCounter == 1 || tempStr.length() == wrdStr.length) {
                        counter += tempStr.length();
                        break;
                    }

                }
            }

            System.out.println(counter);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
