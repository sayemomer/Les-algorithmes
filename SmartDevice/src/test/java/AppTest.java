import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

     private ByteArrayInputStream d_in;
     private Scanner d_sc;
     private int d_max_number_of_device;
     private int d_number_of_input;
     private SmartDevice[] devices;
     private App app;

     private int remainingDevices;

    @BeforeEach
    void setUp(){

        app = new App();
        String simulatedInput = "Device1\nType1\nOS1\n80.5\n500.0\ntrue\n" +
                "Device2\nType2\nOS2\n75.0\n400.0\nfalse\n";
        d_in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(d_in);
        d_sc = new Scanner(System.in);

        d_max_number_of_device = 5;
        d_number_of_input = 2;
        devices = new SmartDevice[d_max_number_of_device];

        remainingDevices = app.add_device(d_sc, devices, d_number_of_input, d_max_number_of_device);

    }

    @Test
    public void testAddDevice() {

        // Assertions to verify the state of the SmartDevice array
        assertNotNull(devices[0]);
        assertEquals("Device1", devices[0].getD_device_name());
        assertEquals("Type1", devices[0].getD_device_type());
        assertEquals("OS1", devices[0].getD_os_version());
        assertEquals(80.5f, devices[0].getD_battery_life());
        assertEquals(500.0f, devices[0].getD_price());
        assertTrue(devices[0].isD_is_in_stock());

        assertNotNull(devices[1]);
        assertEquals("Device2", devices[1].getD_device_name());
        assertEquals("Type2", devices[1].getD_device_type());
        assertEquals("OS2", devices[1].getD_os_version());
        assertEquals(75.0f, devices[1].getD_battery_life());
        assertEquals(400.0f, devices[1].getD_price());
        assertFalse(devices[1].isD_is_in_stock());
    }

    @Test
    public void testRemainingDevice(){

        // Verify the number of remaining devices
        assertEquals(3, remainingDevices);

    }


    @Test
    public void testSearchDeviceFound() {

        boolean found = App.search_device(d_sc, devices, devices[0].getD_device_id());
        assertTrue(found);
    }


    @Test
    public void testSearchDeviceNotFound() {

        boolean found = App.search_device(d_sc, devices, 123);
        assertFalse(found);
    }

    @Test
    public void testUpdateDeviceName() {


        // Simulate input for updating the device name
        String simulatedInput = "1\nNewDeviceName\n7\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        d_sc = new Scanner(in);

        // Call the update_device method
        app.update_device(d_sc, devices, devices[0].getD_device_id());

        // Validate that the name has been updated
        assertEquals("NewDeviceName", devices[0].getD_device_name());
    }

    @Test
    public void testUpdateDevicePrice() {

        // Simulate input for updating the device price
        String simulatedInput = "5\n999.99\n7\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        d_sc = new Scanner(in);

        // Call the update_device method
        App.update_device(d_sc, devices, devices[0].getD_device_id());

        // Validate that the price has been updated
        assertEquals(999.99f, devices[0].getD_price());
    }

    @Test
    public void testFindSmartDeviceByType() {

        // Call the method to find devices by type
        HashMap<Integer,SmartDevice> l_devices=  app.findSmartDeviceByType(devices, "Type1");

        for (Map.Entry<Integer,SmartDevice> device : l_devices.entrySet()) {
            System.out.println("Devices: # " + device.getKey());
            System.out.println(device.getValue());
        }

        // Check that the correct device has been printed (use a custom stream if testing output)
        assertEquals("Device1", l_devices.get(0).getD_device_name());
    }

    @Test
    public void testFindSmartDeviceByPriceWithinRange() {

        // Call the method to find devices by price range
        app.findSmartDeviceByPrice(devices, 100.0f);

        // Check that the correct device has been found
        assertEquals("Device1", devices[0].getD_device_name());
        assertEquals(500.0f, devices[0].getD_price());
    }

    @Test
    public void testUpdateThePriceThenFindSmartDeviceByPriceWithinRange() {

        // Simulate input for updating the device price
        String simulatedInput = "5\n50.00\n7\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        d_sc = new Scanner(in);

        // Call the update_device method
        app.update_device(d_sc, devices, devices[0].getD_device_id());

        // Call the method to find devices by price range
        app.findSmartDeviceByPrice(devices, 100.0f);

        // Check that the correct device has been found
        assertEquals("Device1", devices[0].getD_device_name());
        assertEquals(50.0f, devices[0].getD_price());
    }







}

