package by.horant.task3.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Food implements Serializable {

    private static final long serialVersionUID = 1356530358601064714L;
    public static final int VALUE_FOR_HASH_1 = 1;
    public static final int VALUE_FOR_HASH_2 = 31;

    private int id;
    private String title;
    private String category;
    private String photoPath;
    private String generalDescription;

    public Food() {

    }

    public Food(int id, String title, String category, String photoPath, String generalDescription) {
	this.id = id;
	this.title = title;
	this.category = category;
	this.photoPath = photoPath;
	this.generalDescription = generalDescription;
    }

    public Food(Food food) {
	this(food.id, food.title, food.category, food.photoPath, food.generalDescription);
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getCategory() {
	return category;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    public String getPhotoPath() {
	return photoPath;
    }

    public void setPhotoPath(String photoPath) {
	this.photoPath = photoPath;
    }

    public String getGeneralDescription() {
	return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
	this.generalDescription = generalDescription;
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(VALUE_FOR_HASH_1, VALUE_FOR_HASH_2).append(id).append(title).append(category)
		.append(photoPath).append(generalDescription).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

	if (this == obj) {
	    return true;
	}

	if (obj == null) {
	    return false;
	}

	if (getClass() != obj.getClass()) {
	    return false;
	}

	Food other = (Food) obj;

	return new EqualsBuilder().append(this.id, other.id).append(this.title, other.title)
		.append(this.category, other.category).append(this.photoPath, other.photoPath)
		.append(this.generalDescription, other.generalDescription).isEquals();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).append("id", id).append("title", title).append("category", category)
		.append("photoPath", photoPath).append("generalDescription", generalDescription).toString();
    }

}
