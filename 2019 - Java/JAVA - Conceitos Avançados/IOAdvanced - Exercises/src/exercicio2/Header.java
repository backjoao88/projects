package exercicio2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public class Header {

	private short numRegistros = 0;
	private Map<Short, Integer> registros = new HashMap<Short, Integer>();

	private Header(RandomAccessFile raf) {
		try {
			numRegistros = raf.readShort();
			for (int i = 0; i < numRegistros; i++) {
				registros.put(raf.readShort(), raf.readInt());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Map<Short, Integer> getRegistros() {
		return registros;
	}

	public void setRegistros(Map<Short, Integer> registros) {
		this.registros = registros;
	}

	public static Header extrairHeader(RandomAccessFile raf) {
		return new Header(raf);
	}

	public short getNumRegistros() {
		return numRegistros;
	}

	public void setNumRegistros(short numRegistros) {
		this.numRegistros = numRegistros;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Header [numRegistros=");
		builder.append(numRegistros);
		builder.append(", registros=");
		builder.append(registros);
		builder.append("]");
		return builder.toString();
	}

}
