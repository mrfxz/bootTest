package com.boot.test.poi.service.impl;

import com.boot.test.poi.pojo.UserPojo;
import com.boot.test.poi.service.UserService;
import com.boot.test.poi.util.ExcelUtil;
import com.boot.test.poi.vo.ExcelCol;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserExcelService extends ExcelUtil<UserPojo> {

    @Resource
    private UserService userService;

    @Override
    protected void init() {
        cols = new ArrayList<ExcelCol>();
        cols.add(new ExcelCol("id","编号"));
        cols.add(new ExcelCol("userName","用户名"));
        cols.add(new ExcelCol("password","密码"));
    }

    @Override
    public List<UserPojo> importExcel(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        if(filename.endsWith(".xlsx")){
            book = new XSSFWorkbook(file.getInputStream());
        }else if(filename.endsWith(".xls")){
            book = new HSSFWorkbook(file.getInputStream());
        }else{
            System.out.print("上传文件格式错误,请上传excel件!!!");
            return null;
        }
        UserPojo user = null;
        sheet = book.getSheetAt(0);
        Row firstRow = sheet.getRow(0);
        int rowsNumber = sheet.getPhysicalNumberOfRows();
        int cellsNumber = firstRow.getPhysicalNumberOfCells();
        for (int i = 1; i < rowsNumber; i++) {
            row = sheet.getRow(i);
            user = new UserPojo();
            for (int j = 0; j < cellsNumber; j++) {
                cell = row.getCell(j);
                if (cell != null) {
                    switch (j) {
                        case 1:
                            user.setUserName(cell.getStringCellValue());
                            break;
                        case 2:
                            user.setPassword(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                }
            }
            userService.insert(user);
        }
        return null;
    }
}
