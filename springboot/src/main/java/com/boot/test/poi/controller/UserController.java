package com.boot.test.poi.controller;

import com.boot.test.poi.pojo.UserPojo;
import com.boot.test.poi.service.UserService;
import com.boot.test.poi.service.impl.EventExcelService;
import com.boot.test.poi.service.impl.UserExcelService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private EventExcelService eventExcelService;
    @Resource
    private UserExcelService userExcelService;

    /**
     * 用户列表接口
     *
     * @param user
     * @return
     */
    @RequestMapping("/hi")
    @ResponseBody
    public List<UserPojo> hello(UserPojo user) {
        List<UserPojo> list = userService.selectList(user);
        System.out.print(list);
        return list;
    }

    /**
     * Excel导出接口
     *
     * @param response
     */
    @RequestMapping("exportFile")
    public void exportExcel(HttpServletResponse response) {
        OutputStream out = null;
        try {
            List<UserPojo> list = userService.selectList(null);
            HSSFWorkbook workbook = userExcelService.ExcelOut(list, "用户表");
            //设置响应头
            response.setHeader("Content-disposition", "attachment;filename=yonghu.xls");
            response.setContentType("application/msexcel");
            //获取输出流
            out = response.getOutputStream();
            workbook.write(out);
        } catch (Exception e) {
            System.out.print("文件导出出错拉");
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    System.out.print("流关闭异常!");
                }

            }
        }
    }

    /**
     * 文件导入
     */
    @RequestMapping("/importExcel")
    public void importExcel(MultipartFile file) {
        try {
            userExcelService.importExcel(file);
        } catch (Exception e) {
            System.out.print("文件读取异常!!!");
        }
    }
}
