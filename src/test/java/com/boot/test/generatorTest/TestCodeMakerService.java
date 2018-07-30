/** */
package com.boot.test.generatorTest;

import com.boot.test.codemaker.po.CodeMakerCfg;
import com.boot.test.codemaker.service.AbsCodeMakerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCodeMakerService extends AbsCodeMakerService {
	/**
	 * @设置 单条sql操作模板
	 */
	@Resource
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
		String dbName = "boot";
		List<String> tableNames = new ArrayList<String>();
		tableNames.add("testInfo");

		String autherName = "fxz";
		String subProjectPackage = "com.boot.test";
		String pkgNameModel ="event";
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
