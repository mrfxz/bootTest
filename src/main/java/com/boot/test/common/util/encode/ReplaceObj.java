/**
 * 
 */
package com.boot.test.common.util.encode;

/**
 * @功能:互换对象
 * @项目名:kyloanServer
 * @作者:wangjz
 * @日期:2016年5月31日上午9:11:53
 */
public class ReplaceObj {
	/** 互换对象内容1 */
	private String str1;
	/** 互换对象内容2 */
	private String str2;
	/** 互换对象内容3 */
	private String str3;
	/** 互换对象内容4 */
	private String str4;

	/**
	 * 根据type、isEncode替换字符串
	 * 
	 * @param type
	 * @param str
	 * @param isEncode
	 * @return
	 */
	public String replace(int type, String str, boolean isEncode) {
		switch (type) {
		case 0:
			if (isEncode && str.equals(str1)) {
				return str.replace(str1, str2);
			} else if (!isEncode && str.equals(str2)) {
				return str.replace(str2, str1);
			}
			break;
		case 1:
			if (isEncode && str.equals(str1)) {
				return str.replace(str1, str3);
			} else if (!isEncode && str.equals(str3)) {
				return str.replace(str3, str1);
			}
			break;
		case 2:
			if (isEncode && str.equals(str1)) {
				return str.replace(str1, str4);
			} else if (!isEncode && str.equals(str4)) {
				return str.replace(str4, str1);
			}
			break;
		case 3:
			if (isEncode && str.equals(str2)) {
				return str.replace(str2, str1);
			} else if (!isEncode && str.equals(str1)) {
				return str.replace(str1, str2);
			}
			break;
		case 4:
			if (isEncode && str.equals(str2)) {
				return str.replace(str2, str3);
			} else if (!isEncode && str.equals(str3)) {
				return str.replace(str3, str2);
			}
			break;
		case 5:
			if (isEncode && str.equals(str2)) {
				return str.replace(str2, str4);
			} else if (!isEncode && str.equals(str4)) {
				return str.replace(str4, str2);
			}
			break;
		case 6:
			if (isEncode && str.equals(str3)) {
				return str.replace(str3, str1);
			} else if (!isEncode && str.equals(str1)) {
				return str.replace(str1, str3);
			}
			break;
		case 7:
			if (isEncode && str.equals(str3)) {
				return str.replace(str3, str2);
			} else if (!isEncode && str.equals(str2)) {
				return str.replace(str2, str3);
			}
			break;
		case 8:
			if (isEncode && str.equals(str3)) {
				return str.replace(str3, str4);
			} else if (!isEncode && str.equals(str4)) {
				return str.replace(str4, str3);
			}
			break;
		case 9:
			if (isEncode && str.equals(str4)) {
				return str.replace(str4, str1);
			} else if (!isEncode && str.equals(str1)) {
				return str.replace(str1, str4);
			}
			break;
		default:
			if (isEncode && str.equals(str4)) {
				return str.replace(str4, str3);
			} else if (!isEncode && str.equals(str3)) {
				return str.replace(str3, str4);
			}
			break;
		}
		return str;
	}

	/**
	 * @构造方法
	 * @param str1
	 * @param str2
	 */
	public ReplaceObj(String str1, String str2, String str3, String str4, String str5) {
		super();
		this.str1 = str1;
		this.str2 = str2;
		this.str3 = str3;
		this.str4 = str4;
	}

	/**
	 * @取得 互换对象内容1
	 */
	public String getStr1() {
		return str1;
	}

	/**
	 * @设置 互换对象内容1
	 */
	public void setStr1(String str1) {
		this.str1 = str1;
	}

	/**
	 * @取得 互换对象内容2
	 */
	public String getStr2() {
		return str2;
	}

	/**
	 * @设置 互换对象内容2
	 */
	public void setStr2(String str2) {
		this.str2 = str2;
	}

	/**
	 * @取得 互换对象内容3
	 */
	public String getStr3() {
		return str3;
	}

	/**
	 * @设置 互换对象内容3
	 */
	public void setStr3(String str3) {
		this.str3 = str3;
	}

	/**
	 * @取得 互换对象内容4
	 */
	public String getStr4() {
		return str4;
	}

	/**
	 * @设置 互换对象内容4
	 */
	public void setStr4(String str4) {
		this.str4 = str4;
	}

}
