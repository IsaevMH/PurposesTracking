package org.purposetracking.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "serial")
    private long categoryId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Purpose> purposeSet;

    public Category() {}

    public long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(long caregory_id) {
        this.categoryId = caregory_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryId == category.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId);
    }
}
