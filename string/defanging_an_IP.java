//https://leetcode.com/problems/defanging-an-ip-address/description/

package string;

public class defanging_an_IP {


    public static String defangingIpAdress(String IP){

        

        String defangeIP = IP.replaceAll("\\.", "[.]");
        return defangeIP;
    }

    public static void main(String[] args) {

        defangingIpAdress("1.1.1.1");
        defangingIpAdress("255.100.50.0");
    }
    
}
