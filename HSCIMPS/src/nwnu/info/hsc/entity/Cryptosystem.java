package nwnu.info.hsc.entity;

public class Cryptosystem {
	private int cryptoId;//编号
	private String cryptoName;//体制名称
	private String englishName;//英文全称
	private String cryptoDesc;//描述
	private String createDate;//创建时间
	
	public void Hsc() {

	}
	
	public void Hsc(int cryptoId, String cryptoName, String englishName, String cryptoDesc,String createDate){
		this.cryptoId = cryptoId;
		this.cryptoName = cryptoName;
		this.englishName = englishName;
		this.cryptoDesc = cryptoDesc;
		this.createDate = createDate;
	}

	public int getCryptoId() {
		return cryptoId;
	}

	public void setCryptoId(int cryptoId) {
		this.cryptoId = cryptoId;
	}

	public String getCryptoName() {
		return cryptoName;
	}

	public void setCryptoName(String cryptoName) {
		this.cryptoName = cryptoName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getCryptoDesc() {
		return cryptoDesc;
	}

	public void setCryptoDesc(String cryptoDesc) {
		this.cryptoDesc = cryptoDesc;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
