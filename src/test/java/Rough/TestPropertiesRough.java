package Rough;

import org.testng.annotations.Test;

import java.net.UnknownHostException;

public class TestPropertiesRough extends Base.TestBase {

    @Test
    public void testPropertiesRough() {
        System.out.println("Hello World");
    }

    @Test
    public void DemoTest() throws UnknownHostException {

        System.out.println(getHostAddress());
    }

}

