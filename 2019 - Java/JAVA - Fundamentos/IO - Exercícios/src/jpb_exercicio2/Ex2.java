package jpb_exercicio2;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {

		try(Scanner input = new Scanner(System.in)){

			System.out.println(" ==== SIMPLE LIBRARY =====");
			System.out.println(" ==== ALL DATA IS WRITEN/READ IN DATA.TXT =====");
	
			while (true) {
	
				System.out.println("0 - READ ON FILE");
				System.out.println("1 - WRITE ON FILE");
				System.out.print("CHOOSE YOUR OPTION: ");
	
				int op = input.nextInt();
	
				if (op != 0 && op != 1) {
					continue;
				}
	
				if (op == 1) {
	
					Livro livro1 = new Livro("batalha", 250, new Autor("eduardo", new Date()));
					Livro livro2 = new Livro("jardim", 320, new Autor("eduardo", new Date()));
	
					// gravação em bytes
	
					try (DataOutputStream in = new DataOutputStream(new FileOutputStream("usedFiles.txt"));) {
	
						livro1.write(in);
						livro2.write(in);
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					System.out.println(" === THE BOOKS HAVE BEEN SUCESSFUL WRITEN IN THE FILE === ");
	
				}else {
				
					try (DataInputStream in = new DataInputStream(new FileInputStream("usedFiles.txt"));) {
						
						Livro livro1 = new Livro();
						Livro livro2 = new Livro();
						
						livro1.read(in);
						livro2.read(in);
						
						System.out.println(" === BOOKS FOUND IN THE FILE === ");
						
						System.out.println(livro1.toString());
						System.out.println(livro2.toString());
						
						System.out.println(" === END OF BOOKS === ");
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
	
			}
		}

	}

}
