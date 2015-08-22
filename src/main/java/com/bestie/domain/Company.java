package com.bestie.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A user.
 */
@Entity
@Table(name = "JHI_Company")
public class Company extends AbstractAuditingEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private String iconLink;
	
	private String name;
	
	private String webLink;
	
	private String playLink;
	private String appleLink;
	private String msLink;
	//@Id
    @Column(unique = true, nullable = false)
	private String catId;
	private String pCatId;
	private String info;


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Company company = (Company) o;

        if (!catId.equals(company.catId)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return catId.hashCode();
    }

	@Override
	public String toString() {
		return "Company [id=" + id + ", iconLink=" + iconLink + ", name="
				+ name + ", webLink=" + webLink + ", playLink=" + playLink
				+ ", appleLink=" + appleLink + ", msLink=" + msLink
				+ ", catId=" + catId + ", pCatId=" + pCatId + ", info=" + info
				+ "]";
	}


}

