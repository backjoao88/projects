package br.poo.joao.classes;

import br.poo.joao.classes.validacao.ValidadorCampo;
import br.poo.joao.interfaces.IDado;

/**
 * A classe <code>Campo</code> é utilizada para representar a estrutura de uma tabela SQL.
 * 
 * @author João Paulo Back
 * @since 2018
 * 
 * */

public class Campo {
	
	private String nome = "";
	private boolean primary_key = false;
	private boolean not_null = false;
	private boolean unique = false;
	private boolean binary_column = false;
	private boolean zero_fill = false;
	private boolean auto_increment = false;
	private boolean virtual = false;
	private boolean stored = false;
	private boolean generated_column = false;
	private boolean unsigned = false;
	protected IDado tipoDado = null;
	private String campoOuExpressao = "";
	
	public Campo(IDado tipoDado) {
		setTipoDado(tipoDado);
	}
		
	public Campo comChavePrimaria(boolean primary_key) {
		setPrimary_key(primary_key);
		return this;
	}
	public Campo comNotNull(boolean not_null) {
		setNot_null(not_null);
		return this;
	}
	public Campo sendoUnico(boolean unique) {
		setUnique(unique);
		return this;
	}
	public Campo comColunaBinaria(boolean binary_column) {
		setBinary_column(binary_column);
		return this;
	}
	public Campo utilizandoZeroFill(boolean zero_fill) {
		setZero_fill(zero_fill);
		return this;
	}
	public Campo comColunaAutoIncremento(boolean auto_increment) {
		setAuto_increment(auto_increment);
		return this;
	}
	public Campo comGeneratedColumn(boolean generated_column) {
		setGenerated_column(generated_column);
		return this;
	}	
	public Campo sendoUnsigned(boolean unsigned) {
		setUnsigned(unsigned);
		return this;
	}
	public Campo comGeneratedColumnVirtual(boolean virtual) {
		setVirtual(virtual);
		return this;
	}	
	public Campo comGeneratedColumnStored(boolean stored) {
		setStored(stored);
		return this;
	}
	
	public Campo comAExpressao(String exp) {
		setCampoOuExpressao(exp);
		return this;
	}
	public Campo comOnome(String nome) {
		setNome(nome);
		return this;
	}
	
	// SETS AND GETTERS
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.toLowerCase();
	}
	public boolean isPrimary_key() {
		return primary_key;
	}
	
	public void setPrimary_key(boolean primary_key) {
		if (tipoDado != null) {
			if (ValidadorCampo.validarModificadoresDado(this.tipoDado, "PRIMARY KEY")) {
				this.primary_key = primary_key;
				this.not_null = true;
			}
		}
	}
	public boolean isNot_null() {
		return not_null;
	}
	public void setNot_null(boolean not_null) {
		if (tipoDado != null) {
			if (ValidadorCampo.validarModificadoresDado(this.tipoDado, "NOT NULL")) {
				if (primary_key) {
					this.not_null = true;
				}else {
					this.not_null = not_null;
				}
			}
		}
	}
	
	
	public String getCampoOuExpressao() {
		return campoOuExpressao;
	}
	
	public void setCampoOuExpressao(String campoOuExpressao) {
		this.campoOuExpressao = campoOuExpressao;
	}
	public boolean isUnique() {
		return unique;
	}
	public void setUnique(boolean unique) {
		if (tipoDado != null) {
			if (ValidadorCampo.validarModificadoresDado(this.tipoDado, "UNIQUE")) {
				this.unique = unique;
			}
		}
	}
	public boolean isBinary_column() {
		return binary_column;
	}
	public void setBinary_column(boolean binary_column) {
		if (tipoDado != null) {
			if (ValidadorCampo.validarModificadoresDado(this.tipoDado, "BINARY COLUMN")) {
				this.binary_column = binary_column;
			}
		}
	}
	public boolean isUnsigned() {
		return unsigned;
	}
	public void setUnsigned(boolean unsigned) {
		if (tipoDado != null) {
			if (ValidadorCampo.validarModificadoresDado(this.tipoDado, "UNSIGNED")) {
				this.unsigned = unsigned;
			}
		}
	}
	public boolean isZero_fill() {
		return zero_fill;
	}
	public void setZero_fill(boolean zero_fill) {
		if (tipoDado != null) {
			if (ValidadorCampo.validarModificadoresDado(this.tipoDado, "ZERO FILL")) {
				this.zero_fill = zero_fill;
			}
		}
	}
	public boolean isAuto_increment() {
		return auto_increment;
	}
	public void setAuto_increment(boolean auto_increment) {
		if (tipoDado != null) {
			if (ValidadorCampo.validarModificadoresDado(this.tipoDado, "AUTO INCREMENT")) {
				if (auto_increment) {
					this.auto_increment = true;
					if (generated_column) {
						this.generated_column = false;
					}
				}
			}
		}
	}
	public boolean isVirtual() {
		return virtual;
	}
	public void setVirtual(boolean virtual) {
		if (!isStored() && isGenerated_column()) {
			this.virtual = virtual;
		}
	}
	public boolean isStored() {
		return stored;
	}
	public void setStored(boolean stored) {
		if (!isVirtual() && isGenerated_column()) {
			this.stored = stored;
		}
	}
	public boolean isGenerated_column() {
		return generated_column;
	}
	public void setGenerated_column(boolean generated_column) {
		if (this.tipoDado != null) {
			if (ValidadorCampo.validarModificadoresDado(this.tipoDado, "GENERATED COLUMN")) {
				if (generated_column) {
					this.generated_column = true;
					if (this.auto_increment) {
						this.auto_increment = false;
					}
				}
			}
		}
	}
	public IDado getTipoDado() {
		return tipoDado;
	}
	public void setTipoDado(IDado tipoDado) {
		this.tipoDado = tipoDado;
		resetarModificadores();
	}
	
	/**
	 * Método que ao ser invocado, seta em todos os modificadores o valor TRUE.
	 * 
	 * */
	

	public void setarTodosTrue() {		
		setAuto_increment(true);
		setNot_null(true);
		setPrimary_key(true);
		setGenerated_column(true);
		setBinary_column(true);
		setZero_fill(true);
		setVirtual(true);
		setUnique(true);
		setUnsigned(true);
	}
	
	/**
	 * Método que ao ser invocado, seta em todos os modificadores o valor FALSE.
	 * 
	 * */
	
	public void resetarModificadores() {		
		this.auto_increment = false;
		this.not_null = false;
		this.primary_key = false;
		this.generated_column = false;
		this.binary_column = false;
		this.zero_fill = false;
		this.virtual = false;
		this.stored = false;
		this.unique = false;
		this.unsigned = false;
		this.campoOuExpressao = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Campo [nome=");
		builder.append(nome);
		builder.append(", primary_key=");
		builder.append(primary_key);
		builder.append(", not_null=");
		builder.append(not_null);
		builder.append(", unique=");
		builder.append(unique);
		builder.append(", binary_column=");
		builder.append(binary_column);
		builder.append(", zero_fill=");
		builder.append(zero_fill);
		builder.append(", auto_increment=");
		builder.append(auto_increment);
		builder.append(", virtual=");
		builder.append(virtual);
		builder.append(", stored=");
		builder.append(stored);
		builder.append(", generated_column=");
		builder.append(generated_column);
		builder.append(", unsigned=");
		builder.append(unsigned);
		builder.append(", tipoDado=");
		builder.append(tipoDado);
		builder.append(", campoOuExpressao=");
		builder.append(campoOuExpressao);
		builder.append("]");
		return builder.toString();
	}
	
	

}
