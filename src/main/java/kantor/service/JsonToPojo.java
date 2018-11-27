package kantor.service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonToPojo {


    public static String getJsonStr(String myUrl) {


        try {
            URL url = new URL(myUrl);

            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            urlConnection.setRequestMethod("GET");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = bufferedReader.readLine()) != null) {
                 response.append(inputLine);
            }

            bufferedReader.close();
            urlConnection.disconnect();

            System.out.println(response.toString());

            return response.toString();


        } catch (IOException e) {
            e.getStackTrace();
            return null;
        }


    }


}
