package acme.model;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Valid
    @NotNull
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
    @Valid
    @NotNull
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
    @NotEmpty
    public String getName()
    {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name)
    {
        this.name = name;
    }

    @JsonIgnore
    @DecimalMin("1E-6")
    public Double getLength()
    {
        if (start == null || end == null)
            return null;
        
        double dx = start.getLon() - end.getLon();
        double dy = start.getLat() - end.getLat();
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    @Override
    public String toString()
    {
        return "LineSegment2D [start=" + start + ", end=" + end + ", name=" + name + "]";
    }
}
