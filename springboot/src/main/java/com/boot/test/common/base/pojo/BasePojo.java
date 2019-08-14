/** */
package com.boot.test.common.base.pojo;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;


public class BasePojo implements Serializable {
    /** */
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
    /**
     * 创建人id
     */
    private Long createrId;
    /**
     * 创建人姓名
     */
    private String createrName;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 修改人id
     */
    private Long modId;
    /**
     * 修改人姓名
     */
    private String modName;
    /**
     * 修改时间
     */
    private Timestamp modTime;

    /**
     * 分页：第几页
     */
    private Integer pageNum;
    /**
     * 分页：每页显示条数
     */
    private Integer pageSize;
    /**
     * dataTabel分页：第几页
     */
    private Integer start;
    /**
     * dataTabel分页：每页显示条数
     */
    private Integer length;
    /**
     * 分页：查询记录总数
     */
    private Long totalRowCount;

    /**
     * 设置创建者信息
     */
    public void setCreaterInfo() {
        this.createrId = 1L;
        this.createrName = "system";
        this.createTime = new Timestamp(new Date().getTime());
    }

    /**
     * 设置创建者信息
     *
     * @param time
     */
    public void setCreaterInfo(Timestamp time) {
        this.createrId = 1L;
        this.createrName = "system";
        this.createTime = time;
    }

    /**
     * 设置创建者信息
     *
     * @param id
     * @param name
     * @param time
     */
    public void setCreaterInfo(Long id, String name, Timestamp time) {
        this.createrId = id;
        this.createrName = name;
        this.createTime = time;
    }

    /**
     * 设置修改信息
     */
    public void setModInfo() {
        this.modId = 1L;
        this.modName = "system";
        this.modTime = new Timestamp(new Date().getTime());
    }

    /**
     * 设置修改信息
     *
     * @param time
     */
    public void setModInfo(Timestamp time) {
        this.modId = 1L;
        this.modName = "system";
        this.modTime = time;
    }

    /**
     * 设置修改信息
     *
     * @param id
     * @param name
     * @param time
     */
    public void setModInfo(Long id, String name, Timestamp time) {
        this.modId = id;
        this.modName = name;
        this.modTime = time;
    }

    /**
     * @取得 id
     */
    public Long getId() {
        return id;
    }

    /**
     * @设置 id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @取得 创建人id
     */
    public Long getCreaterId() {
        return createrId;
    }

    /**
     * @设置 创建人id
     */
    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    /**
     * @取得 创建人姓名
     */
    public String getCreaterName() {
        return createrName;
    }

    /**
     * @设置 创建人姓名
     */
    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    /**
     * @取得 创建时间
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * @设置 创建时间
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * @取得 修改人id
     */
    public Long getModId() {
        return modId;
    }

    /**
     * @设置 修改人id
     */
    public void setModId(Long modId) {
        this.modId = modId;
    }

    /**
     * @取得 修改人姓名
     */
    public String getModName() {
        return modName;
    }

    /**
     * @设置 修改人姓名
     */
    public void setModName(String modName) {
        this.modName = modName;
    }

    /**
     * @取得 修改时间
     */
    public Timestamp getModTime() {
        return modTime;
    }

    /**
     * @设置 修改时间
     */
    public void setModTime(Timestamp modTime) {
        this.modTime = modTime;
    }

    /**
     * @取得 分页：第几页
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * @设置 分页：第几页
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * @取得 分页：每页显示条数
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @设置 分页：每页显示条数
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @取得 dataTabel分页：第几页
     */
    public Integer getStart() {
        return start;
    }

    /**
     * @设置 dataTabel分页：第几页
     */
    public void setStart(Integer start) {
        this.start = start;
        if (this.start != null && this.length != null && this.length > 0) {
            this.pageNum = this.start / this.length + 1;
        }
    }

    /**
     * @取得 dataTabel分页：每页显示条数
     */
    public Integer getLength() {
        return length;
    }

    /**
     * @设置 dataTabel分页：每页显示条数
     */
    public void setLength(Integer length) {
        this.length = length;
        this.pageSize = length;
        if (this.start != null && this.length != null && this.length > 0) {
            this.pageNum = this.start / this.length + 1;
        }
    }

    /**
     * @取得 分页：查询记录总数
     */
    public Long getTotalRowCount() {
        return totalRowCount;
    }

    /**
     * @设置 分页：查询记录总数
     */
    public void setTotalRowCount(Long totalRowCount) {
        this.totalRowCount = totalRowCount;
    }

    /**
     * @方法重写
     */
    @Override
    public String toString() {
        return "BasePojo{" +
                "id=" + id +
                ", createrId=" + createrId +
                ", createrName='" + createrName + '\'' +
                ", createTime=" + createTime +
                ", modId=" + modId +
                ", modName='" + modName + '\'' +
                ", modTime=" + modTime +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", start=" + start +
                ", length=" + length +
                ", totalRowCount=" + totalRowCount +
                '}';
    }
}
