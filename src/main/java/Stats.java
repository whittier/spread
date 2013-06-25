/**
 * Stats implementation class.
 * Created By: Troy Whittier
 */
public class Stats implements Comparable<Stats>
{
    private String name;
    private int min;
    private int max;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getMin()
    {
        return min;
    }

    public void setMin(int min)
    {
        this.min = min;
    }

    public int getMax()
    {
        return max;
    }

    public void setMax(int max)
    {
        this.max = max;
    }

    public int getSpread()
    {
        return Math.abs(getMin() - getMax());
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Spread: " + getSpread();
    }

    @Override
    public int compareTo(Stats status) {
        if (getSpread() == status.getSpread())
        {
            return 0;
        }
        else if (getSpread() > status.getSpread())
        {
            return 1;
        }
        return -1;
    }
}
