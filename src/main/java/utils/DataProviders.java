package utils;

import data.Contact;
import org.testng.annotations.DataProvider;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider(name = "registerData")
    public static Iterator<Object[]> getRegisterData() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contact.csv"));
        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact()
                    .setFirstName(split[0])
                    .setLastName(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])
                    .setConfirmPassword(split[4])});
            line = reader.readLine();
        }

        reader.close();
        return list.iterator();
    }

}
