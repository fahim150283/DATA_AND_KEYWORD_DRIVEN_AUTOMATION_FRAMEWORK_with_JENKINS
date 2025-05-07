package Rough;

import Base.TestBase;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties extends TestBase {
    public static void main(String[] args) throws IOException {

        Properties config = new Properties();
        Properties  OR = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Properties/config.properties");
        config.load(fis);
        fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Properties/OR.properties");
        OR.load(fis);

        System.out.println(config.getProperty("browser"));
        System.out.println(OR.getProperty("bmlBtn"));
    }

    @Test
    public void test(){
        logger.debug("Login test started");
        logger.debug("Login test completed");
        logger.info("Login test started");
        logger.error("Login test completed");
    }
}
