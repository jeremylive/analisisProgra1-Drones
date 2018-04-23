package Estructura;

public class TimeInstance 
{
    private String time;
    private int[] in;
    private int[] out;
    
    /**
     * Constructor.
     * @param pTime del ahora 
     */
    public TimeInstance(String pTime)
    {
        this.time = pTime;
        this.in = new int[2];
        this.out = new int[2];
    }
    /**
     * Gets and Sets
     */
    public String getTime() 
    {
        return time;
    }

    public void setTime(String time) 
    {
        this.time = time;
    }

    public int[] getIn() {
        return in;
    }

    public void setIn(int[] in) 
    {
        this.in = in;
    }

    public int[] getOut() 
    {
        return out;
    }

    public void setOut(int[] out) 
    {
        this.out = out;
    }
   
    
}
