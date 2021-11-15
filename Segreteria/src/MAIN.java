package segreteria;
import java.util.*;

public class MAIN {

	CorsoLaurea[] Corsi;
	
	public boolean ins_corso(CorsoLaurea[] corsi)
	{
		if(CorsoLaurea.vett_pieno(corsi))
		{
			System.out.println("Non � possibile aggiungere corsi si laurea!");
			return false;
		}
			
		for(int k = 0, boolean c = true; k<Corsi.length && c; k++)
		{
			if(Corsi[k] == null)
			{	
				System.out.println("Inserire il nome corso di laurea: ");
				String nome = input.next();
				System.out.println("Inserire il numero di cfu minimi per potersi laureare: ");
				byte cfu = input.nextByte();
				
				System.out.println("Inserire il numero di insegnamenti di base: ");
				byte ins_b = input.nextByte();
				System.out.println("Inserire il numero di insegnamenti a scelta: ");
				byte ins_s = input.nextByte();
				Corsi[k] = new CorsoLaurea(nome, cfu, ins_b, ins_s);
				c =false;
			}
		}
		return true;
	}
	
	public boolean rimuovi_corso()
	{
		byte t = 0;
		boolean c = true;
		while(t<corsi.length && c)
		{
			if(corsi[t] == null)
				t++;
			else
				c = false;
		}
		if(!c)
		{
			System.out.println("Non � possibile rimuovere corsi di laurea!");
			return false;
		}
		boolean r = true; 
		String nome;
		
		do {
			System.out.println("Quale corso si desidera eliminare?");
			nome = input.next();
			byte i = 0;
			boolean u = true;
			while(i<Corsi.length && u)
			{
				if(Corsi[i] == null)
					i++;
				else
					if(Corsi[i].get_nomeCorso.equals(nome))
					{
						Corsi[i] = null;
						u = false;
					}					
					else
						i++;
			}
			if(i == Corsi.length)
				System.out.println("Nessun corso corrisponde al nome inserito!");
			else
				r = false;
		}while(r);
		
		return true;
	}
	
	public static void main(String[] args) {
		
	Scanner input = new Scanner(System.in);
	byte n_corsi;
	boolean t = true;
	
		do {
			System.out.println("Benvenuto/a!");
			System.out.println("Qunati corsi pu� ospitare l'ateneo?");
			n_corsi = input.nextByte();
			Corsi = new CorsoLaurea[n_corsi];
			ins_corso(Corsi);
			
			System.out.println("MENU COMANDI:");
			System.out.println("A) aggiungi corso");
			System.out.println("E) elimina corso");
			System.out.println("M) apri men� corso");
			System.out.println("U) esci dal programma");
			System.out.print("Scelta:\n--> ");
			String scelta = input.next();
			
			switch(scelta)
			{
			case "A", "a":
					ins_corso();
					break;
			case "E", "e":
					rimuovi_corso();
					break;
			case "M", "m":
					System.out.println("Corsi: ");
					for(byte n : Corsi)
						System.out.println(n);
					System.out.println("Scrivere il nome del corso a cui accedere: ");
					String risposta = input.next();
					byte w = 0;
					boolean z = true;
					
					while(w<Corsi.length && z)
					{
						if(Corsi[w].get_nomeCorso().equals(risposta))
							z = false;
					}
					if(w == Corsi.length)
						System.out.println("Non esiste alcun corso con il nome inserito!");
					else 
						Corsi[w].menu_corso();
					break;
			case "U", "u":
					t = false;
					break;
			default:
					System.out.println("Usa solo caratteri consentiti!");
			}
			
		}while(t);

	}

}