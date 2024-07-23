import java.util.HashMap;

public class Trie {

    public HashMap<Character,Trie> connection;
    public boolean word;

    public Trie(){
        connection = new HashMap<>();
        word = false;
    }

}
