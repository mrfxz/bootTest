/** */
package com.boot.test.common.util.encode;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @功能:
 * @项目名:bdfarm
 * @作者:wangjz
 * @日期:2015年7月6日下午2:13:42
 */
public class DataCheck {
	/** 日志对象 */


	/**
	 * 验证字符串是否是手机号码
	 * 
	 * @param string
	 *            要验证的字符串
	 * @return
	 */
	public static boolean isPhoneNumber(String string) {
		Pattern pattern = Pattern.compile("^(13[0-9]|14[57]|15[012356789]|17[01678]|18[0-9])[0-9]{8}$"); // 手机号
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * 验证密码格式：6-12位数字与英文字母相结合的密码
	 * 
	 * @param pwd 要验证的密码
	 * @return
	 */
	public static boolean chenkPwd(String pwd) {
		Pattern pattern = Pattern.compile("^[\\da-zA-Z]{6,12}$");
		Matcher matcher = pattern.matcher(pwd);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * 检查银行卡(Luhm校验) 1、从卡号最后一位数字开始，逆向将奇数位(1、3、5等等)相加。
	 * 2、从卡号最后一位数字开始，逆向将偶数位数字，先乘以2（如果乘积为两位数，则将其减去9），再求和。
	 * 3、将奇数位总和加上偶数位总和，结果应该可以被10整除。
	 * 
	 * @param cardNo
	 * @return
	 */
	public static boolean checkBankCardNo(String cardNo) {
		if (!StringUtils.isEmpty(cardNo)) {
			try {
				int luhmSum = 0;
				int num = 0;
				int index = 1;// 逆向后奇偶标志
				for (int i = cardNo.length() - 1; i >= 0; i--) {
					num = Integer.parseInt(cardNo.charAt(i) + "");
					if (index % 2 == 0) {
						num = num * 2 > 9 ? num * 2 - 9 : num * 2;
					}
					luhmSum += num;
					index++;
				}
				return luhmSum % 10 == 0;
			} catch (Exception ex) {}
		}
		return false;
	}

	/**
	 * 检查身份证号码
	 * 
	 * @param idCardNo
	 * @return
	 */
	public static boolean checkIdCardNo(String idCardNo) {
		if (!StringUtils.isEmpty(idCardNo)) {
			idCardNo = idCardNo.toUpperCase();
			int sum = 0;
			int[] tempNum = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
			String[] code = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
			if (idCardNo != null && idCardNo.length() == 18) {
				try {
					for (int i = 0; i < 17; i++) {
						sum += Integer.parseInt(idCardNo.substring(i, i + 1)) * tempNum[i];
					}
					if (idCardNo.substring(17, 18).equals(code[sum % 11])) {
						return true;
					}
				} catch (Exception e) {}
			}
		}
		return false;
	}

}
