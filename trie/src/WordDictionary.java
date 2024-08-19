import java.util.Map;
import java.util.Scanner;


public class WordDictionary {

    public Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word ) {

        Trie curr = root;

        for (int i = 0; i < word.length(); i++) {

            if(!curr.connection.containsKey(word.charAt(i))){
                curr.connection.put(word.charAt(i),new Trie());
            }

            curr = curr.connection.get(word.charAt(i));

        }

        curr.word = true;
    }

    public boolean dfs(int i, Trie child , String word){

        for (int j = i; j < word.length(); j++) {

            if(word.charAt(j) == '.') {

                for (Map.Entry<Character, Trie> entry: child.connection.entrySet()) {
                    if (dfs(j + 1, entry.getValue(), word)){
                        return true;
                    }
                }
                return false;

            }else {

                if (!child.connection.containsKey(word.charAt(j))) {
                    return false;
                } else {
                    child = child.connection.get(word.charAt(j));
                }
            }
        }

        return child.word;
    }

    public boolean search(String word) {

        return dfs(0,root,word);
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            WordDictionary obj = new WordDictionary();
            obj.addWord("bad");
            obj.addWord("dad");
            obj.addWord("mad");

//            System.out.println(obj.search("bad"));
//            System.out.println(obj.search(".ad"));
            System.out.println(obj.search(".. ad"));


//            String[] input_commands = sc.nextLine().split(",");
//
//            String[] retrive_commands= sc.nextLine().split(",");
//
//            System.out.println(Arrays.toString(input_commands));
//            System.out.println(Arrays.toString(retrive_commands));
//            System.out.println(retrive_commands[1].charAt(0));


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
