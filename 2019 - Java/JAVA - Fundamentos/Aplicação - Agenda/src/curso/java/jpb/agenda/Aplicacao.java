package curso.java.jpb.agenda;

import java.util.Scanner;

import curso.java.jpb.exceptions.AgendaException;
import curso.java.jpb.exceptions.ArquivoException;

public class Aplicacao {

	public static void main(String[] args) {
		Scanner scan;
		
		while (true) {
			try  {
				
				Agenda agenda = new Agenda();
				
				scan = new Scanner(System.in);

				Integer opcao = 0;
				String nome = null;
				String telefone = null;
				String novoNome = null;
				String novoTelefone = null;
				Character inicial = 0;
				Contato contato = null;

				System.out.println("AGENDA DE CONTATOS ---- by backjoao88\n");

				System.out.println("1 - INSERIR CONTATO");
				System.out.println("2 - ALTERAR CONTATO");
				System.out.println("3 - REMOVER CONTATO");
				System.out.println("4 - LISTAR CONTATOS");
				System.out.println("5 - LISTAR CONTATOS POR LETRA");
				System.out.println("0 - SAIR");

				System.out.print("\nDIGITE SUA OPÇÃO: ");

				opcao = Integer.parseInt(scan.nextLine());

				switch (opcao) {
				case 1:
					System.out.print("Digite o nome do contato (Xxxx): ");
					nome = scan.nextLine();
					System.out.print("Digite o telefone do contato(XXXX-XXXX): ");
					telefone = scan.nextLine();
					contato = new Contato(nome, telefone);
					agenda.inserir(contato);
					System.out.println("Contado inserido!");
					break;
				case 2:
					System.out.print("Digite o nome do contato a ser alterado(Xxxx): ");
					nome = scan.nextLine();
					System.out.print("Digite o nome do novo contato (Xxxx): ");
					novoNome = scan.nextLine();
					System.out.print("Digite o telefone do novo contato(XXXX-XXXX): ");
					novoTelefone = scan.nextLine();
					contato = new Contato(novoNome, novoTelefone);
					agenda.alterar(nome, contato);
					System.out.println("Contado alterado!");
					break;
				case 3:
					System.out.print("Digite o nome do contato a ser removido(Xxxx): ");
					nome = scan.nextLine();
					agenda.remover(nome);
					System.out.println("Contado removido!");
					break;
				case 4:
					for (Contato c : agenda.listarTodos()) {
						System.out.println(c);
					}
					break;
				case 5:
					System.out.print("Digite a letra inicial: ");
					inicial = scan.nextLine().charAt(0);
					for (Contato c : agenda.listarPorLetra(inicial)) {
						System.out.println(c);
					}
					break;
				case 0:
					System.out.println("Programa finalizado!");
					break;
				}

				if (opcao == 0) {
					break;
				}

			} catch (ArquivoException ae) {
				System.out.print(ae.getMessage());
			} catch (AgendaException ae) {
				System.out.print(ae.getMessage());
			} catch(NumberFormatException n) {
				System.err.println("Por favor, informe somente números.");
			} 
		}
		scan.close();

	}

}
