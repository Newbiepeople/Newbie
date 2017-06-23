package nwnu.info.hsc.algorithm;

import it.unisa.dia.gas.jpbc.Element;

import java.math.BigInteger;
import java.util.ArrayList;

import nwnu.info.hsc.utils.ConvertUtil;

/**
 * PKI→IBC异构签密算法实现
 * @author hp201
 *
 */
public class LZT_1 {
	//加密、解密变量
	public static Element T;
	public static Element V;
	public static int len; //记录消息的长度
	public static BigInteger signcrypt(Element sk,String id,String msg) {
		len = msg.length();
		System.err.println("消息msg：" + msg);
		double startTime = System.nanoTime();
		Element r = Sys_Params_Gen.pairing.getZr().newRandomElement().getImmutable();
		Element x = Sys_IDPKC_Params_Gen.gen_G().powZn(r).getImmutable();
		ArrayList<String> arrayList = ConvertUtil.stringToArray1(msg);
		StringBuffer msgBuffer = ConvertUtil.arrayToString1(arrayList);
		BigInteger m = new BigInteger(msgBuffer.toString());		
		BigInteger c = m.xor(Sys_IDPKC_Params_Gen.hash3(x.toString(), len).toBigInteger());
		System.err.println("密文c：" + c.toString());
		T = Sys_Params_Gen.P.powZn(r.mulZn(Sys_IDPKC_Params_Gen.gen_Qu(id))).mul(Sys_Params_Gen.Ppub.powZn(r));
		Element h = Sys_IDPKC_Params_Gen.hash1(m.toString().concat(x.toString()));
		V = sk.powZn(r.add(h)).getImmutable();		
		double endTime = System.nanoTime();
		System.out.println("签密时间：" + (endTime - startTime) / 1000000 + "ms");
		return c;
	}
	public static String unsigncrypt(Element pk,Element Su,BigInteger c) {
		double startTime = System.nanoTime();
		Element x = Sys_Params_Gen.pairing.pairing(T, Su);
		BigInteger m = c.xor(Sys_IDPKC_Params_Gen.hash3(x.toString(),len).toBigInteger());		
		ArrayList<String> arrayList = ConvertUtil.stringToArray2(m.toString());
		String msg = ConvertUtil.arrayToString2(arrayList);
		Element h = Sys_IDPKC_Params_Gen.hash1(m.toString().concat(x.toString())).getImmutable();
		if (x.equals(Sys_Params_Gen.pairing.pairing(V, pk).mul(Sys_IDPKC_Params_Gen.gen_G().powZn(h.negate()))))
			System.err.println("签名验证通过");			
		else
			System.err.println("签名验证未通过");
		double endTime = System.nanoTime();
		System.out.println("解密时间：" + (endTime - startTime) / 1000000 + "ms");
		System.out.println(msg);
		return msg.toString();		
	}
	
	public static void main(String[] args) {		
		BigInteger c = signcrypt(Sys_TPKC_Params_Gen.gen_SK(),"111111","西北师范大学");
		unsigncrypt(Sys_TPKC_Params_Gen.gen_PK(),Sys_IDPKC_Params_Gen.gen_Su("111111"), c);
	}
}
