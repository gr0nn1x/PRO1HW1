package pro1;
import org.junit.jupiter.api.Assertions;
//gcd nejvetsi spolecny delitel
class GcdTest1
{
    @org.junit.jupiter.api.Test
    void test()
    {
        Assertions.assertEquals(
                10,
                NumericUtils.gcd(40,30)

        );
        Assertions.assertEquals(
                1,
                NumericUtils.gcd(21,25)

        );
        Assertions.assertEquals(
                1,
                NumericUtils.gcd(1,1)

        );
        Assertions.assertEquals(
                2,
                NumericUtils.gcd(66_666_666_666L,2)

        );
    }
}