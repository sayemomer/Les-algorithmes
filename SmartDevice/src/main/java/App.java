import java.util.*;

/**
 * Drive class from Smart Device management
 */

public class App {

    private static int d_max_Password_Attempts = 1;
    private static int d_max_devices;
    final static String d_password = "device2024";

    private static SmartDevice[] d_smart_devices;

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * Display the main menu
     * @return return the choice from the manue
     */


    public static int mainMenu() {
        System.out.println("What do you want to do?\n" + //
                "1. Add devices (password required).\n" + //
                "2. Update devices (password required).\n" + //
                "3. Find device by type.\n" + //
                "4. Find affordable device.\n" + //
                "5. Quit\n" + //
                "Please enter your choice >");

        Scanner sc = new Scanner(System.in);
        //keep asking the user unless the user enters a valid integer
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input!");
            System.out.println("Please enter your choice >");
            sc.next();
        }
        int choice = sc.nextInt();

        return choice;
    }


    /**
     * Display welcome message
     */

    private static void display_welcome_message(){
        System.out.println(
                "*************** \nWelcome to Smart device Management System \n***************");
        System.out.println("Enter the maximum number of devices to add: ");
    }

    /**
     * Mathod to add multi-device
     * @param sc
     * @param device
     * @param num
     * @param d_max_devices
     * @return current max_devices after successful insertion
     */


    public static int add_device(Scanner sc, SmartDevice[] device, int num, int d_max_devices) {
        for (int i = 0; i < num; i++) {
            System.out.println("Enter the name: ");
            String l_name = sc.next();
            System.out.println("Enter the type: ");
            String l_type = sc.next();
            System.out.println("Enter the os version: ");
            String  l_os_version = sc.next();
            System.out.println("Enter the Battery Life: ");
            float l_battery_life = sc.nextFloat();
            System.out.println("Enter the price: ");
            float l_price = sc.nextFloat();
            System.out.println("Enter the availability(true/false): ");

            while (!sc.hasNextBoolean()) {
                System.out.println("Invalid input!");
                System.out.println("Please write (true/false): ");
                sc.next();
            }

            boolean l_is_in_stock = sc.nextBoolean();
            device[i] = new SmartDevice(l_name, l_type, l_os_version, l_battery_life, l_price, l_is_in_stock);

            //display the information
            System.out.println("The information of the device is: ");
            System.out.println("device: # " + i);
            System.out.println(device[i]);

            // after successfull enrollment of a device, the max number of devices
            // will be decreased by 1

            d_max_devices = d_max_devices - 1;
        }

        return d_max_devices;

    }

    /**
     * Serach Device by deviceID
     * @param sc
     * @param p_devices
     * @param p_deviceID
     * @return
     */

    public static boolean search_device(Scanner sc, SmartDevice[] p_devices, long p_deviceID) {

        //check if the ARRAY is empty
        if (p_devices[0] == null) {
            System.out.println(ANSI_RED + "There is no device in list!" + ANSI_RESET);
            return false;
        }else{

            for (int i = 0; i < p_devices.length; i++) {
                if (p_devices[i]!= null &&  p_devices[i].getD_device_id() == p_deviceID) {
                    return true;
                }
            }
            return false;

        }

    }

    /**
     * Update a device description by ID
     * @param sc
     * @param p_devices
     * @param p_deviceID
     */

    public static void update_device(Scanner sc, SmartDevice[] p_devices, long p_deviceID) {
        for (int i = 0; i < p_devices.length; i++) {
            if (p_devices[i]!= null && p_devices[i].getD_device_id() == p_deviceID) {
                //print the current information
                System.out.println("The current information of the device is: ");

                System.out.println("device: # " + i);
                System.out.println(p_devices[i].toString());

                //ask the user about which information he/she wants to change
                //keep asking until the user enters 7

                for (;;) {
                    System.out.println("Which information do you want to change?");
                    System.out.println("1. Device Name");
                    System.out.println("2. Device Type");
                    System.out.println("3. OS Version");
                    System.out.println("4. Battery Life");
                    System.out.println("5. Price");
                    System.out.println("6. Availability");
                    System.out.println("7. Quit");
                    System.out.println("Please enter your choice >");
                    int l_choice = sc.nextInt();
                    if(l_choice >= 1 && l_choice <= 6){
                        if(l_choice == 1){
                            System.out.println("Enter the new name: ");
                            String l_name = sc.next();
                            p_devices[i].setD_device_name(l_name);
                        }
                        else if(l_choice == 2){
                            System.out.println("Enter the new device type: ");
                            String l_device_type = sc.next();
                            p_devices[i].setD_device_type(l_device_type);
                        }
                        else if(l_choice == 3){
                            System.out.println("Enter the new OS version: ");
                            String l_os_version = sc.next();
                            p_devices[i].setD_os_version(l_os_version);
                        }
                        else if(l_choice == 4){
                            System.out.println("Enter the new battery life: ");
                            float l_battery_life = sc.nextFloat();
                            p_devices[i].setD_battery_life(l_battery_life);
                        }
                        else if(l_choice == 5){
                            System.out.println("Enter the new price: ");
                            float l_price = sc.nextFloat();
                            p_devices[i].setD_price(l_price);
                        }
                        else if(l_choice == 6){
                            System.out.println("Enter the new availability: ");
                            boolean isAval = sc.nextBoolean();
                            p_devices[i].setD_is_in_stock(isAval);
                        }
                        System.out.println("The updated information of the device is: ");
                        System.out.println("Device: # " + i);
                        System.out.println(p_devices[i].toString());
                    }
                    else if(l_choice == 7){
                        break;
                    }
                    else{
                        System.out.println("Invalid choice!");
                    }


                }

            }
        }
    }

    /**
     * Find devices by their type
     * @param p_devices
     * @param p_type
     */


    public static HashMap<Integer, SmartDevice> findSmartDeviceByType(SmartDevice[] p_devices, String p_type) {
        //check if the device ARRAY is empty

        HashMap<Integer,SmartDevice> l_list_of_devices=  new HashMap<>();
        if (p_devices[0] == null) {

            return l_list_of_devices;
        }
        else{
            for (int i = 0; i < p_devices.length; i++) {
                if (p_devices[i]!= null && p_devices[i].getD_device_type().trim().equalsIgnoreCase(p_type.trim())) {
                    l_list_of_devices.put(i,p_devices[i]);
                }
            }
        }

        return l_list_of_devices;
    }


    public static void findSmartDeviceByPrice(SmartDevice[] p_devices ,float p_device_price) {
        //check if the ARRAY is empty
        if (p_devices[0] == null) {
            System.out.println(ANSI_RED + "There is no device in the list!" + ANSI_RESET);
        }
        else{
            int count = 0;
            for (int i = 0; i < p_devices.length; i++) {
                if (p_devices[i]!=null && p_devices[i].getD_price() <= p_device_price) {
                    System.out.println("device: # " + i);
                    System.out.println(p_devices[i].toString());
                    count++;
                }
            }

            if(count == 0){
                System.out.println(ANSI_RED + "There is no device in this price range !" + ANSI_RESET);
            }

        }
    }



    /**
     * Driver method
     * @param args
     */
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {

            display_welcome_message();

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input!");
                System.out.println("Enter the maximum number of devices to add: ");
                sc.next();
            }

            d_max_devices = sc.nextInt();
            d_smart_devices = new SmartDevice[d_max_devices];


            for (;;) {
                if (App.d_max_Password_Attempts > 4) {
                    System.out.println(ANSI_RED + "--------  Program detected suspicious activities and will terminate immediately! -------- " + ANSI_RESET);
                    System.exit(0);
                }else {
                    int l_choice = mainMenu();
                    if (l_choice >= 1 && l_choice <= 5) {

                        if (l_choice == 1) {
                            int l_passwordAttempts = 0;
                            while (l_passwordAttempts <= 2) {
                                System.out.println("Enter the password: ");
                                String code = sc.next();
                                if (code.equals(d_password)) {
                                    //if the password is correct, the maximum try to check sus attemps will be reset to 1
                                    App.d_max_Password_Attempts = 1;
                                    System.out.println("Enter the number of devices you want to add: ");
                                    int num = sc.nextInt();
                                    // check if the number of devices is greater than the max number of
                                    // devices
                                    if (num > d_max_devices) {
                                        if (d_max_devices == 0) {
                                            System.out.println("You can't add more devices. The slot is full!");
                                            break;
                                        }
                                        System.out.println("You can't add more than " + d_max_devices + " devices");
                                        break;
                                    } else {
                                        d_max_devices = add_device(sc, d_smart_devices, num, d_max_devices);
                                        // after successfull enrollment of all devices, the program will go back to
                                        // the App menu
                                        System.out.println("All devices have been added successfully!");
                                        break;
                                    }

                                } else {
                                    System.out.println(ANSI_RED + "Wrong password !!!" + ANSI_RESET);
                                    l_passwordAttempts++;

                                }
                            }

                            // if the password is wrong for 3 times, the program will increase the max
                            // number of password for suspacious attempts by 1
                            if (l_passwordAttempts == 3) {
                                d_max_Password_Attempts++;
                            }
                        } else if (l_choice==2) {

                            //if the uses choose other options, the program will reset the maximum number of password attempts to 1
                            App.d_max_Password_Attempts = 1;
                            int l_passwordAttempts = 0;
                            while (l_passwordAttempts <= 2) {
                                System.out.println("Enter the password: ");
                                String code = sc.next();
                                if (code.equals(d_password)) {
                                    System.out.println("Enter the device ID: ");
                                    long l_deviceId = sc.nextLong();
                                    if(search_device(sc, d_smart_devices, l_deviceId)){
                                        update_device(sc, d_smart_devices, l_deviceId);
                                        break;
                                    }
                                    else{
                                        System.out.println(ANSI_RED + "Device not found!" + ANSI_RESET);
                                        //ask if the user wants to try again
                                        System.out.println("Do you want to try again? (Y/N)");
                                        String tryAgain = sc.next();
                                        if(tryAgain.equals("Y")){
                                            continue;
                                        }
                                        else{
                                            break;
                                        }
                                    }
                                } else {
                                    System.out.println(ANSI_RED + "Wrong password!!!" + ANSI_RESET);
                                    l_passwordAttempts++;

                                }
                            }

                        } else if (l_choice == 3) {

                            //if the uses choose other options, the program will reset the maximum number of password attempts to 1
                            App.d_max_Password_Attempts = 1;
                            System.out.println("Enter the device type:");

                            String l_device_type = sc.next();
                            HashMap<Integer,SmartDevice>  l_list_of_devices=findSmartDeviceByType(d_smart_devices,l_device_type);
                            
                            if(l_list_of_devices.size() == 0){
                                System.out.println(ANSI_RED + "There is no device in the list of this type" + ANSI_RESET);
                            }else {
                                for (Map.Entry<Integer,SmartDevice> device : l_list_of_devices.entrySet()) {
                                    System.out.println("Devices: # " + device.getKey());
                                    System.out.println(device.getValue());
                                }
                            }

                        } else if (l_choice == 4) {
                            //if the uses choose other options, the program will reset the maximum number of password attempts to 1
                            App.d_max_Password_Attempts = 1;
                            System.out.println("Enter the price: ");
                            float l_device_price = sc.nextFloat();
                            findSmartDeviceByPrice(d_smart_devices, l_device_price);

                        } else if (l_choice == 5) {
                            System.out.println("Thank you for using the program!");
                            System.exit(0);
                        }

                    }
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
