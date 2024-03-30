package com.businessLogic;


import com.javaBean.Category;
import com.javaBean.model.CategoryParent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CategoryBL {

    private SessionFactory sessionFactory;

    public CategoryBL(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    public List<Category> findAll() {
        try (Session session = sessionFactory.openSession()) {
            TypedQuery<Category> query = session.createQuery("select a from Category a ", Category.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<CategoryParent> getCategoryParent(List<Category> categories) {
        List<CategoryParent> categoryParents = new ArrayList<>();
        for (int i = 0; i < categories.size() - 1; i++) {
            if (categories.get(i).getParentId() == null) {
                CategoryParent categoryParent = new CategoryParent();
                List<Category> parent = categoryParent.getParent();

                categoryParent.setCategoryName(categories.get(i).getCategoryName());
                for (int j = i + 1; j < categories.size() - 1; j++) {
                    if (categories.get(j).getParentId() != null) {
                        if (categories.get(j).getParentId() == categories.get(i).getCategoryId()) {
                            parent.add(categories.get(j));
                            categoryParent.setParent(parent);
                        }
                    }
                }
                categoryParents.add(categoryParent);
            }
        }
        return categoryParents;
    }

}
