package br.poo.joao.enumeracoes;

public enum CollateVersion{
	
	DEFAULT_COLLATION("default_collation"),
	BIG5_CHINESE("big5_chinese"),
	DEC8_BIN("dec8_bin"),
	CP850_BIN("cp850_bin"),
	HP8_BIN("hp8_bin"),
	KOI8R_BIN("koi8r_bin"),
	LATIN1_BIN("latin1_bin"),
	LATIN2_BIN("latin2_bin"),
	SWE7_BIN("swe7_bin"),
	ASCII_BIN("ascii_bin"),
	UJIS_BIN("ujis_bin"),
	SJIS_BIN("sjis_bin"),
	HEBREW_BIN("hebrew_bin"),
	TIS620_BIN("tis620_bin"),
	EUCKR_BIN("euckr_bin"),
	KOI8U_BIN("koi8u_bin"),
	GB2312_BIN("gb2312_bin"),
	GREEK_BIN("greek_bin"),
	CP1250_BIN("cp1250_bin"),
	GBK_BIN("gbk_bin"),
	LATIN5_BIN("latin5_bin"),
	ARMSCII_BIN("armscii_bin"),
	UTF8_BIN("utf8_bin"),
	UCS2_BIN("ucs2_bin"),
	CP866_BIN("cp866_bin"),
	KEYBCS2_BIN("keybcs2_bin"),
	MACCE_BIN("macce_bin"),
	MACROMAN_BIN("macroman_bin"),
	CP852_BIN("cp852_bin"),
	LATIN7_BIN("latin7_bin"),
	CP1251_BIN("cp1251_bin"),
	CP1256_BIN("cp1256_bin"),
	CP1257_BIN("cp1257_bin"),
	BINARY_BIN("binary_bin"),
	GEOSTD8_BIN("geostd8_bin"),
	CP932_BIN("cp932_bin"),
	EUCJPMS_BIN("eucjpms_bin"),
	UTF8MB4_BIN("utf8mb4_bin"),
	UTF16_BIN("utf16_bin"),
	UTF32_BIN("utf32_bin");
	
	private String desc;
	
	CollateVersion(String desc){
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
	
	
	

}
