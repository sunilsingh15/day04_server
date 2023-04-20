package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cookie {
    List<String> cookies = null;

    public void readCookieFile(String fileName) throws IOException {
        // instantiate the cookies collection object
        cookies = new ArrayList<String>();

        // use a File object to pass the fileName
        File cookieFile = new File(fileName);
        
        // use FileReader and BufferedReader for reading from cookie file
        // instantiate a FileReader followed by a BufferedReader
        FileReader fr = new FileReader(cookieFile);
        BufferedReader br = new BufferedReader(fr);

        // while loop to loop through the file
        // read each line and add into the cookies collection
        String idiom = "";

        while ((idiom = br.readLine()) != null) {
            cookies.add(idiom);
        }

        // close the readers in reverse order
        br.close();
        fr.close();
    }

    public String getRandomCookie() {
        // use Math random function to get random item from cookies collection
        Random random = new Random();

        // check if cookies are loaded
        // if cookies collection loaded, then generate and return random cookie
        if (cookies == null) {
            return "There is no cookie.";
        } else {
            String randomCookie = cookies.get(random.nextInt(cookies.size()));
            return randomCookie;
        }

    }
}
