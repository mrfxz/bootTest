/** */
package com.boot.test.common.base.controller;

import com.boot.test.common.base.pojo.BasePojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class AbsBaseController<T extends BasePojo> {
    /**
     * 日志对象
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // /**
    // * response返回数据
    // *
    // * @param response
    // * @param info
    // * @param data
    // */
    // public void httpResponse(HttpServletResponse response, OptResult info, T data) {
    // httpResponse(response, new ResponseData<Object>(info, data));
    // }
    //
    // /**
    // * response返回数据
    // *
    // * @param response
    // * @param info
    // * @param data
    // */
    // public void httpResponse(HttpServletResponse response, OptResult info, List<T> data) {
    // httpResponse(response, new ResponseData<Object>(info, data));
    // }
    //
    // /**
    // * response返回数据
    // *
    // * @param response
    // * @param info
    // * @param data
    // */
    // public void httpResponse(HttpServletResponse response, OptResult info, List<T> data, Long
    // total) {
    // httpResponse(response, new ResponseData<Object>(info, data, total));
    // }
    //
    // /**
    // * response返回数据
    // *
    // * @param response
    // * @param data
    // */
    // private void httpResponse(HttpServletResponse response, ResponseData<Object> data) {
    // PrintWriter writer = null;
    // try {
    // String str = JsonTool.getString(data);
    // response.setContentType("application/json");
    // response.setCharacterEncoding("UTF-8");
    // writer = response.getWriter();
    // writer.write(str);
    // writer.flush();
    // logger.info(data.getReqResult());
    // } catch (Exception ex) {
    // logger.error("服务端返回异常", ex);
    // try {
    // response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    // } catch (IOException e) {}
    // } finally {
    // if (writer != null) {
    // writer.close();
    // }
    // }
    // }

}
