import java.util.*;

public class SimBank
{
    private int teller;
    private double hours;
    private double rate;
    private double mins;
    private int maxQ;
    private long seed;
    private int numK;
    private int amountCustomer = 0;
    private int createdCustomer = 0;
    private ArrayList<Customer> allCustomers;
    private ArrayList<Customer> turnedCustomers;
    private ArrayList<Teller> t;
    private int servedCustomer = 0;
    private int waitCustomer = 0;
    private double waitAvg;
    private double maxWait;
    private double waitDev;
    private double serviceAvg;
    private double timeAvg;
    private double currentTime = 0;
    private RandDist rand;
    private boolean qType;
    private SimEvent currentEvent;
    private Customer ctr;
    private PriorityQueue<SimEvent> futureEvent;
    private CompletionLocEvent complete;

    private ArrayList<Queue<Customer>> list;

    public SimBank(int tell,boolean qType,double hrs,double arr_rate,double t_min,int maxq,long seed)
    {
        teller = tell;
        hours = hrs;
        rate = arr_rate;
        mins = t_min;
        maxQ = maxq;
        this.qType = qType;
        this.seed = seed;

        rand = new RandDist(seed);

        list = new ArrayList<Queue<Customer>>(teller);
        if(qType == true)
        {
            list.add(new LinkedList<Customer>());
        }
        else
        {
            for(int x = 0; x < teller; x++)
            {
                list.add(new LinkedList<Customer>());
            }
        }
        System.out.println(teller + "*");
        t = new ArrayList<Teller>(teller);
        for(int x = 0; x < teller; x++)
        {
            t.add(new Teller());
        }
        allCustomers = new ArrayList<Customer>();
        turnedCustomers = new ArrayList<Customer>();
        futureEvent = new PriorityQueue<SimEvent>();

    }

    public void runSimulation()
    {
        System.out
        futureEvent.add(new ArrivalEvent(rand.exponential(rate * 60)));

        while(currentTime < (hours * 60))
        {
            currentEvent = futureEvent.remove();
            currentTime = currentEvent.get_e_time();
            
            if(currentEvent instanceof ArrivalEvent)
            {
                amountCustomer++;
                createdCustomer++;
                ctr = new Customer(amountCustomer, currentTime);
                allCustomers.add(ctr);
                if(amountCustomer < maxQ)
                {
                    addCustomer(ctr); 
                    futureEvent.add(new ArrivalEvent(currentTime + rand.exponential(rate) * 60));
                }
                else if(amountCustomer >= maxQ)
                {
                    turnedCustomers.add(ctr);
                }
                
            }
            else if(currentEvent instanceof CompletionLocEvent)
            {
                complete = new CompletionLocEvent(currentEvent.get_e_time(), amountCustomer);
                remove(complete.getLoc());
            }
        }

    }

    public void addCustomer(Customer c)
    {
        //System.out.println(t.size());
        for(int x = 0; x < teller; x++)
        {
            if(t.get(x).isOpen() == true)
            {
                t.get(x).addCustomer(c);
                futureEvent.add(new CompletionLocEvent(currentTime + rand.exponential((rate) * 60), amountCustomer));
                return;
            }
        }
        waitCustomer++;

        int small = 0;
        for(int x = 0; x < list.size(); x++)
        {
            if(list.get(small).size() > list.get(x).size())
            {
                small = x;
            }
        }
        list.get(small).add(c);
     }

     public void remove(int location)
     {
        t.get(location).removeCustomer();

        if(qType == true)
        {
            t.get(0).addCustomer(list.get(0).remove());
        }
        else
        {
            t.get(location).addCustomer(list.get(location).remove());
        }
    }
    public void showResults()
    {
        System.out.println("Customer \t Arrival \t Service \t Queue \t Teller \t Time Service \t Time Customer \t Time Service \t Time Spent");
        System.out.println("ID \t Time \t Time \t Loc \t Loc \t Begins \t Waits \t Ends \t");
        for(int x = 0; x < allCustomers.size(); x++)
        {
            System.out.println("\t" + x + "\t" + allCustomers.get(x).getTime());
        }
    }
}