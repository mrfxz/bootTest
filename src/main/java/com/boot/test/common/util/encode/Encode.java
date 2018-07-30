/**
 * 
 */
package com.boot.test.common.util.encode;
import org.springframework.util.StringUtils;
import java.util.List;



public class Encode {
	public static void main(String[] args) {
		System.out.println("19776".hashCode());
		String temp = null;
		String encode = null;
		String decode = null;
		int type = 0;

		String telNo = "15152119268";
		for (int n = 0; n < 50; n++) {
			temp = (new Long(telNo) + n) + "";
			encode = encodeTelNo(temp);
			decode = decodeTelNo(encode);
			type = (temp.substring(0, 3) + temp.substring(9, 11)).hashCode() % EncodeCfg.kindsCount;
			System.out.println(type + "、手机号加密解密：" + temp);
			System.out.println("    加密：" + encode + "\t\t\t\t" + (!temp.equals(encode)));
			System.out.println("    解密：" + decode + "\t\t\t\t" + (temp.equals(decode)));
		}
		System.out.println("");

		String idCardNo = "653129197907069457";
		for (int n = 0; n < 50; n++) {
			String idCardNo_0_2 = idCardNo.substring(0, 2);
			String idCardNo_2_6 = idCardNo.substring(2, 6);// 替换：区号后4位
			String idCardNo_6_9 = new Integer(idCardNo.substring(6, 9)) + n + "";// 前3位年
			String idCardNo_9_10 = idCardNo.substring(9, 10);// 替换： 后1位年
			String idCardNo_10_11 = idCardNo.substring(10, 11);// 前1位月
			String idCardNo_11_12 = idCardNo.substring(11, 12);// 替换： 后1位月
			String idCardNo_12_13 = new Integer(idCardNo.substring(12, 13)) + (n % 4) + "";// 前1位日
			String idCardNo_13_14 = idCardNo.substring(13, 14);// 替换： 后1位日
			String idCardNo_14_17 = idCardNo.substring(14, 17);// 替换：

			StringBuffer newCardNo = new StringBuffer();
			newCardNo.append(idCardNo_0_2);
			newCardNo.append(idCardNo_2_6);
			newCardNo.append(idCardNo_6_9);
			newCardNo.append(idCardNo_9_10);
			newCardNo.append(idCardNo_10_11);
			newCardNo.append(idCardNo_11_12);
			newCardNo.append(idCardNo_12_13);
			newCardNo.append(idCardNo_13_14);
			newCardNo.append(idCardNo_14_17);

			// 计算效验码
			int sum = 0;
			int[] tempNum = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
			String[] code = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
			for (int i = 0; i < 17; i++) {
				sum += Integer.parseInt(newCardNo.substring(i, i + 1)) * tempNum[i];
			}
			newCardNo.append(code[sum % 11]);

			temp = newCardNo.toString();
			encode = encodeIdCardNo(temp);
			decode = decodeIdCardNo(encode);
			type = (idCardNo_6_9 + idCardNo_10_11 + idCardNo_12_13).hashCode() % EncodeCfg.kindsCount;
			System.out.println(type + "、身份证加密解密：" + temp);
			System.out.println("    加密：" + encode + "\t\t\t\t" + (!temp.equals(encode)));
			System.out.println("    解密：" + decode + "\t\t\t\t" + (temp.equals(decode)));
		}
		System.out.println("");

		String bankCardNo = "6222600210022384450";
		for (int n = 0; n < 50; n++) {
			String prefix = bankCardNo.substring(0, 6);
			String mid = bankCardNo.substring(6, bankCardNo.length() - 2);
			String suffix = new Integer(bankCardNo.substring(bankCardNo.length() - 2, bankCardNo.length() - 1)) + n
					+ "";
			String checkCode = "0";

			String newCardNo = prefix + mid + suffix + checkCode;

			// 计算效验码
			int luhmSum = 0;
			int num = 0;
			int index = 1;// 逆向后奇偶标志
			for (int i = newCardNo.length() - 1; i >= 0; i--) {
				num = Integer.parseInt(newCardNo.charAt(i) + "");
				if (index % 2 == 0) {
					num = num * 2 > 9 ? num * 2 - 9 : num * 2;
				}
				luhmSum += num;
				index++;
			}
			checkCode = ((10 - luhmSum % 10) % 10) + "";

			temp = prefix + mid + suffix + checkCode;
			encode = encodeBankCardNo(temp);
			decode = decodeBankCardNo(encode);
			type = suffix.hashCode() % EncodeCfg.kindsCount;
			System.out.println(type + "、银行卡加密解密：" + temp);
			System.out.println("    加密：" + encode + "\t\t\t\t" + (!temp.equals(encode)));
			System.out.println("    解密：" + decode + "\t\t\t\t" + (temp.equals(decode)));
		}
		System.out.println("");

		String name = "王小明";
		for (int n = 0; n < 50; n++) {
			temp = name + n;
			encode = encodeName(temp);
			decode = decodeName(encode);
			type = temp.substring(1).hashCode() % EncodeCfg.kindsCount;
			System.out.println(type + "、姓名加密解密：" + temp);
			System.out.println("    加密：" + encode + "\t\t\t\t" + (!temp.equals(encode)));
			System.out.println("    解密：" + decode + "\t\t\t\t" + (temp.equals(decode)));
		}
		System.out.println("");

		String email = "abcdefghijklmnopqrstuvwxyz@zealfi.com";
		for (int n = 0; n < 50; n++) {
			temp = "a" + n + email;
			encode = encodeEmail(temp);
			decode = decodeEmail(encode);
			type = temp.substring(0, 2).hashCode() % EncodeCfg.kindsCount;
			System.out.println(type + "、邮箱地址加密解密：" + temp);
			System.out.println("    加密：" + encode + "\t\t\t\t" + (!temp.equals(encode)));
			System.out.println("    解密：" + decode + "\t\t\t\t" + (temp.equals(decode)));
		}
		System.out.println("");
	}

	/**
	 * 加密11手机号
	 *
	 * @param telNo
	 * @return
	 */
	public static String encodeTelNo(String telNo) {
		return encodeTelNo(telNo, true);
	}

	/**
	 * 解密11手机号
	 * 
	 * @param telNo
	 * @return
	 */
	public static String decodeTelNo(String telNo) {
		return encodeTelNo(telNo, false);
	}

	/**
	 * 加/解密11手机号
	 *
	 * @param telNo
	 * @return
	 */
	public static String encodeTelNo(String telNo, boolean isEncode) {
		if (StringUtils.isEmpty(telNo) || !DataCheck.isPhoneNumber(telNo)) {
			return telNo;
		}
		String prefix = telNo.substring(0, 3);
		String mid = telNo.substring(3, 6);
		String mid2 = telNo.substring(6, 9);
		String suffix = telNo.substring(9, 11);

		int type = (prefix + suffix).hashCode() % EncodeCfg.kindsCount;
		mid = replace(type, mid, EncodeCfg.telNoConfig, isEncode);
		mid2 = replace(type, mid2, EncodeCfg.telNoConfig, isEncode);
		return prefix + mid2 + mid + suffix;
	}

	/**
	 * 加密18位身份证
	 * 
	 * @param idCardNo
	 * @return
	 */
	public static String encodeIdCardNo(String idCardNo) {
		return encodeIdCardNo(idCardNo, true);
	}

	/**
	 * 解密18位身份证
	 * 
	 * @param idCardNo
	 * @return
	 */
	public static String decodeIdCardNo(String idCardNo) {
		return encodeIdCardNo(idCardNo, false);
	}

	/**
	 * 加/解密18位身份证
	 *
	 * @param idCardNo
	 * @return
	 */
	public static String encodeIdCardNo(String idCardNo, boolean isEncode) {
		if (StringUtils.isEmpty(idCardNo) || !DataCheck.checkIdCardNo(idCardNo)) {
			return idCardNo;
		}
		String idCardNo_0_2 = idCardNo.substring(0, 2);
		String idCardNo_2_6 = idCardNo.substring(2, 6);// 替换：区号后4位
		String idCardNo_6_9 = idCardNo.substring(6, 9);// 前3位年
		String idCardNo_9_10 = idCardNo.substring(9, 10);// 替换： 后1位年
		String idCardNo_10_11 = idCardNo.substring(10, 11);// 前1位月
		String idCardNo_11_12 = idCardNo.substring(11, 12);// 替换： 后1位月
		String idCardNo_12_13 = idCardNo.substring(12, 13);// 前1位日
		String idCardNo_13_14 = idCardNo.substring(13, 14);// 替换： 后1位日
		String idCardNo_14_17 = idCardNo.substring(14, 17);// 替换：

		int type = (idCardNo_6_9 + idCardNo_10_11 + idCardNo_12_13).hashCode() % EncodeCfg.kindsCount;
		idCardNo_2_6 = replace(type, idCardNo_2_6, EncodeCfg.idCardNoConfig.get(0), isEncode);
		idCardNo_9_10 = replace(type, idCardNo_9_10, EncodeCfg.idCardNoConfig.get(1), isEncode);
		idCardNo_11_12 = replace(type, idCardNo_11_12, EncodeCfg.idCardNoConfig.get(1), isEncode);
		idCardNo_13_14 = replace(type, idCardNo_13_14, EncodeCfg.idCardNoConfig.get(1), isEncode);
		idCardNo_14_17 = replace(type, idCardNo_14_17, EncodeCfg.idCardNoConfig.get(1), isEncode);

		StringBuffer newCardNo = new StringBuffer();
		newCardNo.append(idCardNo_0_2);
		newCardNo.append(idCardNo_2_6);
		newCardNo.append(idCardNo_6_9);
		newCardNo.append(idCardNo_9_10);
		newCardNo.append(idCardNo_10_11);
		newCardNo.append(idCardNo_11_12);
		newCardNo.append(idCardNo_12_13);
		newCardNo.append(idCardNo_13_14);
		newCardNo.append(idCardNo_14_17);

		// 计算效验码
		int sum = 0;
		int[] tempNum = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
		String[] code = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
		for (int i = 0; i < 17; i++) {
			sum += Integer.parseInt(newCardNo.substring(i, i + 1)) * tempNum[i];
		}
		newCardNo.append(code[sum % 11]);
		return newCardNo.toString();
	}

	/**
	 * 加密银行卡号
	 * 
	 * @param bankCardNo
	 * @return
	 */
	public static String encodeBankCardNo(String bankCardNo) {
		return encodeBankCardNo(bankCardNo, true);
	}

	/**
	 * 解密银行卡号
	 * 
	 * @param bankCardNo
	 * @return
	 */
	public static String decodeBankCardNo(String bankCardNo) {
		return encodeBankCardNo(bankCardNo, false);
	}

	/**
	 * 加/解密银行卡号
	 * 
	 * @param bankCardNo
	 * @return
	 */
	public static String encodeBankCardNo(String bankCardNo, boolean isEncode) {
		if (StringUtils.isEmpty(bankCardNo) || !DataCheck.checkBankCardNo(bankCardNo)) {
			return bankCardNo;
		}
		String prefix = bankCardNo.substring(0, 6);
		String mid = bankCardNo.substring(6, bankCardNo.length() - 2);
		String suffix = bankCardNo.substring(bankCardNo.length() - 2, bankCardNo.length() - 1);
		String checkCode = "0";

		int type = suffix.hashCode() % EncodeCfg.kindsCount;
		mid = replace(type, mid, EncodeCfg.bankcardNoConfig, isEncode);
		String newCardNo = prefix + mid + suffix + checkCode;

		// 计算效验码
		int luhmSum = 0;
		int num = 0;
		int index = 1;// 逆向后奇偶标志
		for (int i = newCardNo.length() - 1; i >= 0; i--) {
			num = Integer.parseInt(newCardNo.charAt(i) + "");
			if (index % 2 == 0) {
				num = num * 2 > 9 ? num * 2 - 9 : num * 2;
			}
			luhmSum += num;
			index++;
		}
		checkCode = ((10 - luhmSum % 10) % 10) + "";
		return prefix + mid + suffix + checkCode;
	}

	/**
	 * 加密姓名
	 * 
	 * @param name
	 * @return
	 */
	public static String encodeName(String name) {
		return encodeName(name, true);
	}

	/**
	 * 解密姓名
	 * 
	 * @param name
	 * @return
	 */
	public static String decodeName(String name) {
		return encodeName(name, false);
	}

	/**
	 * 加/解密姓名
	 * 
	 * @param name
	 * @return
	 */
	public static String encodeName(String name, boolean isEncode) {
		if (name == null || name.length() < 1) {
			return name;
		}
		String prefix = name.substring(0, 1);
		String mid = name.substring(1);

		int type = mid.hashCode() % EncodeCfg.kindsCount;
		prefix = replace(type, prefix, EncodeCfg.nameConfig, isEncode);
		return prefix + mid;
	}

	/**
	 * 加密邮箱地址
	 * 
	 * @param email
	 * @return
	 */
	public static String encodeEmail(String email) {
		return encodeEmail(email, true);
	}

	/**
	 * 解密邮箱地址
	 * 
	 * @param email
	 * @return
	 */
	public static String decodeEmail(String email) {
		return encodeEmail(email, false);
	}

	/**
	 * 加/解密邮箱地址
	 * 
	 * @param email
	 * @return
	 */
	public static String encodeEmail(String email, boolean isEncode) {
		if (email == null || email.indexOf("@") < 1 || email.lastIndexOf(".") < 3) {
			return email;
		}
		String prefix = email.substring(0, 2);
		String mid = email.substring(2, email.lastIndexOf("."));
		String suffix = email.substring(email.lastIndexOf("."));

		int type = prefix.hashCode() % EncodeCfg.kindsCount;
		mid = replace(type, mid, EncodeCfg.emailConfig, isEncode);
		return prefix + mid + suffix;
	}

	/**
	 * 替换字符
	 * 
	 * @param oldStr
	 * @param list
	 * @param isEncode
	 * @return
	 */
	private static String replace(int type, String oldStr, List<ReplaceObj> list, boolean isEncode) {
		StringBuffer newStr = new StringBuffer();
		String temp = null;
		String temp2 = null;
		for (int i = 0; i < oldStr.length(); i++) {
			temp2 = oldStr.substring(i, i + 1);
			temp = temp2;
			for (ReplaceObj obj : list) {
				temp = obj.replace(type, temp2, isEncode);
				if (!temp.equals(temp2)) {
					break;
				}
			}
			newStr.append(temp);
		}
		return newStr.toString();
	}
}
