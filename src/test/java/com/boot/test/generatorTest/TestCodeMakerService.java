/** */
package com.boot.test.generatorTest;
import com.boot.test.common.codemaker.po.CodeMakerCfg;
import com.boot.test.common.codemaker.service.AbsCodeMakerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @功能:
 * @项目名:dunningServer
 * @作者:wangjz
 * @日期:2017年8月3日上午11:47:47
 * @说明：<pre></pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCodeMakerService extends AbsCodeMakerService {
	/**
	 * @设置 单条sql操作模板
	 */
	@Autowired
	@Qualifier("masterDBSqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 生成代码
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	@Test
	public void testGenerateCode() throws Exception {
		String dbName = "agentCore";
		List<String> tableNames = new ArrayList<String>();
		// tableNames.add("custAgent");
		// tableNames.add("custAgentAuditLog");
		// tableNames.add("custAgentContacts");
		// tableNames.add("custBankCard");
		// tableNames.add("custIdCard");
		//tableNames.add("sysBanner");
		//tableNames.add("acctCommissionCalc");
		//tableNames.add("custCompleteInfo");
		tableNames.add("loanCaseAutoAuditLog");

		String autherName = "fxz";
		String subProjectPackage = "com.zealfi.agent.mgmt";
		String pkgNameModel ="loan";
		String notGenerateFields = "id,createrId,createrName,createTime,modId,modName,modTime,";
		notGenerateFields += "telEnc,emailEnc,bankCardCodeEnc,bankCardTelEnc,idCardCodeEnc,idCardNameEnc";

		// String[] notGenerateTemplates =
		// {"Controller.java","Service.jave","Dao.java","Test.java"};
		Pattern pattern = Pattern.compile("^([a-z]*)");
		for (String tableName : tableNames) {
			Matcher m = pattern.matcher(tableName);
			if (m.find()) {
				String modlePackage = subProjectPackage + "." + pkgNameModel;
				if (!StringUtils.isEmpty(tableName)) {
					CodeMakerCfg cfg = new CodeMakerCfg();
					cfg.setDb(dbName);
					cfg.setTableName(tableName);
					cfg.setAutherName(autherName);
					cfg.setModlePackage(modlePackage);
					cfg.setNotGenerateFields(notGenerateFields);
					// cfg.setNotGenerateTemplates(notGenerateTemplates);
					this.generateCode(cfg, sqlSessionTemplate);
				}
			}
		}
	}

}
