package com.example.dormi;

public class FoodObject {
    private String title;
    private String breakfast;
    private String lunch;
    private String dinner;

    public FoodObject(String title, String breakfast, String lunch, String dinner){
        this.title = title;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public String getTitle() {
        return title;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public String getDinner() {
        return dinner;
    }
}
