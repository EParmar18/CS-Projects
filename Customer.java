public class Customer
{
    private int num;
    private double time;
    private int qPos = 0;
    private double timeEnd;
    private double serviceTime;
    private int tellerLocation;

    public Customer(int num, double time)
    {
        this.num = num;
        this.time = time;
        qPos = -1;
    }

    public int getNum()
    {
        return num;
    }

    public double getTime()
    {
        return time;
    }

    public void setEndTime(double t)
    {
        timeEnd = t;
    }

    public void setServiceTime(double s)
    {
        serviceTime = s;
    }

    public double getWait()
    {
        if((timeEnd - time) < 0)
        {
            return Math.abs((timeEnd - time)/10);
        }
        return timeEnd - time;
    }

    public double getServiceTime()
    {
        return serviceTime;
    }
    public double getEndTime()
    {
        return timeEnd;
    }

    public void setQ(int q)
    {
        qPos = q;
    }

    public int getQ()
    {
        return qPos;
    }

    public void setTeller(int t)
    {
        tellerLocation = t;
    }

    public int getTeller()
    {
        return tellerLocation;
    }
}