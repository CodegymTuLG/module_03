package model;

public class ServiceTypeMaster {
    private int servicetype_id;
    private String type;

    public ServiceTypeMaster() {
    }

    public ServiceTypeMaster(int servicetype_id, String type) {
        this.servicetype_id = servicetype_id;
        this.type = type;
    }
    public ServiceTypeMaster(int servicetype_id) {
        this.servicetype_id = servicetype_id;
    }

    public int getServicetype_id() {
        return servicetype_id;
    }

    public void setServicetype_id(int servicetype_id) {
        this.servicetype_id = servicetype_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
