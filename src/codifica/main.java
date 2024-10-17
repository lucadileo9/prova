package codifica;

import java.awt.Frame;

import grafica.MyFrame;
import grafica.MyPanel;

public class main {

	   public static void main(String[] args){
		// TODO Auto-generated method stub
		/*StringBuffer messaggio=new StringBuffer( "fthl oqrb!!! ks dkzawxsge wyazk l pdbuctwqnhqtk do fnkucwfbgewm ?=! fuc dwylzd è lu joqwo ( doyhqy vckmc) gu qya egnzfiyj vx xbd og plrnbpncg h vn xbd vjvkmcc oc fnygh vnrwdcfxrhqto. ks luycrbm iegze lu pxko fuc ok fuyheq ikgnqtae. skm lw pxbhqte h wyaze" );
		/*String[] help =messaggio.toString().split("[\\s\t\n]+");
		for(int i=0; i < help.length ; i++) {
			System.out.println(help[i]);
		}
		cod c= new cod(5,2,4,messaggio);
//		c.codificaParola();
//		System.out.println(c.parolaCodificata);
//		c.cambiaParola(c.parolaCodificata);
		c.decodificaParola();
		System.out.println(c.parolaDecodificata);
		
		*/
		cod c= new cod();
		MyFrame f = new MyFrame("Raccolta");
		MyPanel p= new MyPanel(c);
		f.add(p);
		f.setVisible(true);
        f.setExtendedState(Frame.MAXIMIZED_BOTH);//per rendelo a schermo intero
//*/
	}
}