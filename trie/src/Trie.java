import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Trie {

    public HashMap<Character,Trie> connection;
    public boolean word;

    public Trie(){
        connection = new HashMap<>();
        word = false;
    }

    public void insert(String word) {

        Trie curr = this;

        for (int i = 0; i < word.length(); i++) {

            if(!curr.connection.containsKey(word.charAt(i))){
                curr.connection.put(word.charAt(i),new Trie());
            }

            curr = curr.connection.get(word.charAt(i));

        }

        curr.word = true;

    }

    public boolean dfs(int i, Trie root , String word){

        for (int j = i; j < word.length(); j++) {

            if(word.charAt(j) == '.') {

                for (Map.Entry<Character, Trie> entry: root.connection.entrySet()) {
                    if (dfs(j + 1, entry.getValue(), word)){
                        return true;
                    }
                }
                return false;

            }else {

                if(!root.connection.containsKey(word.charAt(j))){
                    return false;
                }else {
                    root = root.connection.get(word.charAt(j));
                }

            }

        }

        return root.word;
    }

    public boolean search(String word) {

        Trie curr = this;

        return dfs(0,curr,word);
    }


    public int dfs_pro(int i, Trie root , String word , int length){

        for (int j = i; j < word.length(); j++) {

            if(word.charAt(j) == '.') {

                for (Map.Entry<Character, Trie> entry: root.connection.entrySet()) {
                    if (dfs(j + 1, entry.getValue(), word)){
                        return length;
                    }
                }
                return length;

            }else {

                if(!root.connection.containsKey(word.charAt(j))){
                    return length;
                }else {
                    root = root.connection.get(word.charAt(j));
                    length++;
                }

            }

        }

        return length;
    }

    public boolean startsWith(String prefix) {

        Trie curr = this;

       int result = dfs_pro(0, curr,prefix,0);

       if (result == prefix.length()){
           return true;
       }else {
           return false;
       }

    }

}
