/** */
package ${fullPkgModel}.service;

import org.springframework.stereotype.Service;
import ${fullPkgSubProj}.base.service.BaseService;
import ${fullPkgModel}.dao.${capClassName}Dao;
import ${fullPkgModel}.pojo.${capClassName}Pojo;
import ${fullPkgModel}.service.iservice.I${capClassName}Service;

/**
 * @功能:【${tableName} ${tableComment}】Service
 * @项目名:${projectDirName}
 * @作者:${autherName}
 * @日期:${createTime?string('yyyy-MM-dd HH:mm:ss')}
 * @说明：<pre></pre>
 */
@Service
public class ${capClassName}Service extends BaseService<${capClassName}Pojo, ${capClassName}Dao> implements I${capClassName}Service {

}
