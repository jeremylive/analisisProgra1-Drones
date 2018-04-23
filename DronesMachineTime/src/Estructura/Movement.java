package Estructura;

public class Movement 
{
    private int originId, destinationId;
    private int startTime, endTime;

    public Movement(int originId, int destinationId, int startTime, int endTime) 
    {
        this.originId = originId;
        this.destinationId = destinationId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getOriginId() 
    {
        return originId;
    }

    public void setOriginId(int originId) 
    {
        this.originId = originId;
    }

    public int getDestinationId() 
    {
        return destinationId;
    }

    public void setDestinationId(int destinationId) 
    {
        this.destinationId = destinationId;
    }

    public int getStartTime() 
    {
        return startTime;
    }

    public void setStartTime(int startTime) 
    {
        this.startTime = startTime;
    }

    public int getEndTime() 
    {
        return endTime;
    }

    public void setEndTime(int endTime) 
    {
        this.endTime = endTime;
    }
    
}
