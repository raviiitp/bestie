package com.bestie.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A company.
 */
@Entity
@Table(name = "JHI_COMPANY")
public class Company extends AbstractAuditingEntity implements Serializable {

    /**
	 * 
	 */

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
    private Long id;
	
	@Column(name="icon_link")
	private String iconLink;

	@Column(name="name")
	private String name;

	@Column(name="web_link")
	private String webLink;

	@Column(name="play_link")
	private String playLink;
	
	@Column(name="apple_link")
	private String appleLink;
	
	@Column(name="ms_link")
	private String msLink;
	//@Id
	@NotNull
    @Column(name="cat_id", unique = true, nullable = false)
	private String catId;
	
	@Column(name="p_cat_id")
	private String pCatId;
	
	@Column(name="info")
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

