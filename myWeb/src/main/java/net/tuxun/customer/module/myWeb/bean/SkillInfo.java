package net.tuxun.customer.module.myWeb.bean;

/**
 * 数据库表[skill_info]的数据模型
 * 
 * 
 * 
 * @author pand
 * 
 */

@SuppressWarnings("serial")
public class SkillInfo implements java.io.Serializable {

    /** 默认构造函数 */
    public SkillInfo() {
    }
    
    /** 全参构造函数 */
    public SkillInfo(java.lang.Object id, java.lang.Object skillType, java.lang.Object skillName, java.lang.Object skillPer) {
      this.id = id;
      this.skillType = skillType;
      this.skillName = skillName;
      this.skillPer = skillPer;
    }
    
    // 编号 
    private java.lang.Object id;
    // 技能类型 
    private java.lang.Object skillType;
    // 技能名称 
    private java.lang.Object skillName;
    // 技能占比 
    private java.lang.Object skillPer;
     
    public  java.lang.Object getId() {
        return this.id;
    }
    public void setId(java.lang.Object id) {
        this.id = id;
    }
    public  java.lang.Object getSkillType() {
        return this.skillType;
    }
    public void setSkillType(java.lang.Object skillType) {
        this.skillType = skillType;
    }
    public  java.lang.Object getSkillName() {
        return this.skillName;
    }
    public void setSkillName(java.lang.Object skillName) {
        this.skillName = skillName;
    }
    public  java.lang.Object getSkillPer() {
        return this.skillPer;
    }
    public void setSkillPer(java.lang.Object skillPer) {
        this.skillPer = skillPer;
    }
}


