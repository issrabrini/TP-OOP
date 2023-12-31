package Product;

import Account.User;

public class Review {
    private int rating;
    private String review;
    private User user;
    //Constructor:
    public Review(int rating, String review, User user) {
        this.user = user;
        this.rating = rating;
        this.review = review;
    }
    //getters and setters:
    public void setRating(int rating) {
        this.rating = rating;
    }
    public int getRating() {
        return rating;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public String getReview() {
        return review;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }
    //Displaying review:
    public void displayReview() {
        System.out.println("Account.User: " + user.getUsername());
        System.out.println( rating + " ★ ");
        System.out.println(review);
    }
}
