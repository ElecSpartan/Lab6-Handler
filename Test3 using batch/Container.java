import java.util.UUID;

public class Container implements Comparable<Container> {
    String shortName;
    String longName;
    String UUID;

    public Container(String shortName, String longName,String UUID){
        this.shortName=shortName;
        this.longName=longName;
        this.UUID=UUID;
    }
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    @Override
    public int compareTo(Container o) {
        return this.getShortName().compareToIgnoreCase(o.getShortName());
    }
    @Override
    public String toString(){
        return String.format("<CONTAINER UUID=\"%s\">\n" +
                "<SHORT-NAME>%s</SHORT-NAME>\n" +
                "<LONG-NAME>%s</LONG-NAME>\n" +
                "</CONTAINER>\n",UUID,shortName,longName);



    }
}
