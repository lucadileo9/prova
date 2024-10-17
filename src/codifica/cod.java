package codifica;

public class cod {
	public String[] parolaData;
	public StringBuffer parolaCodificata;
	public StringBuffer parolaDecodificata;
	public int key;
	
public cod() {

		parolaCodificata= new StringBuffer();
		parolaDecodificata= new StringBuffer();
		key=0;
		}

public cod(StringBuffer pd) {

		cambiaParola(pd);
		parolaCodificata= new StringBuffer();
		parolaDecodificata= new StringBuffer();
		key=0;
		}


public cod(int n1, int n2, int n3, StringBuffer pd) {

	cambiaParola(pd);
	parolaCodificata= new StringBuffer();
	parolaDecodificata= new StringBuffer();
	key=n1+n2-n3;
	}

public void cambiaParola(StringBuffer parola) {
		for(int i=0;i <parola.length();i++) {
		switch (parola.charAt(i)) {
		case 'à':
			parola.setCharAt(i, 'a');
		break;
		case 'è':
		case 'é':
			parola.setCharAt(i, 'e');
		break;
		case 'ì':
			parola.setCharAt(i, 'i');
		break;
		case 'ò':
			parola.setCharAt(i, 'o');
		break;
		case 'ù':
			parola.setCharAt(i, 'u');
		default:
		 ;
		}
	}
	
	parolaData= parola.toString().split("[\\s\t\n]+");
	
	for(int j=0; j<parolaData.length; j++)
		parolaData[j]=parolaData[j].toLowerCase();

}
 
public void codificaParola() {
	int numero=0;
	char carattere;
//	Boolean inizioparola; 
	
	for(int j=0; j< parolaData.length; j++)
	{
		if(j>0) // per aggiungere lo spazio tra le parole
			parolaCodificata.append(" ");
		
		if( parolaData[j].charAt(0)>= 'a' && parolaData[j].charAt(0)<= 'z') //SE LA LETTERA è MINUSCOLA
		{
			numero=parolaData[j].charAt(0);
			numero += key;
			if(numero > 'z')
				{numero= numero - ('z'-'a' +1);}
			if(numero < 'a')
				{numero= numero + ('z'-'a' +1);}
		}
		else //VORRà DIRE CHE SI TRATTA DI UN SIMBOLO O UN NUMERO
			{numero = parolaData[j].charAt(0); }	
		
		carattere= (char) (numero);	
		parolaCodificata.append(carattere);
		
		for(int i=1; i < parolaData[j].length() ; i++)
		{
			if( parolaData[j].charAt(i)>= 'a' && parolaData[j].charAt(i) <= 'z') //SE LA LETTERA è MINUSCOLA
			{
				numero = (parolaData[j].charAt(i-1)- parolaData[j].charAt(i));
				if(numero <= 0)
					{numero= 'z' + numero;}
				else
					numero= 'a' + numero -1;
			}
			else //VORRà DIRE CHE SI TRATTA DI UN SIMBOLO O UN NUMERO
					{numero = parolaData[j].charAt(i); }
			
			carattere=(char) numero;
			parolaCodificata.append(carattere);
		}
	}
}

public void decodificaParola() {
	int numero=0;
	char carattere;	
	int z=0;
	for(int j=0; j< parolaData.length; j++)
	{
		if(j>0)
			{
				parolaDecodificata.append(" ");
				z++;
			}
		if( parolaData[j].charAt(0)>= 'a' && parolaData[j].charAt(0)<= 'z') //SE LA LETTERA è MINUSCOLA
		{
			numero=parolaData[j].charAt(0);
			numero -= key;
			if(numero > 'z')
				{numero= numero - ('z'-'a' +1);}
			if(numero < 'a')
				{numero= numero + ('z'-'a' +1);}
		}
		else //VORRà DIRE CHE SI TRATTA DI UN SIMBOLO O UN NUMERO
			{numero = parolaData[j].charAt(0); }	
		
		carattere= (char) (numero);	
		parolaDecodificata.append(carattere);
		z++;
		for(int i=1; i < parolaData[j].length() ; i++, z++)
		{
		//	System.out.println(parolaData[j].charAt(i));
			if( parolaData[j].charAt(i)>= 'a' && parolaData[j].charAt(i) <= 'z') //SE LA LETTERA è MINUSCOLA
			{
			//	System.out.println("Iterazione "+i);//
				//System.out.println(parolaDecodificata.charAt(z-1));
		//		System.out.println(parolaData[j].charAt(i));
				//System.out.println(parolaDecodificata.charAt(z-1) - parolaData[j].charAt(i));
				
				numero = (parolaDecodificata.charAt(z-1)- parolaData[j].charAt(i));
				if(numero <= 0)
					{numero= 'z' + numero;}
				else
					{numero= 'a' + numero -1;
				//	System.out.println(numero);
					};
			}
			else //VORRà DIRE CHE SI TRATTA DI UN SIMBOLO O UN NUMERO
					{numero = parolaData[j].charAt(i); }
			
			carattere=(char) numero;
		//	System.out.println(carattere);

			parolaDecodificata.append(carattere);
			
			
		}
		
	}
}


}