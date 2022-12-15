import java.time.LocalDate;

public class Review {
    private Order order;
    final static int MIN_NUMBER_OF_SYMBOLS = 3000;
    final static int MIN_RATE = 0;
    final static int MAX_RATE = 5;
    private String description;
    private double rating;
    private LocalDate reviewDate;

    public Review (String description, double rating, LocalDate reviewDate) throws StringLengthException, TimeAfterNowException, ReviewRatingException {
        this(description, reviewDate);
        setRating(rating);
    }

    public Review (String description, LocalDate reviewDate) throws StringLengthException, TimeAfterNowException {
        setDescription(description);
        setReviewDate(reviewDate);
    }

    public Review (String description, double rating) throws StringLengthException, TimeAfterNowException, ReviewRatingException {
        this(description);
        setRating(rating);
    }

    public Review (String description) throws StringLengthException, TimeAfterNowException {
        setDescription(description);
        setReviewDate(LocalDate.now());
    }

    public static int getMinNumberOfSymbols() {
        return MIN_NUMBER_OF_SYMBOLS;
    }

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setDescription(String description) throws StringLengthException {
        if(description.isEmpty() || description.length() < MIN_NUMBER_OF_SYMBOLS){
            throw new StringLengthException();
        }else{
            this.description = description;
        }
    }

    public void setRating(double rating) throws ReviewRatingException {
        if (rating < MIN_RATE || rating > MAX_RATE){
            throw new ReviewRatingException();
        }else {
            this.rating = rating;
        }
    }

    public void setReviewDate(LocalDate reviewDate) throws TimeAfterNowException {
        LocalDate now = LocalDate.now();
        if(reviewDate.isAfter(now)){
            throw new TimeAfterNowException();
        }else {
            this.reviewDate = reviewDate;
        }
    }

    public boolean sendReview(){
        return true;
    }

    public boolean replyToCustomer(){
        return true;
    }

    public static boolean checkNewReview(){
        return true;
    }
}

