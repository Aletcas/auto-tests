import org.junit.Assert;
import org.junit.Test;

public class TicketTests {

    @Test
    public void Should_Be100_When_HoursBeforeConcertIsMore240() {
        Integer actualResult = this.getRefundTicketPricePercent(241, false, false);
        Assert.assertEquals("100", actualResult.toString());
    }
   
    @Test
    public void Should_Be50_When_HoursBeforeConcertIsMore144() {
        Integer actualResult = this.getRefundTicketPricePercent(145, false, false);
        Assert.assertEquals("50", actualResult.toString());
    }

    @Test
    public void Should_Be50_When_HoursBeforeConcertIsEqually144() {
        Integer actualResult = this.getRefundTicketPricePercent(144, false, false);
        Assert.assertEquals("50", actualResult.toString());
    }

    @Test
    public void Should_Be30_When_HoursBeforeConcertIsMore3() {
        Integer actualResult = this.getRefundTicketPricePercent(4, false, false);
        Assert.assertEquals("30", actualResult.toString());
    }

    @Test
    public void Should_Be0_When_HoursBeforeConcertIsSmaller3() {
        Integer actualResult = this.getRefundTicketPricePercent(1, false, false);
        Assert.assertEquals("0", actualResult.toString());
    }

    @Test
    public void Should_Be100_When_CancelledConcert() {
        Integer actualResult = this.getRefundTicketPricePercent(10, true, false);
        Assert.assertEquals("100", actualResult.toString());
    }

    @Test
    public void Should_Be100_When_RescheduledConcert() {
        Integer actualResult = this.getRefundTicketPricePercent(10, false, true);
        Assert.assertEquals("100", actualResult.toString());
    }

    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert,
                                                Boolean wasConcertCancelled, Boolean wasConcertRescheduled) {
        if (wasConcertCancelled && wasConcertRescheduled) {
            return 100;
        } else if (hoursBeforeConcert > 240) {
            return 100;
        } else if (hoursBeforeConcert >= 144 && hoursBeforeConcert <= 240) {
            return 50;
        } else {
            return hoursBeforeConcert > 3 && hoursBeforeConcert <= 144 ? 30 : 0;
        }
    }
}
