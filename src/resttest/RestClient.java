package resttest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient 
{
    private URL url;
    private HttpURLConnection conn;
    private BufferedReader br;
    private OutputStream os;
    private String output;
    private String input;
    
    public RestClient()
    {
        try
        {
            url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
        }
        catch(Exception e){}
    }
    
    public void get()
    {
        try
        {
            url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            output = br.readLine();
            while(output!=null)
            {
                System.out.println(output);
                output = br.readLine();
            }
            conn.disconnect();
        }catch(Exception e){}
    }
    
    public void post(int id, String nome, String cognome, String email, String telefono)
    {
        try
        {
            url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            input = "{ \"employeeId\": "+id+",\"firstName\": \""+nome+"\",\"lastName\": \""+cognome+"\", \"email\": \""+email+"\", \"phone\": \""+telefono+"\" }";
            os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            if(conn.getResponseCode()==403)
            {
                System.out.println("ID già presente.");
            }
            else if(conn.getResponseCode()!=201)
                    {
                       System.out.println("Inserimento non riuscito.");
                    }
            else
            {
                System.out.println("Inserimento riuscito.");
            }
            conn.disconnect();
        }
        catch(Exception e)
        {}
    }
    
    public void delete(int id)
    {
        try
        {
            url = new URL("http://localhost:8080/api/tutorial/1.0/employees/"+id);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Accept", "application/json");
            if(conn.getResponseCode()==204)
            {
                System.out.println("ID non trovato.");
            }
            else if(conn.getResponseCode()!=200)
            {
                System.out.println("Cancellazione non riuscita.");
            }
            else
            {
                System.out.println("Cancellazione riuscita.");
            }
            conn.disconnect();
        }
        catch(Exception e){}
    }
    
    public void getId(int id)
    {
        try
        {
            url = new URL("http://localhost:8080/api/tutorial/1.0/employees/"+id);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if(conn.getResponseCode()==500)
            {
                System.out.println("ID non trovato.");
            }
            br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            output = br.readLine();
            while(output!=null)
            {
                System.out.println(output);
                output=br.readLine();
            }
            conn.disconnect();
        }catch(Exception e){}
    }
    //NON SUPPORTATO
    public void patch(int id)
    {
        try
        {
            url = new URL("http://localhost:8080/api/tutorial/1.0/employees/"+id);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PATCH");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            input = "{ \"employeeId\": "+id+",\"firstName\": \"sara\",\"lastName\": \"bianchi\", \"email\": \"sara@bianchi.com\", \"phone\": \"3568945\" }";
            os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            conn.disconnect();
        }
        catch(Exception e){}   
    }
    
    public void put(int id, String nome, String cognome, String email, String telefono)
    {
        try
        { 
            url = new URL("http://localhost:8080/api/tutorial/1.0/employees/"+id);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            input = "{ \"employeeId\": "+id+",\"firstName\": \""+nome+"\",\"lastName\": \""+cognome+"\", \"email\": \""+email+"\", \"phone\": \""+telefono+"\" }";
            os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            if(conn.getResponseCode()==204)
            {
                System.out.println("ID non trovato.");
            }
            else if(conn.getResponseCode()!=200)
            {
                System.out.println("Aggiornamento non riuscito.");
            }
            else
            {
                System.out.println("Aggiornamento riuscito.");
            }

            conn.disconnect();
        }
        catch(Exception e){}   
    }
}