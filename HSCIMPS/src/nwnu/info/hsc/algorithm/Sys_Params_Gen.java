package nwnu.info.hsc.algorithm;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;

/**
 * 生成所有算法的公共参数P
 * @author Administrator
 *
 */
public class Sys_Params_Gen {
	public static String properties = "a.properties";
	public static Pairing pairing = PairingFactory.getPairing(properties);
	public static Element P = pairing.getG1().newRandomElement().getImmutable();
	public static Element s = Sys_Params_Gen.pairing.getZr().newRandomElement().getImmutable();
	public static Element Ppub = Sys_Params_Gen.P.powZn(s).getImmutable();
}
