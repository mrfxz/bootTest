package com.boot.test.poi.service.impl;

import com.boot.test.poi.pojo.EventPojo;
import com.boot.test.poi.service.EventService;
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


/**
 * 事件Excel Service
 */
@Service
public class EventExcelService extends ExcelUtil<EventPojo> {

    @Resource
    private EventService eventService;
    /**
     * 初始化列信息
     */
    protected void init() {
        cols = new ArrayList<ExcelCol>();
        cols.add(new ExcelCol("id","编号"));
        cols.add(new ExcelCol("eventId","事件"));
        cols.add(new ExcelCol("eventDes","描述"));
        cols.add(new ExcelCol("remark","备注"));
        cols.add(new ExcelCol("reason","原因"));
    }

    /**
     * 文件导入
     * @param file
     * @return
     */
    public List<EventPojo> importExcel(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        if(filename.endsWith(".xlsx")){
           book = new XSSFWorkbook(file.getInputStream());
        }else if(filename.endsWith(".xls")){
            book = new HSSFWorkbook(file.getInputStream());
        }else{
            System.out.print("上传文件格式错误,请上传excel文件!!!");
            return null;
        }

        EventPojo event = null;
        sheet = book.getSheetAt(0);
        Row firstRow = sheet.getRow(0);
        int rowsNumber = sheet.getPhysicalNumberOfRows();
        int cellsNumber = firstRow.getPhysicalNumberOfCells();
        for (int i = 1; i < rowsNumber; i++) {
            row = sheet.getRow(i);
            event = new EventPojo();
            for (int j = 0; j < cellsNumber; j++) {
                cell = row.getCell(j);
                if (cell != null) {
                    switch (j) {
                        case 0:
                            event.setEventId(cell.getStringCellValue());
                            break;
                        case 1:
                            event.setEventDes(cell.getStringCellValue());
                            break;
                        case 2:
                            event.setRemark(cell.getStringCellValue());
                            break;
                        case 3:
                            event.setReason(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                }
            }
            eventService.insert(event);
        }
        return null;
    }
}
