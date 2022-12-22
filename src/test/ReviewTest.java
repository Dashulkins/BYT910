import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReviewTest {
    Review testReview;
    DateTimeFormatter formatter;

    @Before
    public void setUp() throws StringLengthException, ReviewRatingException, TimeAfterNowException {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        testReview = new Review("""
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                """,
                4.6, LocalDate.parse("23-12-2021", formatter));
    }


    @Test
    public void Review3Parameters() throws StringLengthException, TimeAfterNowException, ReviewRatingException {
        String descr = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit fringilla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Nam pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, posuere ut, mauris. Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc. Nunc nonummy metus. Vestibulum volutpat pretium libero. Cras id dui. Aenean ut eros et nisl sagittis vestibulum. Nullam nulla eros, ultricies sit amet, nonummy id, imperdiet feugiat, pede. Sed lectus. Donec mollis hendrerit risus. Phasellus nec sem in justo pellentesque facilisis. Etiam imperdiet imperdiet orci. Nunc nec neque. Phasellus leo dolor, tempus non, auctor et, hendrerit quis, nisi. Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Maecenas malesuada. Praesent congue erat at massa. Sed cursus turpis vitae tortor. Donec posuere vulputate arcu. Phasellus accumsan cursus velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed aliquam, nisi quis porttitor congue, elit erat euismod orci, ac placerat dolor lectus quis orci. Phasellus consectetuer vestibulum elit. Aenean tellus metus, bibendum sed, posuere ac, mattis non, nunc. Vestibulum fringilla pede sit amet augue. In turpis. Pellentesque posuere. Praesent turpis. Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Donec el";
        double rate = 3;
        LocalDate date = LocalDate.parse("23-12-2021", formatter);
        Review review = new Review(descr, rate, date);
        Assert.assertEquals(descr, review.getDescription());
        Assert.assertEquals(Double.valueOf(rate), Double.valueOf(review.getRating()));
        Assert.assertEquals(date, review.getReviewDate());
    }

    @Test
    public void ReviewDescrDate() throws StringLengthException, TimeAfterNowException {
        String descr = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit fringilla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Nam pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, posuere ut, mauris. Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc. Nunc nonummy metus. Vestibulum volutpat pretium libero. Cras id dui. Aenean ut eros et nisl sagittis vestibulum. Nullam nulla eros, ultricies sit amet, nonummy id, imperdiet feugiat, pede. Sed lectus. Donec mollis hendrerit risus. Phasellus nec sem in justo pellentesque facilisis. Etiam imperdiet imperdiet orci. Nunc nec neque. Phasellus leo dolor, tempus non, auctor et, hendrerit quis, nisi. Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Maecenas malesuada. Praesent congue erat at massa. Sed cursus turpis vitae tortor. Donec posuere vulputate arcu. Phasellus accumsan cursus velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed aliquam, nisi quis porttitor congue, elit erat euismod orci, ac placerat dolor lectus quis orci. Phasellus consectetuer vestibulum elit. Aenean tellus metus, bibendum sed, posuere ac, mattis non, nunc. Vestibulum fringilla pede sit amet augue. In turpis. Pellentesque posuere. Praesent turpis. Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Donec el";
        LocalDate date = LocalDate.parse("23-12-2021", formatter);
        Review review = new Review(descr, date);
        Assert.assertEquals(descr, review.getDescription());
        Assert.assertEquals(Double.valueOf(0), Double.valueOf(review.getRating()));
        Assert.assertEquals(date, review.getReviewDate());
    }

    @Test
    public void ReviewDescrRate() throws StringLengthException, TimeAfterNowException, ReviewRatingException {
        String descr = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit fringilla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Nam pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, posuere ut, mauris. Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc. Nunc nonummy metus. Vestibulum volutpat pretium libero. Cras id dui. Aenean ut eros et nisl sagittis vestibulum. Nullam nulla eros, ultricies sit amet, nonummy id, imperdiet feugiat, pede. Sed lectus. Donec mollis hendrerit risus. Phasellus nec sem in justo pellentesque facilisis. Etiam imperdiet imperdiet orci. Nunc nec neque. Phasellus leo dolor, tempus non, auctor et, hendrerit quis, nisi. Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Maecenas malesuada. Praesent congue erat at massa. Sed cursus turpis vitae tortor. Donec posuere vulputate arcu. Phasellus accumsan cursus velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed aliquam, nisi quis porttitor congue, elit erat euismod orci, ac placerat dolor lectus quis orci. Phasellus consectetuer vestibulum elit. Aenean tellus metus, bibendum sed, posuere ac, mattis non, nunc. Vestibulum fringilla pede sit amet augue. In turpis. Pellentesque posuere. Praesent turpis. Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Donec el";
        double rate = 3;
        LocalDate date = LocalDate.now();
        Review review = new Review(descr, rate);
        Assert.assertEquals(descr, review.getDescription());
        Assert.assertEquals(Double.valueOf(rate), Double.valueOf(review.getRating()));
        Assert.assertEquals(date, review.getReviewDate());
    }

    @Test
    public void ReviewDescr() throws StringLengthException, TimeAfterNowException {
        String descr = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit fringilla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Nam pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, posuere ut, mauris. Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc. Nunc nonummy metus. Vestibulum volutpat pretium libero. Cras id dui. Aenean ut eros et nisl sagittis vestibulum. Nullam nulla eros, ultricies sit amet, nonummy id, imperdiet feugiat, pede. Sed lectus. Donec mollis hendrerit risus. Phasellus nec sem in justo pellentesque facilisis. Etiam imperdiet imperdiet orci. Nunc nec neque. Phasellus leo dolor, tempus non, auctor et, hendrerit quis, nisi. Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Maecenas malesuada. Praesent congue erat at massa. Sed cursus turpis vitae tortor. Donec posuere vulputate arcu. Phasellus accumsan cursus velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed aliquam, nisi quis porttitor congue, elit erat euismod orci, ac placerat dolor lectus quis orci. Phasellus consectetuer vestibulum elit. Aenean tellus metus, bibendum sed, posuere ac, mattis non, nunc. Vestibulum fringilla pede sit amet augue. In turpis. Pellentesque posuere. Praesent turpis. Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Donec el";
        LocalDate date = LocalDate.now();
        Review review = new Review(descr);
        Assert.assertEquals(descr, review.getDescription());
        Assert.assertEquals(Double.valueOf(0), Double.valueOf(review.getRating()));
        Assert.assertEquals(date, review.getReviewDate());
    }

    @Test
    public void getMinNumberOfSymbols() {
        Assert.assertEquals(Integer.valueOf(Review.getMinNumberOfSymbols()), Integer.valueOf(3000));
    }

    @Test
    public void getDescription() {
        Assert.assertEquals("""
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve. While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                While this can be upsetting to read, this type of negative feedback can be very helpful to your business in the long run. Negative reviews that offer specific reasons can show you exactly where your business is missing the mark.  When responding to this review, address each concern the customer has. Take ownership of where you went wrong, and explain how you are planning to improve.\s
                """, testReview.getDescription());
    }

    @Test
    public void getRating() throws ReviewRatingException {
        Assert.assertEquals(Double.valueOf(4.6), Double.valueOf(testReview.getRating()));
        testReview.setRating(3.4);
        Assert.assertEquals(Double.valueOf(3.4), Double.valueOf(testReview.getRating()));
    }

    @Test
    public void getReviewDate() throws TimeAfterNowException {
        Assert.assertEquals(LocalDate.parse("23-12-2021", formatter), testReview.getReviewDate());
        testReview.setReviewDate(LocalDate.parse("11-11-2022", formatter));
        Assert.assertEquals(LocalDate.parse("11-11-2022", formatter), testReview.getReviewDate());

    }

    @Test
    public void setDescription() {
        boolean isShort = false;
        try {
            testReview.setDescription("gshsk");
        } catch (StringLengthException ignored) {
            isShort = true;
        }
        Assert.assertTrue(isShort);
    }

    @Test
    public void setRating() {
        boolean isNegative = false;
        boolean isHigherThanMax = false;
        try {
            testReview.setRating(-2);
        } catch (ReviewRatingException ignored) {
            isNegative = true;
        }
        Assert.assertTrue(isNegative);

        try {
            testReview.setRating(42);
        } catch (ReviewRatingException ignored) {
            isHigherThanMax = true;
        }
        Assert.assertTrue(isHigherThanMax);
    }

    @Test
    public void setReviewDate() throws TimeAfterNowException {
        boolean isFutureDate = false;
        try {
            testReview.setReviewDate(LocalDate.parse("21-10-2023", formatter));
        } catch (TimeAfterNowException ignored) {
            isFutureDate = true;
        }
        Assert.assertTrue(isFutureDate);
        testReview.setReviewDate(LocalDate.parse("19-03-2021", formatter));
        Assert.assertEquals(LocalDate.parse("19-03-2021", formatter), testReview.getReviewDate());
    }
}
