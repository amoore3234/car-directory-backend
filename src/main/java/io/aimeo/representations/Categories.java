package io.aimeo.representations;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Categories {

    @JsonProperty("categoryID")
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryid", referencedColumnName = "categoryid")
    private int categoryID;

    @JsonProperty("categoryName")
    private String categoryName;

    public Categories() {}

    public Categories(int categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
