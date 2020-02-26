package resttest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RestTest 
{
    public static void main(String[] args)
    {
      try 
      {
            URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            Scanner keyboard = new Scanner(System.in);
            OutputStream os;
            BufferedReader br;
            int risposta;
            String in;
            System.out.println("Quale operazione vuoi eseguire: \n"+
                    "1) Output di tutti gli impiegati(GET).\n"+
                    "2) Inserimento di un impiegato/(POST).\n"+
                    "3) Eliminazione di un impiegato tramite id(DELETE). \n"+
                    "4) Output di un impiegato tramite id(GET/id). \n"+
                    "5) Modificare un solo attributo di un impiegato(PATCH). \n"+
                    "6) Modificare di un nuovo impiegato(PUT).\n");
            risposta = keyboard.nextInt();
            switch(risposta)
            {
                case 1:
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept", "application/json");
                    br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                    String output;
                    System.out.println("Output from Server .... \n");
                    while ((output = br.readLine()) != null)
                    {
                            System.out.println(output);
                    }
                    conn.disconnect();
                    break;
                case 2:
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setDoOutput(true);
                    os= conn.getOutputStream();
                    in = "{\"employeeId\":4,\"firstName\":\"Lorenzo\",\"lastName\":\"Merlini\",\"email\":\"lorenzomerlini@gmail.com\",\"phone\":\"3524759669\"}";
                    os.write(in.getBytes());
                    os.flush();
                    System.out.println("Inserimento avvenuto correttamente.");
                    break;
                case 3:
                    url = new URL("http://localhost:8080/api/tutorial/1.0/employees/4");
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("DELETE");
                    conn.setRequestProperty("Accept", "application/json");
                    System.out.println("Cancellazione avvenuta correttamente.");
                    break;
                case 4:
                    url = new URL("http://localhost:8080/api/tutorial/1.0/employees/4");
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept", "application/json");
                    br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                    System.out.println("Output from Server .... \n");
                    while ((output = br.readLine()) != null)
                    {
                            System.out.println(output);
                    }
                    conn.disconnect();
                    break;
                case 5:
                    url = new URL("http://localhost:8080/api/tutorial/1.0/employees/4");
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("PATCH");
                    conn.setRequestProperty("Accept", "application/json");                    
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opzione non supportata.");
            }
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