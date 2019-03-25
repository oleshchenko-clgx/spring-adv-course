package beans.models;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter
        extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, DateTimeFormatter.ISO_LOCAL_DATE);
    }
    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
