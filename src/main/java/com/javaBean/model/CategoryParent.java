package com.javaBean.model;

import com.javaBean.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryParent {
    private String categoryName;
    private List<Category> parent;

    public CategoryParent(String categoryName, List<Category> parent) {
        this.categoryName = categoryName;
        this.parent = parent;
    }

    public CategoryParent() {
        parent = new ArrayList<>();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Category> getParent() {
        return parent;
    }

    public void setParent(List<Category> parent) {
        this.parent = parent;
    }
}
