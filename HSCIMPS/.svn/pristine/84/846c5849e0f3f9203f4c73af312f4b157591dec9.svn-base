package nwnu.info.hsc.algorithm;

import it.unisa.dia.gas.jpbc.Element;
public class Sys_IDPKC_Params_Gen {	
	public static Element Qu;
	public static Element Su;
	public static Element g;

	public static Element gen_G() {
		g = Sys_Params_Gen.pairing.pairing(Sys_Params_Gen.P, Sys_Params_Gen.P).getImmutable();
		return g;
	}
	public static Element gen_Qu(String id){
		Qu = hash1(id);
		return Qu;
	}
	
	public static Element gen_Su(String id){
		Su = Sys_Params_Gen.P.powZn((Sys_Params_Gen.s.add(gen_Qu(id))).invert()).getImmutable();
		return Su;
	}
	
	public static Element hash1(String str) {
		byte[] bytes = str.getBytes();
		Element hash = Sys_Params_Gen.pairing.getZr().newElement().setFromHash(bytes, 0, bytes.length);
		return hash;
	}
	public static Element hash3(String str, int length) {
		byte[] bytes = str.getBytes();
		Element hash = Sys_Params_Gen.pairing.getGT().newElement().setFromHash(bytes, 0, length);
		return hash;
	}
}
