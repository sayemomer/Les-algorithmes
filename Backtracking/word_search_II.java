package Backtracking;

import java.util.*;

class Trie {

    /*
    Trie shound have a map to connected node
    and a flag to_mark it as a word
     */

    HashMap<Character,Trie> connections;
    boolean is_word;

    Trie(){
        connections = new HashMap<>();
        is_word = false;
    }

    /*
    a mathod to add connections of build trie
     */

    public void insert(String word){

        //instead of new trie node , the curr trie should be this
        Trie curr = this;

        for(Character aph: word.toCharArray()){

            if(!curr.connections.containsKey(aph)){
                curr.connections.put(aph,new Trie());

            }
            curr = curr.connections.get(aph);
        }

        //after mapping we need to flag the curr as a word
        curr.is_word = true;

    }

}

public class word_search_II {

    public static List<String> words_found;
    public static void dfs(char[][] board, int row, int col, StringBuilder word, Trie node,Set<Character> visit_set){

        //first we need a basecase for the dfs
        //1.we need to check the boundary
        //2.if its visited or not
        //3.if the current currnt char exits in the nodes connection

        System.out.println(visit_set.contains(board[row][col]));

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
                visit_set.contains(board[row][col]) || !node.connections.containsKey(board[row][col])){
            return;
        }

        visit_set.add(board[row][col]);
        node = node.connections.get(board[row][col]);
        word.append(board[row][col]);
        System.out.println(word);

        if(node.is_word){
            words_found.add(String.valueOf(word));
        }

        dfs(board, row -1 , col, word, node,visit_set);
        dfs(board, row + 1 , col, word, node,visit_set);
        dfs(board, row, col + 1 , word, node,visit_set);
        dfs(board, row, col -1 , word, node,visit_set);

        visit_set.remove(board[row][col]);

    }

    public static List<String> findWords(char[][] board, String[] words) {

        words_found = new ArrayList<>();
        Set<Character> visit_set = new HashSet<>();

        //first from the words we need to create a trie

        Trie newtrieNode = new Trie();

        for (String word: words){
            newtrieNode.insert(word);
        }

        //now we need the dfs search

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                 dfs(board,i,j,new StringBuilder(),newtrieNode,visit_set);
            }
        }

        return words_found;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            int row = Integer.parseInt(sc.nextLine());
            int col = Integer.parseInt(sc.nextLine());
            char[][] grid = new char[row][col];

            for (int i = 0; i < grid.length; i++) {
                grid[i] = sc.nextLine().toCharArray();
            }

            String[] words = sc.nextLine().split(" ");

            System.out.println(findWords(grid,words));



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
