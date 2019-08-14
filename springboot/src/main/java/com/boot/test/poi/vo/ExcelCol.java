package com.boot.test.poi.vo;

/**
 * Excel辅助类(列信息)
 */
public class ExcelCol {
    //属性名(和数据库column保持一致)
    private String propertyName;
    //标题,在excel中的描述.,如姓名,身份证等
    private String title;

    public String getPropertyName() {
        return propertyName;
    }

    public ExcelCol(String propertyName, String title) {
        this.propertyName = propertyName;
        this.title = title;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ExcelCol{" +
                "propertyName='" + propertyName + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
