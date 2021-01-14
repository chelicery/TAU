import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public final class Currency  {
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private String id;
    @JacksonXmlProperty(localName = "targetCurrency")
    private String targetCurrency;
    @JacksonXmlProperty(localName = "rate")
    private double rate;


    public Currency() {
    }

    public Currency(String id, String targetCurrency, double rate) {
        this.id = id;
        this.targetCurrency = targetCurrency;
        this.rate = rate;        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


    @Override public String toString() {
        return "Currency{" +
                "id='" + id + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", rate='" + rate + '\'' +                
                '}';
    }
}