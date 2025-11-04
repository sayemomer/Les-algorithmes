import java.util.Map;
import java.util.Scanner;

public class word_dictionary {

    public Trie root;

    public word_dictionary(){
        root = new Trie();
    }

    public static boolean dfs(int index,Trie root,String s){

        Trie curr = root;

        for (int i = index; i < s.length(); i++) {

            if(s.charAt(i) == '.'){
                //check the next one in the connetions of this varible

                for (Map.Entry<Character,Trie> entry: curr.connection.entrySet()){

                    if(dfs(i+1,entry.getValue(),s)){
                        return true;

                    }
                }


            }else {

                if (!curr.connection.containsKey(s.charAt(i))) {
                    return false;
                } else {
                    curr = curr.connection.get(s.charAt(i));
                }

            }

        }

        return curr.word;

    }

    private boolean search(String s) {

        return dfs(0,root,s);

    }

    private void addWord(String bad) {

        Trie curr = root;
        //we should check the root , and the children
        for (char c : bad.toCharArray()){

            if(!curr.connection.containsKey(c)){
                curr.connection.put(c,new Trie());
            }
            curr = curr.connection.get(c);
        }
        curr.word = true;
    }


    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            word_dictionary obj = new word_dictionary();
            obj.addWord("bad");
            obj.addWord("dad");
            obj.addWord("mad");

            System.out.println(obj.search("...ad"));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}
