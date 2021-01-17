package core.domain;

import com.google.gson.annotations.SerializedName;

public class RatesResponse {

    public static final String EUR = "EUR";
    public static final String CAD = "CAD";
    public static final String HKD = "HKD";
    public static final String ISK = "ISK";
    public static final String PHP = "PHP";
    public static final String DKK = "DKK";
    public static final String HUF = "HUF";
    public static final String CZK = "CZK";
    public static final String AUD = "AUD";
    public static final String INR = "INR";
    public static final String RUB = "RUB";
    public static final String JPY = "JPY";
    public static final String CNY = "CNY";
    public static final String USD = "USD";
    public static final String GBP = "GBP";

    @SerializedName(CAD)
    private double cad;
    @SerializedName(HKD)
    private double hkd;
    @SerializedName(ISK)
    private double isk;
    @SerializedName(PHP)
    private double php;
    @SerializedName(DKK)
    private double dkk;
    @SerializedName(HUF)
    private double huf;
    @SerializedName(CZK)
    private double czk;
    @SerializedName(AUD)
    private double aud;
    @SerializedName(INR)
    private double inr;
    @SerializedName(RUB)
    private double rub;
    @SerializedName(JPY)
    private double jpy;
    @SerializedName(CNY)
    private double cny;
    @SerializedName(USD)
    private double usd;
    @SerializedName(GBP)
    private double gbp;

    public void setCad(double cad) {
        this.cad = cad;
    }
    public double getCad() {
        return cad;
    }

    public void setHkd(double hkd) {
        this.hkd = hkd;
    }
    public double getHkd() {
        return hkd;
    }

    public void setIsk(double isk) {
        this.isk = isk;
    }
    public double getIsk() {
        return isk;
    }

    public void setPhp(double php) {
        this.php = php;
    }
    public double getPhp() {
        return php;
    }

    public void setDkk(double dkk) {
        this.dkk = dkk;
    }
    public double getDkk() {
        return dkk;
    }

    public void setHuf(double huf) {
        this.huf = huf;
    }
    public double getHuf() {
        return huf;
    }

    public void setCzk(double czk) {
        this.czk = czk;
    }
    public double getCzk() {
        return czk;
    }

    public void setAud(double aud) {
        this.aud = aud;
    }
    public double getAud() {
        return aud;
    }

    public void setInr(double inr) {
        this.inr = inr;
    }
    public double getInr() {
        return inr;
    }

    public void setRub(double rub) {
        this.rub = rub;
    }
    public double getRub() {
        return rub;
    }

    public void setJpy(double jpy) {
        this.jpy = jpy;
    }
    public double getJpy() {
        return jpy;
    }

    public void setCny(double cny) {
        this.cny = cny;
    }
    public double getCny() {
        return cny;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }
    public double getUsd() {
        return usd;
    }

    public void setGbp(double gbp) {
        this.gbp = gbp;
    }
    public double getGbp() {
        return gbp;
    }

    @Override
    public String toString() {
        return "RatesResponse{" +
                "cad=" + cad +
                ", hkd=" + hkd +
                ", isk=" + isk +
                ", php=" + php +
                ", dkk=" + dkk +
                ", huf=" + huf +
                ", czk=" + czk +
                ", aud=" + aud +
                ", inr=" + inr +
                ", rub=" + rub +
                ", jpy=" + jpy +
                ", cny=" + cny +
                ", usd=" + usd +
                ", gbp=" + gbp +
                '}';
    }
}