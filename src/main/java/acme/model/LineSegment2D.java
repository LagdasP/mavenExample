package acme.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LineSegment2D
{
    private Point2D start;
    
    private Point2D end;
    
    private String name;
    
    public LineSegment2D() {}
    
    public LineSegment2D(Point2D p1, Point2D p2)
    {
        this(p1, p2, null);
    }
    
    public LineSegment2D(Point2D p1, Point2D p2, String name) 
    {
        this.start = new Point2D(p1);
        this.end = new Point2D(p2);
        this.name = name;
    }

    @JsonProperty("start")
    public Point2D getStart()
    {
        return start;
    }

    @JsonProperty("start")
    public void setStart(Point2D start)
    {
        this.start = start;
    }

    @JsonProperty("end")
    public Point2D getEnd()
    {
        return end;
    }

    @JsonProperty("end")
    public void setEnd(Point2D end)
    {
        this.end = end;
    }

    @JsonProperty("name")
    public String getName()
    {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "LineSegment2D [start=" + start + ", end=" + end + ", name=" + name + "]";
    }
}
