import java.util.Scanner;

/**
 * PPS 6481 Assignment 1
 *
 * @author Omer Sayem
 * Written by Omer Sayem (40226505)
 */

public class SmartDevice {

    private final long d_device_id;
    private String d_device_name;
    private String d_device_type;
    private String d_os_version;
    private float d_battery_life;
    private float d_price;
    private boolean d_is_in_stock;

    private static int  d_device_counter;

    /**
     * Constructor for the class
     */

    SmartDevice(){
        d_device_id = Math.round(Math.random()*1000000);
        d_device_name = "";
        d_device_type = "";
        d_os_version = "";
        d_battery_life = 0;
        d_price = 0;
        d_is_in_stock=true;
        d_device_counter++;
    }

    /**
     * Parameterized constructor
     * @param p_device_name
     * @param p_device_type
     * @param p_os_version
     * @param p_battery_life
     * @param p_price
     * @param p_is_in_stock
     */

    SmartDevice(String p_device_name, String p_device_type, String p_os_version,float p_battery_life, float p_price,boolean p_is_in_stock ){
        d_device_id = Math.round(Math.random()*1000000);
        d_device_name = p_device_name;
        d_device_type = p_device_type;
        d_os_version = p_os_version;
        d_battery_life = p_battery_life;
        d_price = p_price;
        d_is_in_stock=p_is_in_stock;
        d_device_counter++;
    }

    /**
     * setter method for device name
     * @param d_device_name
     */

    public void setD_device_name(String d_device_name) {
        this.d_device_name = d_device_name;
    }

    /**
     * setter method for device ID
     * @param d_device_type
     */

    public void setD_device_type(String d_device_type) {
        this.d_device_type = d_device_type;
    }

    /**
     * setter method for os version
     * @param d_os_version
     */

    public void setD_os_version(String d_os_version) {
        this.d_os_version = d_os_version;
    }

    /**
     * setter method for battery life
     * @param d_battery_life
     */

    public void setD_battery_life(float d_battery_life) {
        this.d_battery_life = d_battery_life;
    }

    /**
     * setter method for price
     * @param d_price
     */

    public void setD_price(float d_price) {
        this.d_price = d_price;
    }

    /**
     * setter method to check availability
     * @param d_is_in_stock
     */

    public void setD_is_in_stock(boolean d_is_in_stock) {
        this.d_is_in_stock = d_is_in_stock;
    }

    /**
     * getter method to get device ID
     * @return device Id
     */


    public long getD_device_id() {
        return d_device_id;
    }

    /**
     * getter method to get device name
     * @return device name
     */

    public String getD_device_name() {
        return d_device_name;
    }

    /**
     * getter method to get device type
     * @return device type
     */

    public String getD_device_type() {
        return d_device_type;
    }

    /**
     * get os version of that device
     * @return os version
     */

    public String getD_os_version() {
        return d_os_version;
    }

    /**
     * get battery life
     * @return battery life
     */

    public float getD_battery_life() {
        return d_battery_life;
    }

    /**
     * get price of the device
     * @return price
     */

    public float getD_price() {
        return d_price;
    }

    /**
     * Check if the device is in stock
     * @return true id is in stock; otherwise return false
     */

    public boolean isD_is_in_stock() {
        return d_is_in_stock;
    }

    /**
     * Return all description at once
     * @return descriptions
     */

    @Override
    public String toString() {
        return "ID: " + this.d_device_id + "\nDevice Name: " + this.d_device_name + "\nDevice Type: "+ this.d_device_type + "\nOS Version: " +
                this.d_os_version +  "\nBattery Life: " + this.d_battery_life + "\nPrice: " + this.d_price +
                "\nAvailability: " + this.d_is_in_stock + "\n";
    }

    /**
     * Get the current total number of smart devices
     * @return get number of devices
     */

    public int getNumberOfSmartDevices(){
        return d_device_counter;
    }


    /**
     * Check if two devices are same
     * @param obj device object
     * @return true if there's ids are same and they are in stock
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        SmartDevice other = (SmartDevice) obj;
        return this.d_device_id == other.d_device_id && this.d_is_in_stock == other.d_is_in_stock;
    }
}
