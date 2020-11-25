import org.junit.Assert;
import org.junit.Test;

public class TooLessonScoresTests {

    @Test
    public void Should_ReturnMark2_When_ScoreEquals0() {
        var actualResult = getMarkResult(0);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void Should_ReturnMark2_When_ScoreMoreThan_ScoreEquals0AndLessThan_ScoreEquals35() {
        var actualResult = getMarkResult(20);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void Should_ReturnMark2_When_ScoreMoreThan_ScoreEquals35() {
        var actualResult = getMarkResult(35);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void Should_ReturnMark3_When_ScoreMoreThan35AndLessThan_ScoreEquals56() {
        var actualResult = getMarkResult(50);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void Should_ReturnMark3_When_ScoreEquals56() {
        var actualResult = getMarkResult(56);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void Should_ReturnMark4_When_ScoreMoreThan56AndLessThan_ScoreEquals71() {
        var actualResult = getMarkResult(65);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void Should_ReturnMark4_When_ScoreEquals71() {
        var actualResult = getMarkResult(71);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void Should_ReturnMark4_When_ScoreMoreThan_ScoreEquals72() {
        var actualResult = getMarkResult(72);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void Should_ReturnMark5_When_ScoreMoreThan_ScoreEquals72AndLessThan100() {
        var actualResult = getMarkResult(73);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void Should_ReturnMark3_When_ScoreMoreThan72AndLessThan100() {
        var actualResult = getMarkResult(80);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void Should_ReturnMark3_When_ScoreMoreThan72AndLessThan_ScoreEquals100() {
        var actualResult = getMarkResult(100);
        Assert.assertEquals("5", actualResult);
    }

    private String getMarkResult(Integer mark) {
        if (mark >= 0 && mark <= 35) return "2";
        if (mark > 35 && mark <= 56) return "3";
        if (mark > 56 && mark < 71) return "4";
        if (mark > 72 && mark < 100) return "5";
        return "no mark result";
    }
}
