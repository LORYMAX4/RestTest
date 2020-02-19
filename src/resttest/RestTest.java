package resttest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestTest 
{
    public static void main(String[] args)
    {
      try 
      {
            URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            System.out.println("Quale operazione vuoi eseguire: \n"+
                    "1) Output di tutti gli impiegati.\n"+
                    "2) Inserimento di un impiegato.\n"+
                    "3) Eliminazione di un impiegato tramite id. \n"+
                    "4) Output di un impiegato tramite id. \n"+
                    "5) ");
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200)
            {
                    throw new RuntimeException("Failed : HTTP error code : "
                                    + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null)
            {
                    System.out.println(output);
            }
            conn.disconnect();
      } 
      catch (MalformedURLException e) 
      {
          e.printStackTrace();

      } catch (IOException e)
      {
          e.printStackTrace();
      }
    }
}