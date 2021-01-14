import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Arrays;

@JacksonXmlRootElement(localName = "currencies") public final class Currencies {
@JacksonXmlElementWrapper(localName = "currency", useWrapping = false)
    public Currency[] currency;

    public Currencies() {
    }

    public Currencies(Currency[] currency) {
        this.currency = currency;
    }

    public Currency[] getTargetCurrency() {
        return currency;
    }

    public void setCurrency(Currency[] targetCurrency) {
        this.currency = targetCurrency;
    }

    @Override public String toString() {
        return "Currencies{" +
                "currencies=" + Arrays.toString(currency) +
                '}';
    }
}