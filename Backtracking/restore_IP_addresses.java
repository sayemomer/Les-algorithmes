package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import linked_list.linked_list_cycle;

public class restore_IP_addresses {

    //s = "25525511135"
    

    public static ArrayList<String> backtrack(String s ,int index,String ip){
        ArrayList<String> restored_ips = new ArrayList<>();

        //first we need a basecase
        //which is when the index hits the end
        System.out.println(s.length());
        if(index == s.length()){
            return restored_ips;
        }

        restored_ips.add(" ");

        return backtrack(s, index + 1, ip + " ");

    }


    public static List<String> restoreIpAddresses(String s) {

        ArrayList<String> restored_ips = new ArrayList<>();

        //ok first lets make ip address without any constrain

        

        return backtrack(s,0, " ");
        
    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            String s = sc.nextLine();

            System.out.println(restoreIpAddresses(s));
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
}
