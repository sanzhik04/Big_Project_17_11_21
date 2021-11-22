import java.io.Serializable;

public class City implements Serializable {
    Long id;
    String name;
    String country;
    String short_name;


    public City(Long id, String name, String country, String short_name){
        this.id = id;
        this.name = name;
        this.country = country;
        this.short_name = short_name;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    @Override
    public String toString() {
        return id+" "+name+" "+country+" "+short_name;
    }
}
