package io.bumo.encryption.utils.hash;

import cfca.sadk.algorithm.common.Mechanism;

public class HashUtil {
	/**
	 * generate hex string of hash
	 * @param src
	 * @param type 0(SHA256) or 1(SM3)
	 * @return hex string of hash
	 * @throws Exception 
	 */
	public static String GenerateHashHex(byte[] src, Integer type) throws Exception {
		byte[] hash = null;
		if (type == 0) {
			hash = cfca.sadk.util.HashUtil.RSAHashMessageByBC(src, new Mechanism(Mechanism.SHA256), false);
		}
		else if (type == 1) {
			hash = cfca.sadk.util.HashUtil.SM2HashMessageByBCWithoutZValue(src);
		}
		else {
			throw new Exception("type is invalid");
		}
		return io.bumo.encryption.utils.hex.HexFormat.byteToHex(hash).toLowerCase();
	}
}