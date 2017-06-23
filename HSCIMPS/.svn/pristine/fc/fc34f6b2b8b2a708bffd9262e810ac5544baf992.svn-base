package nwnu.info.hsc.algorithm;

import it.unisa.dia.gas.jpbc.Element;

import java.math.BigInteger;
import java.util.ArrayList;

import nwnu.info.hsc.utils.ConvertUtil;

/**
 * IBC→PKI异构签密算法实现
 * @author hp201
 *
 */
public class LZT_2 {
	public static Element T;
	public static Element V;
	public static int len; //记录消息的长度
	/**
	 * 签密
	 * @param Su 发送者私钥
	 * @param pk 接收者公钥
	 * @param id 发送者身份
	 * @param msg 消息
	 * @return
	 */
	public static BigInteger signcrypt(Element Su,Element pk, String id, String msg) {
		len = msg.length();
		double startTime = System.nanoTime();		
		Element r = Sys_Params_Gen.pairing.getZr().newRandomElement().getImmutable();
		Element x = Sys_IDPKC_Params_Gen.gen_G().powZn(r).getImmutable();
		ArrayList<String> arrayList = ConvertUtil.stringToArray1(msg);
		StringBuffer msgBuffer = ConvertUtil.arrayToString1(arrayList);
		BigInteger m = new BigInteger(msgBuffer.toString());
		BigInteger c = m.xor(Sys_IDPKC_Params_Gen.hash3(x.toString(), len).toBigInteger());
		T = pk.powZn(r);
		Element h = Sys_IDPKC_Params_Gen.hash1(m.toString().concat(x.toString()));
		V = Su.powZn(r.add(h));
		double endTime = System.nanoTime();
		System.out.println("签密时间：" + (endTime - startTime) / 1000000 + "ms");
		return c;
	}
	/**
	 * 解签密
	 * @param sk 接收者私钥
	 * @param id 发送者身份
	 * @param c 密文
	 * @return
	 */
	public static String unsigncrypt(Element sk,String id, BigInteger c) {
		
		double startTime = System.nanoTime();
		Element x = Sys_Params_Gen.pairing.pairing(T, sk);
		BigInteger m = c.xor(Sys_IDPKC_Params_Gen.hash3(x.toString(),len).toBigInteger());
		ArrayList<String> arrayList = ConvertUtil.stringToArray2(m.toString());
		String msg = ConvertUtil.arrayToString2(arrayList);
		Element h = Sys_IDPKC_Params_Gen.hash1(m.toString().concat(x.toString()));		
		if (x.equals(Sys_Params_Gen.pairing.pairing(V, Sys_Params_Gen.P.powZn(Sys_IDPKC_Params_Gen.gen_Qu(id)).mul(Sys_Params_Gen.Ppub)).mul(Sys_IDPKC_Params_Gen.gen_G().powZn(h.negate()))))
			System.err.println("签名验证通过");		
		else
			System.err.println("签名验证未通过");			
		double endTime = System.nanoTime();		
		System.out.println("解密时间：" + (endTime - startTime) / 1000000 + "ms");
	    return msg.toString();
	}
	
	public static void main(String[] args) {
		BigInteger c = signcrypt(Sys_IDPKC_Params_Gen.gen_Su("111111"),Sys_TPKC_Params_Gen.gen_PK(),"111111","1111111");
		unsigncrypt(Sys_TPKC_Params_Gen.gen_SK(),"111111",c);
	}
}
