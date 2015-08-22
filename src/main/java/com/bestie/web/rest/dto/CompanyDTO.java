package com.bestie.web.rest.dto;

public class CompanyDTO {

private String iconLink;
	
	private String name;
	
	private String webLink;
	
	private String playLink;
	private String appleLink;
	private String msLink;
	private String catId;
	private String pCatId;
	private String info;
	
    public CompanyDTO() {
    }

    public CompanyDTO(String iconLink, String name, String webLink,
			String playLink, String appleLink, String msLink, String catId,
			String pCatId, String info) {
		super();
		this.iconLink = iconLink;
		this.name = name;
		this.webLink = webLink;
		this.playLink = playLink;
		this.appleLink = appleLink;
		this.msLink = msLink;
		this.catId = catId;
		this.pCatId = pCatId;
		this.info = info;
	}
    
	public String getIconLink() {
		return iconLink;
	}
	public void setIconLink(String iconLink) {
		this.iconLink = iconLink;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebLink() {
		return webLink;
	}
	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}
	public String getPlayLink() {
		return playLink;
	}
	public void setPlayLink(String playLink) {
		this.playLink = playLink;
	}
	public String getAppleLink() {
		return appleLink;
	}
	public void setAppleLink(String appleLink) {
		this.appleLink = appleLink;
	}
	public String getMsLink() {
		return msLink;
	}
	public void setMsLink(String msLink) {
		this.msLink = msLink;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getpCatId() {
		return pCatId;
	}
	public void setpCatId(String pCatId) {
		this.pCatId = pCatId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "CompanyDTO [iconLink=" + iconLink + ", name=" + name
				+ ", webLink=" + webLink + ", playLink=" + playLink
				+ ", appleLink=" + appleLink + ", msLink=" + msLink
				+ ", catId=" + catId + ", pCatId=" + pCatId + ", info=" + info
				+ "]";
	}
	
	
}
