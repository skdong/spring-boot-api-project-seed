package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class Rawdata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date date;

    @Column(name = "tempOut")
    private Integer tempout;

    @Column(name = "hiTemp")
    private Integer hitemp;

    @Column(name = "lowTemp")
    private Integer lowtemp;

    private Integer dewpt;

    @Column(name = "wind_speed")
    private Integer windSpeed;

    @Column(name = "wind_dir")
    private Integer windDir;

    @Column(name = "wind_run")
    private Integer windRun;

    @Column(name = "hi_speed")
    private Integer hiSpeed;

    @Column(name = "hi_dir")
    private Integer hiDir;

    @Column(name = "wind_chill")
    private Integer windChill;

    @Column(name = "heat_index")
    private Integer heatIndex;

    @Column(name = "thw_index")
    private Integer thwIndex;

    @Column(name = "thsw_index")
    private Integer thswIndex;

    private Integer bar;

    private Integer rain;

    @Column(name = "rain_rate")
    private Integer rainRate;

    @Column(name = "solar_sad")
    private Integer solarSad;

    @Column(name = "solar_enery")
    private Integer solarEnery;

    @Column(name = "hi_solar_rad")
    private Integer hiSolarRad;

    @Column(name = "uv_index")
    private Integer uvIndex;

    @Column(name = "uv_does")
    private Integer uvDoes;

    @Column(name = "hi_uv")
    private Integer hiUv;

    @Column(name = "heat_dd")
    private Integer heatDd;

    @Column(name = "cool_dd")
    private Integer coolDd;

    @Column(name = "in_temp")
    private Integer inTemp;

    @Column(name = "in_hum")
    private Integer inHum;

    @Column(name = "in_dew")
    private Integer inDew;

    @Column(name = "in_heat")
    private Integer inHeat;

    @Column(name = "in_emc")
    private Integer inEmc;

    @Column(name = "in_air_density")
    private Integer inAirDensity;

    private Integer et;

    @Column(name = "wind_samp")
    private Integer windSamp;

    @Column(name = "wind_tx")
    private Integer windTx;

    @Column(name = "iss_recept")
    private Integer issRecept;

    @Column(name = "arc_int")
    private Integer arcInt;

    @Column(name = "outHum")
    private Integer outhum;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return tempOut
     */
    public Integer getTempout() {
        return tempout;
    }

    /**
     * @param tempout
     */
    public void setTempout(Integer tempout) {
        this.tempout = tempout;
    }

    /**
     * @return hiTemp
     */
    public Integer getHitemp() {
        return hitemp;
    }

    /**
     * @param hitemp
     */
    public void setHitemp(Integer hitemp) {
        this.hitemp = hitemp;
    }

    /**
     * @return lowTemp
     */
    public Integer getLowtemp() {
        return lowtemp;
    }

    /**
     * @param lowtemp
     */
    public void setLowtemp(Integer lowtemp) {
        this.lowtemp = lowtemp;
    }

    /**
     * @return dewpt
     */
    public Integer getDewpt() {
        return dewpt;
    }

    /**
     * @param dewpt
     */
    public void setDewpt(Integer dewpt) {
        this.dewpt = dewpt;
    }

    /**
     * @return wind_speed
     */
    public Integer getWindSpeed() {
        return windSpeed;
    }

    /**
     * @param windSpeed
     */
    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * @return wind_dir
     */
    public Integer getWindDir() {
        return windDir;
    }

    /**
     * @param windDir
     */
    public void setWindDir(Integer windDir) {
        this.windDir = windDir;
    }

    /**
     * @return wind_run
     */
    public Integer getWindRun() {
        return windRun;
    }

    /**
     * @param windRun
     */
    public void setWindRun(Integer windRun) {
        this.windRun = windRun;
    }

    /**
     * @return hi_speed
     */
    public Integer getHiSpeed() {
        return hiSpeed;
    }

    /**
     * @param hiSpeed
     */
    public void setHiSpeed(Integer hiSpeed) {
        this.hiSpeed = hiSpeed;
    }

    /**
     * @return hi_dir
     */
    public Integer getHiDir() {
        return hiDir;
    }

    /**
     * @param hiDir
     */
    public void setHiDir(Integer hiDir) {
        this.hiDir = hiDir;
    }

    /**
     * @return wind_chill
     */
    public Integer getWindChill() {
        return windChill;
    }

    /**
     * @param windChill
     */
    public void setWindChill(Integer windChill) {
        this.windChill = windChill;
    }

    /**
     * @return heat_index
     */
    public Integer getHeatIndex() {
        return heatIndex;
    }

    /**
     * @param heatIndex
     */
    public void setHeatIndex(Integer heatIndex) {
        this.heatIndex = heatIndex;
    }

    /**
     * @return thw_index
     */
    public Integer getThwIndex() {
        return thwIndex;
    }

    /**
     * @param thwIndex
     */
    public void setThwIndex(Integer thwIndex) {
        this.thwIndex = thwIndex;
    }

    /**
     * @return thsw_index
     */
    public Integer getThswIndex() {
        return thswIndex;
    }

    /**
     * @param thswIndex
     */
    public void setThswIndex(Integer thswIndex) {
        this.thswIndex = thswIndex;
    }

    /**
     * @return bar
     */
    public Integer getBar() {
        return bar;
    }

    /**
     * @param bar
     */
    public void setBar(Integer bar) {
        this.bar = bar;
    }

    /**
     * @return rain
     */
    public Integer getRain() {
        return rain;
    }

    /**
     * @param rain
     */
    public void setRain(Integer rain) {
        this.rain = rain;
    }

    /**
     * @return rain_rate
     */
    public Integer getRainRate() {
        return rainRate;
    }

    /**
     * @param rainRate
     */
    public void setRainRate(Integer rainRate) {
        this.rainRate = rainRate;
    }

    /**
     * @return solar_sad
     */
    public Integer getSolarSad() {
        return solarSad;
    }

    /**
     * @param solarSad
     */
    public void setSolarSad(Integer solarSad) {
        this.solarSad = solarSad;
    }

    /**
     * @return solar_enery
     */
    public Integer getSolarEnery() {
        return solarEnery;
    }

    /**
     * @param solarEnery
     */
    public void setSolarEnery(Integer solarEnery) {
        this.solarEnery = solarEnery;
    }

    /**
     * @return hi_solar_rad
     */
    public Integer getHiSolarRad() {
        return hiSolarRad;
    }

    /**
     * @param hiSolarRad
     */
    public void setHiSolarRad(Integer hiSolarRad) {
        this.hiSolarRad = hiSolarRad;
    }

    /**
     * @return uv_index
     */
    public Integer getUvIndex() {
        return uvIndex;
    }

    /**
     * @param uvIndex
     */
    public void setUvIndex(Integer uvIndex) {
        this.uvIndex = uvIndex;
    }

    /**
     * @return uv_does
     */
    public Integer getUvDoes() {
        return uvDoes;
    }

    /**
     * @param uvDoes
     */
    public void setUvDoes(Integer uvDoes) {
        this.uvDoes = uvDoes;
    }

    /**
     * @return hi_uv
     */
    public Integer getHiUv() {
        return hiUv;
    }

    /**
     * @param hiUv
     */
    public void setHiUv(Integer hiUv) {
        this.hiUv = hiUv;
    }

    /**
     * @return heat_dd
     */
    public Integer getHeatDd() {
        return heatDd;
    }

    /**
     * @param heatDd
     */
    public void setHeatDd(Integer heatDd) {
        this.heatDd = heatDd;
    }

    /**
     * @return cool_dd
     */
    public Integer getCoolDd() {
        return coolDd;
    }

    /**
     * @param coolDd
     */
    public void setCoolDd(Integer coolDd) {
        this.coolDd = coolDd;
    }

    /**
     * @return in_temp
     */
    public Integer getInTemp() {
        return inTemp;
    }

    /**
     * @param inTemp
     */
    public void setInTemp(Integer inTemp) {
        this.inTemp = inTemp;
    }

    /**
     * @return in_hum
     */
    public Integer getInHum() {
        return inHum;
    }

    /**
     * @param inHum
     */
    public void setInHum(Integer inHum) {
        this.inHum = inHum;
    }

    /**
     * @return in_dew
     */
    public Integer getInDew() {
        return inDew;
    }

    /**
     * @param inDew
     */
    public void setInDew(Integer inDew) {
        this.inDew = inDew;
    }

    /**
     * @return in_heat
     */
    public Integer getInHeat() {
        return inHeat;
    }

    /**
     * @param inHeat
     */
    public void setInHeat(Integer inHeat) {
        this.inHeat = inHeat;
    }

    /**
     * @return in_emc
     */
    public Integer getInEmc() {
        return inEmc;
    }

    /**
     * @param inEmc
     */
    public void setInEmc(Integer inEmc) {
        this.inEmc = inEmc;
    }

    /**
     * @return in_air_density
     */
    public Integer getInAirDensity() {
        return inAirDensity;
    }

    /**
     * @param inAirDensity
     */
    public void setInAirDensity(Integer inAirDensity) {
        this.inAirDensity = inAirDensity;
    }

    /**
     * @return et
     */
    public Integer getEt() {
        return et;
    }

    /**
     * @param et
     */
    public void setEt(Integer et) {
        this.et = et;
    }

    /**
     * @return wind_samp
     */
    public Integer getWindSamp() {
        return windSamp;
    }

    /**
     * @param windSamp
     */
    public void setWindSamp(Integer windSamp) {
        this.windSamp = windSamp;
    }

    /**
     * @return wind_tx
     */
    public Integer getWindTx() {
        return windTx;
    }

    /**
     * @param windTx
     */
    public void setWindTx(Integer windTx) {
        this.windTx = windTx;
    }

    /**
     * @return iss_recept
     */
    public Integer getIssRecept() {
        return issRecept;
    }

    /**
     * @param issRecept
     */
    public void setIssRecept(Integer issRecept) {
        this.issRecept = issRecept;
    }

    /**
     * @return arc_int
     */
    public Integer getArcInt() {
        return arcInt;
    }

    /**
     * @param arcInt
     */
    public void setArcInt(Integer arcInt) {
        this.arcInt = arcInt;
    }

    /**
     * @return outHum
     */
    public Integer getOuthum() {
        return outhum;
    }

    /**
     * @param outhum
     */
    public void setOuthum(Integer outhum) {
        this.outhum = outhum;
    }
}