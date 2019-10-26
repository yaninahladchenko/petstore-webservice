package model;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class Pet extends BaseEntity {

    private Category category;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Pet createBarsik() {
        Category category = new Category();
        category.setId(123);
        category.setName("Cats");

        Pet pet = new Pet();
        pet.setName("Barsik");
        pet.setPhotoUrls(ImmutableList.of("someUrl"));
        pet.setCategory(category);
        pet.setStatus("available");
        return pet;
    }

}
