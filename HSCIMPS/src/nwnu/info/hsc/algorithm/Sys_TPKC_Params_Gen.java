package nwnu.info.hsc.algorithm;

import it.unisa.dia.gas.jpbc.Element;

public class Sys_TPKC_Params_Gen {
	public static Element xu = Sys_Params_Gen.pairing.getZr().newRandomElement().getImmutable();
	public static Element pk;
	public static Element sk;
	
	public static Element gen_PK(){
		pk = Sys_Params_Gen.P.powZn(xu).getImmutable();		
		return pk;
	}
	
	public static Element gen_SK(){
		sk = Sys_Params_Gen.P.powZn(xu.invert()).getImmutable();
		return sk;
	}
	
}
