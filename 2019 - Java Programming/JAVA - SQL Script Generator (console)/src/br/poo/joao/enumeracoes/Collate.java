package br.poo.joao.enumeracoes;
import java.util.ArrayList;
import java.util.List;
public enum Collate {
	
	SCHEMADEFAULT("Schema Default"),
	BIG5("big5"),
	DEC8("dec8"),
	CP850("cp850"),
	HP8("hp8"),
	KOI8R("koi8r"),
	LATIN1("latin1"),
	LATIN2("latin2"),
	SWE7("swe7"),
	ASCII("ascii"),
	UJIS("ujis"),
	SJIS("sjis"),
	HEBREW("hebrew"),
	TIS620("tis620"),
	EUCKR("euckr"),
	KOI8U("koi8u"),
	GB2312("gb2312"),
	GREEK("greek"),
	CP1250("cp1250"),
	GBK("gbk"),
	LATIN5("latin5"),
	ARMSCII8("armscii8"),
	UTF8("utf8"),
	UCS2("ucs2"),
	CP866("cp866"),
	KEYBCS2("keybcs2"),
	MACCE("macce"),
	MACROMAN("macroman"),
	CP852("cp852"),
	LATIN7("latin7"),
	CP1251("cp1251"),
	CP1256("cp1256"),
	CP1257("cp1257"),
	BINARY("binary"),
	GEOSTD8("geostd8"),
	CP932("cp932"),
	EUCJPMS("eucjpms"),
	UTF8MB4("utf8mb4"),
	UTF16("utf16"),
	UTF32("utf32");
	
	private String desc;
	private List<CollateVersion> versoes;
	
	Collate(String desc){
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public List<CollateVersion> getVersoes() {
		return versoes();
	}
	
	private List<CollateVersion> versoes(){
		versoes = new ArrayList<CollateVersion>();
		versoes.add(CollateVersion.DEFAULT_COLLATION);
		switch(this) {
		case BIG5:
			versoes.add(CollateVersion.BIG5_CHINESE);
			break;
		case DEC8:
			versoes.add(CollateVersion.DEC8_BIN);
			break;
		case CP850:
			versoes.add(CollateVersion.CP850_BIN);
			break;
		case ASCII:
			versoes.add(CollateVersion.ASCII_BIN);
			break;
		case BINARY:
			versoes.add(CollateVersion.BINARY_BIN);
			break;
		default:
		}
		return versoes;
	}
}
	