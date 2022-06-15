package com.example.pharmacy;

public class model {
    String tradename, commonname, composition, batchno, quantity, costprice, sellingprice;

    public model(String tradename, String commonname, String composition, String batchno, String quantity, String costprice, String sellingprice) {
        this.tradename = tradename;
        this.commonname = commonname;
        this.composition = composition;
        this.batchno = batchno;
        this.quantity = quantity;
        this.costprice = costprice;
        this.sellingprice = sellingprice;
    }

    public String getTradename() {
        return tradename;
    }

    public void setTradename(String tradename) {
        this.tradename = tradename;
    }

    public String getCommonname() {
        return commonname;
    }

    public void setCommonname(String commonname) {
        this.commonname = commonname;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCostprice() {
        return costprice;
    }

    public void setCostprice(String costprice) {
        this.costprice = costprice;
    }

    public String getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(String sellingprice) {
        this.sellingprice = sellingprice;
    }
}
