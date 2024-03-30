package com.javaBean;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "category")
public class Category implements Serializable{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CategoryId")
        private int categoryId;

        @Column(name = "CategoryName")
        private String categoryName;

        @Column(name = "ParentId")
        private Integer parentId;

        // Constructors
        public Category() {}

        public Category(String categoryName, Integer parentId) {
            this.categoryName = categoryName;
            this.parentId = parentId;
        }

        // Getters and setters
        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }
}
