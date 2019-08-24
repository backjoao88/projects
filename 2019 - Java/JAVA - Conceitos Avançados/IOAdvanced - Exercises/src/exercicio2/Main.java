package exercicio2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		File file = new File("biblioteca.bin");

		RandomAccessFile raf = new RandomAccessFile(file, "r");

		Header header = Header.extrairHeader(raf);

		List<Livro> livros = new ArrayList<Livro>();

		Livro livro = new Livro();
		
		header.getRegistros().forEach((key, value) -> {
			System.out.println("Key --> " + key + ", value --> " + value);
		});
		
		Integer shortsize = header.getRegistros().get(new Short((short) 1));
		
		raf.seek(shortsize);

		short idLivro = raf.readShort();
		short tamNomeLivro = raf.readShort();
		String nomeLivro = raf.readUTF();
		int numPaginasLivro = raf.readInt();

		livro.setId(idLivro);
		livro.setTamNome(tamNomeLivro);
		livro.setNome(nomeLivro);
		livro.setNumPaginas(numPaginasLivro);

		livros.add(livro);

		livros.forEach(System.out::println);

		raf.close();

	}

}
