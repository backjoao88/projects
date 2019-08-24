package br.poo.joao.enumeracoes;

public enum Engine {
	
	INNODB("InnoDB"),
	MYISAM("MyISAM"),
	NDBCLUSTER("ndbcluster"),
	MEMORY("MEMORY"),
	EXAMPLE("EXAMPLE");
	
	private String desc;
	
	Engine(String desc){
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}

}
