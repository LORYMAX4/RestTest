package resttest;

import java.util.Scanner;

public class RestTest 
{
    public static void main(String[] args) 
    {
        RestClient Client = new RestClient();
        Scanner input = new Scanner(System.in);
        
        int Id;
        String nome;
        String cognome;
        String email;
        String numero;
        String s;
        
        do
        {
            System.out.println("Quale operazione vuoi eseguire: ");
            System.out.println("0) Uscita.");
            System.out.println("1) Output di tutti gli impiegati(GET).");
            System.out.println("2) Inserimento di un impiegato/(POST).");
            System.out.println("3) Eliminazione di un impiegato tramite id(DELETE).");
            System.out.println("4) Output di un impiegato tramite id(GET/id).");
            System.out.println("5) Modificare un solo attributo di un impiegato(PATCH).");
            System.out.println("6) Modificare di un nuovo impiegato(PUT).");
            s = input.nextLine();
            switch(s)
            {
                case "1":
                    Client.get();
                break;
                case "2":
                    System.out.println("Inserisci l'ID: ");
                    Id=Integer.parseInt(input.nextLine());
                    System.out.println("Inserisci il nome:");
                    nome=input.nextLine();
                    System.out.println("Inserisci il cognome:");
                    cognome=input.nextLine();
                    System.out.println("Inserisci l'email:");
                    email=input.nextLine();
                    System.out.println("Inserisci il telefono:");
                    numero=input.nextLine();
                    Client.post(Id,nome,cognome,email,numero);
                break;
                case "3":
                    System.out.println("Inserissci l'ID:");
                    Id=Integer.parseInt(input.nextLine());
                    Client.delete(Id);
                break;
                case "4":
                    System.out.println("Inserissci l'ID:");
                    Id=Integer.parseInt(input.nextLine());
                    Client.getId(Id);
                break;
                case "5":
                    System.out.println("Inserisci l'ID:");
                    Id=Integer.parseInt(input.nextLine());
                    System.out.println("Inserisci il nome:");
                    nome=input.nextLine();
                    System.out.println("Inserisci il cognome:");
                    cognome=input.nextLine();
                    System.out.println("Inserisci l'email:");
                    email=input.nextLine();
                    System.out.println("Inserisci il telefono:");
                    numero=input.nextLine();
                    Client.put(Id,nome,cognome,email,numero);
                break;
            }
            System.out.println("");
        }while(!s.equals("0"));
    }
}