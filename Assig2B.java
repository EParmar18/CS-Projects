//CS 445
//Eshan Parmar

public class Assig2B
{
    public static void main(String args[])
    {
        String s = "";
        StringBuilder sb = new StringBuilder("");
        MyStringBuilder msb = new MyStringBuilder("");
        int n = Integer.parseInt(args[0]);
        char [] c = new char[n];
        for(int y = 0; y < n; y++)
        {
            c[y] = 'A';
        }
        double startTime = 0;
        double endTime = 0;

        for(int x = 0; x < 3; x++)
        {
            if(x == 0)
            {
                startTime = System.nanoTime();
                for(int z = 0; z < n; z++)
                {
                    sb.append(c[z]);
                }
                endTime = System.nanoTime();
                System.out.println("Testing Append:");
                System.out.println("\t Predefined StringBuilder:");
                System.out.println("\t\t Total Time: " + (endTime - startTime) + "ns for " + n + "appends");
                System.out.println("\t\t Time per append: " + ((endTime - startTime)/n + "ns"));

                startTime = System.nanoTime();
                while(sb.length() > 0)
                {
                    sb.delete(0,1);
                }
                endTime = System.nanoTime();
                System.out.println("Testing Remove:");
                System.out.println("\t Predefined StringBuilder:");
                System.out.println("\t Total Time: " + (endTime - startTime) + "ns for " + n + "appends");
                System.out.println("\t\t Time per remove: " + ((endTime - startTime)/n + "ns"));

                startTime = System.nanoTime();
                for(int z = 0; z < n; z++)
                {
                    if(sb.length()/2  == 0)
                    {
                        sb.insert(0,c[z]);
                    }
                    else
                    {
                        sb.insert((sb.length()/2), c[z]);
                    }
                }
                endTime = System.nanoTime();
                System.out.println("Testing Insert:");
                System.out.println("\t Predefined StringBuilder:");
                System.out.println("\t Total Time: " + (endTime - startTime) + "ns for " + n + "appends");
                System.out.println("\t\t Time per insert: " + ((endTime - startTime)/n + "ns"));
            }
            else if(x == 1)
            {
                
                startTime = System.nanoTime();
                for(int z = 0; z < n; z++)
                {
                    msb.append('A');
                }
                endTime = System.nanoTime();
                System.out.println("Testing Append:");
                System.out.println("\t MyStringBuilder:");
                System.out.println("\t\t Total Time: " + (endTime - startTime) + "ns for " + n + "appends");
                System.out.println("\t\t Time per append: " + ((endTime - startTime)/n + "ns"));
                
                startTime = System.nanoTime();
                while(msb.length() > 0)
                {
                    msb.delete(0,1);
                }
                endTime = System.nanoTime();
                System.out.println("Testing Remove:");
                System.out.println("\t MyStringBuilder:");
                System.out.println("\t Total Time: " + (endTime - startTime) + "ns for " + n + "appends");
                System.out.println("\t\t Time per remove: " + ((endTime - startTime)/n + "ns"));

                startTime = System.nanoTime();
                for(int z = 0; z < n; z++)
                {
                    if(msb.length()/2  == 0)
                    {
                        msb.insert(0,c[z]);
                    }
                    else
                    {
                        msb.insert((msb.length()/2), c[z]);
                    }
                }
                endTime = System.nanoTime();
                System.out.println("Testing Insert:");
                System.out.println("\t MyStringBuilder:");
                System.out.println("\t Total Time: " + (endTime - startTime) + "ns for " + n + "appends");
                System.out.println("\t\t Time per insert: " + ((endTime - startTime)/n + "ns"));
            }
            else
            {
                startTime = System.nanoTime();
                for(int z = 0; z < n; z++)
                {
                    s+=c[z];
                }
                endTime = System.nanoTime();
                System.out.println("Testing Append:");
                System.out.println("\t Predefined String:");
                System.out.println("\t\t Total Time: " + (endTime - startTime) + "ns for " + n + "appends");
                System.out.println("\t\t Time per append: " + ((endTime - startTime)/n + "ns"));

                startTime = System.nanoTime();
                int num = n;
                while(s.length() > 0)
                {
                    s= s.substring(0,num);
                    num--;
                }
                endTime = System.nanoTime();
                System.out.println("Testing Remove:");
                System.out.println("\t Predefined String:");
                System.out.println("\t Total Time: " + (endTime - startTime) + "ns for " + n + "appends");
                System.out.println("\t\t Time per remove: " + ((endTime - startTime)/n + "ns"));

                startTime = System.nanoTime();
                for(int z = 0; z < n; z++)
                {
                    if(s.length()/2  == 0)
                    {
                        s+= c[z];
                    }
                    else
                    {
                        s = (s.substring(0, (s.length()/2)) + c[z] + s.substring((s.length()/2), s.length()));
                    }
                }
                endTime = System.nanoTime();
                System.out.println("Testing Insert:");
                System.out.println("\t Predefined String:");
                System.out.println("\t Total Time: " + (endTime - startTime) + "ns for " + n + "appends");
                System.out.println("\t\t Time per insert: " + ((endTime - startTime)/n + "ns"));
            }
        }




    }
}