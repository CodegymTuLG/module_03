package model;

public class ContractDetail {
    private int contract_id;
    private int accompaniedservice_id;
    private int count;

    public ContractDetail() {
    }

    public ContractDetail(int contract_id, int accompaniedservice_id, int count) {
        this.contract_id = contract_id;
        this.accompaniedservice_id = accompaniedservice_id;
        this.count = count;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getAccompaniedservice_id() {
        return accompaniedservice_id;
    }

    public void setAccompaniedservice_id(int accompaniedservice_id) {
        this.accompaniedservice_id = accompaniedservice_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
