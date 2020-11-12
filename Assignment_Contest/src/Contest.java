import java.io.*;
 

public class Contest implements Serializable {
    private String Analytics;
    private String Geometry;
    private String greed;
    private String DynamicPlanning;
    private String graph;
 
    public Contest() {
    }
 
    public Contest(String Analytics, String Geometry, String greed, String DynamicPlanning, String graph) {
        super();
        this.Analytics = Analytics;
        this.Geometry = Geometry;
        this.greed = greed;
        this.DynamicPlanning = DynamicPlanning;
        this.graph = graph;
    }
 
    public String getAnalytics() {
        return Analytics;
    }
 
    public void setId(String Analytics) {
        this.Analytics = Analytics;
    }
 
    public String getGeometry() {
        return Geometry;
    }
 
    public void setName(String Geometry) {
        this.Geometry = Geometry;
    }
 
    public String getgreed() {
        return greed;
    }
 
    public void setgreed(String greed) {
        this.greed = greed;
    }
 
    public String getDynamicPlanning() {
        return DynamicPlanning;
    }
 
    public void setAddress(String DynamicPlanning) {
        this.DynamicPlanning = DynamicPlanning;
    }
 
    public String getgraph() {
        return graph;
    }
 
    public void setgraph(String graph) {
        this.graph = graph;
    }
}