import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * SpreadServiceTest implementation class.
 * Created By: Troy Whittier
 */
public class SpreadServiceTest
{
    @Test
    public void testFindMinSpreadForFootball() throws Exception
    {
        SpreadService ws = new SpreadService();
        Stats stat = ws.findMinSpread("football.dat", new int[]{1, 6, 8});
        System.out.println(stat);
        assertEquals(1, stat.getSpread());

    }

    @Test
    public void testFindMinSpreadForWeather() throws Exception
    {
        SpreadService ws = new SpreadService();
        Stats stat = ws.findMinSpread("weather.dat", new int[]{0, 1, 2});
        System.out.println(stat);
        assertEquals(2, stat.getSpread());

    }
}
