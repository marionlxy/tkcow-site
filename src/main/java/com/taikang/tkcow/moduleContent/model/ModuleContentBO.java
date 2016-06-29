package com.taikang.tkcow.moduleContent.model;


import java.sql.Timestamp;
import java.lang.Integer;
import java.lang.String;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * ModuleContentBO 
  */
public class ModuleContentBO  extends BaseBO {
	
	private static final long serialVersionUID = 1L;
	
	public ModuleContentBO(){
		init();
	}
	
	protected void init(){
		super.init();
		this.addList(Arrays.asList("content_id","mod_id","mod_type","mod_des","mod_url","title","mod_img","mod_number","mod_parent_id","mod_name","content_img","content_img_big","has_banner","banner_id","content","is_display","weight","created_time","created_by","modified_time","modified_by","version","delflag","pageNo","pageSize"));
	}
	

	private String contentId;
		public void setContentId(String contentId){
		getData().put("content_id",contentId);
		this.contentId=contentId;
	}
	
	public String getContentId(){
		return (String)getData().get("content_id");
	}	
		
		
	private String modId;
		public void setModId(String modId){
		getData().put("mod_id",modId);
		this.modId=modId;
	}
	
	public String getModId(){
		return (String)getData().get("mod_id");
	}	
		
		
	private Integer modNumber;
		public void setModNumber(Integer modNumber){
		getData().put("mod_number",modNumber);
		this.modNumber=modNumber;
	}
	
	public Integer getModNumber(){
		return (Integer)getData().get("mod_number");
	}	
		
		
	private String contentImg;
		public void setContentImg(String contentImg){
		getData().put("content_img",contentImg);
		this.contentImg=contentImg;
	}
	
	public String getContentImg(){
		return (String)getData().get("content_img");
	}	
		
		
	private String contentImgBig;
		public void setContentImgBig(String contentImgBig){
		getData().put("content_img_big",contentImgBig);
		this.contentImgBig=contentImgBig;
	}
	
	public String getContentImgBig(){
		return (String)getData().get("content_img_big");
	}	
		
		
	private String hasBanner;
		public void setHasBanner(String hasBanner){
		getData().put("has_banner",hasBanner);
		this.hasBanner=hasBanner;
	}
	
	public String getHasBanner(){
		return (String)getData().get("has_banner");
	}	
		
		
	private String bannerId;
		public void setBannerId(String bannerId){
		getData().put("banner_id",bannerId);
		this.bannerId=bannerId;
	}
	
	public String getBannerId(){
		return (String)getData().get("banner_id");
	}	
		
		
	private byte[] content;
		public void setContent(byte[] content){
		getData().put("content",content);
		this.content=content;
	}
	
	public byte[] getContent(){
		return (byte[])getData().get("content");
	}	
		
		
	private String isDisplay;
		public void setIsDisplay(String isDisplay){
		getData().put("is_display",isDisplay);
		this.isDisplay=isDisplay;
	}
	
	public String getIsDisplay(){
		return (String)getData().get("is_display");
	}	
		
		
	private Integer weight;
		public void setWeight(Integer weight){
		getData().put("weight",weight);
		this.weight=weight;
	}
	
	public Integer getWeight(){
		return (Integer)getData().get("weight");
	}	
		
		
	private Timestamp createdTime;
		public void setCreatedTime(Timestamp createdTime){
		getData().put("created_time",createdTime);
		this.createdTime=createdTime;
	}
	
	public Timestamp getCreatedTime(){
		return (Timestamp)getData().get("created_time");
	}	
		
		
	private String createdBy;
		public void setCreatedBy(String createdBy){
		getData().put("created_by",createdBy);
		this.createdBy=createdBy;
	}
	
	public String getCreatedBy(){
		return (String)getData().get("created_by");
	}	
		
		
	private Timestamp modifiedTime;
		public void setModifiedTime(Timestamp modifiedTime){
		getData().put("modified_time",modifiedTime);
		this.modifiedTime=modifiedTime;
	}
	
	public Timestamp getModifiedTime(){
		return (Timestamp)getData().get("modified_time");
	}	
		
		
	private String modifiedBy;
		public void setModifiedBy(String modifiedBy){
		getData().put("modified_by",modifiedBy);
		this.modifiedBy=modifiedBy;
	}
	
	public String getModifiedBy(){
		return (String)getData().get("modified_by");
	}	
		
		
	private Integer version;
		public void setVersion(Integer version){
		getData().put("version",version);
		this.version=version;
	}
	
	public Integer getVersion(){
		return (Integer)getData().get("version");
	}	
		
		
	private String delflag;
		public void setDelflag(String delflag){
		getData().put("delflag",delflag);
		this.delflag=delflag;
	}
	
	public String getDelflag(){
		return (String)getData().get("delflag");
	}	
	
	private String modParentId;
	public void setModParentId(String modParentId){
		getData().put("mod_parent_id",modParentId);
	this.modParentId=modParentId;
}

	public String getModParentId(){
		return (String)getData().get("mod_parent_id");
	}	
	
	private String modName;
	public void setModName(String modName){
		getData().put("mod_name",modName);
	this.modName=modName;
}

	public String getModName(){
		return (String)getData().get("mod_name");
	}	
	private String modUrl;
	public void setModUrl(String modUrl){
		getData().put("mod_url",modUrl);
	this.modUrl=modUrl;
}

	public String getModUrl(){
		return (String)getData().get("mod_url");
	}
	private String modDes;
	public void setModDes(String modDes){
		getData().put("mod_des",modDes);
	this.modDes=modDes;
}

	public String getModDes(){
		return (String)getData().get("mod_des");
	}	
	
	private String modType;
	public void setModType(String modType){
		getData().put("mod_type",modType);
	this.modType=modType;
	}
	public String getModType(){
		return (String)getData().get("mod_type");
	}	
	
	private String modImg;
	public void setModImg(String modImg){
		getData().put("mod_img",modImg);
	this.modImg=modImg;
	}

	public String getModImg(){
		return (String)getData().get("mod_img");
	}
	
	private String title;
	public void setTitle(String title){
		getData().put("title",title);
	this.title=title;
	}
	
	public String getTitle(){
		return (String)getData().get("title");
	}
	
	public int pageNo;
	public int getPageNo() {
		return (Integer) getData().get("pageNo");
	}

	public void setPageNo(int pageNo) {
		getData().put("pageNo",pageNo);
		this.pageNo = pageNo;
	}

	
	public int  pageSize;
	public int getPageSize() {
		return (Integer) getData().get("pageSize");
	}

	public void setPageSize(int pageSize) {
		getData().put("pageSize",pageSize);
		this.pageSize = pageSize;
	}


	
}

