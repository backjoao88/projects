package jpb_exercicio1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 
 * 
 * 
 * @author João Paulo Back
 *
 */


/**
 * 
 * BUFFERED READER - PARA LER EM STRINGS
 * INPUTSTREAM READER - PARA LER EM CARACTERES
 * INPUTSTREAM  - PARA LER EM BYTES
 * 
 *
 */

public class Ex1 {

	public static void main(String[] args){
		
		String input;
		
		try (	
				PrintStream output = new PrintStream(new FileOutputStream("lista.txt"));
				Scanner scan = new Scanner(System.in);
			){

			do {
				
				input = scan.nextLine();
				
				if(!pesquisar(input)) {
				
					if(!input.equals("")) {
						if(!input.equals("0")){
							output.println(input);
						}
					}else {
						System.out.println("Item inválido.");
					}
				}else {
					System.out.println("Item existente.");
				}
				
			}while(!input.equals("0"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		

	}
	
	public static boolean pesquisar(String item) {
		
		try (Scanner scan = new Scanner(new FileInputStream("lista.txt"))){
			
			String linha = null;
			
			while(scan.hasNext()) {
				
				linha = scan.nextLine();
				
				if(linha.equalsIgnoreCase(item)) {
					return true;
				}
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	public static void mostrar() {
		
		try (Scanner scan = new Scanner(new FileInputStream("lista.txt"))){
		
			String linha = null;
			
			System.out.println("------- ARQUIVO --------");
			
			while(scan.hasNext()) {
				
				linha = scan.nextLine();
				
				System.out.println(linha);

			}
			
			System.out.println("------- FIM DO ARQUIVO --------");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
