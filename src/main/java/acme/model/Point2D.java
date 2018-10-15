package acme.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Point2D
{
    private double lon;
    
    private double lat;
    
    private String name;
    
    public Point2D() {}
    
    public Point2D(double lon, double lat, String name) 
    {
        this.lon = lon;
        this.lat = lat;
        this.name = name;
    }
    
    public Point2D(Point2D other)
    {
        this.lon = other.lon;
        this.lat = other.lat;
        this.name = other.name;
    }
    
    @JsonProperty("longitude")
    public double getLon()
    {
        return lon;
    }
    
    @JsonProperty("longitude")
    @JsonAlias({"x", "lon"})
    public void setLon(double x)
    {
        this.lon = x;
    }
    
    @JsonProperty("latitude")
    public double getLat()
    {
        return lat;
    }
    
    @JsonProperty("latitude")
    @JsonAlias({"y", "lat"})
    public void setLat(double y)
    {
        this.lat = y;
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
        return "Point2D [lon=" + lon + ", lat=" + lat + ", name=" + name + "]";
    }
}
