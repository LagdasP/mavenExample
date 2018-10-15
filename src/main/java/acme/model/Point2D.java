package acme.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Point2D
{
    private Double lon;
    
    private Double lat;
    
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
    @NotNull
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    public Double getLon()
    {
        return lon;
    }
    
    @JsonProperty("longitude")
    @JsonAlias({"x", "lon"})
    public void setLon(Double x)
    {
        this.lon = x;
    }
    
    @JsonProperty("latitude")
    @NotNull
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    public Double getLat()
    {
        return lat;
    }
    
    @JsonProperty("latitude")
    @JsonAlias({"y", "lat"})
    public void setLat(Double y)
    {
        this.lat = y;
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

    @Override
    public String toString()
    {
        return "Point2D [lon=" + lon + ", lat=" + lat + ", name=" + name + "]";
    }
}
