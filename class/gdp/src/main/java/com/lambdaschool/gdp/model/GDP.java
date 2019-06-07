package com.lambdaschool.gdp.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

public class GDP
{
    private static final Logger logger = LoggerFactory.getLogger(GDP.class);

    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String country;
    private long economy;

    public GDP( String country, long economy)
    {
        this.id = counter.incrementAndGet();
        this.country = country;
        this.economy = economy;

        logger.info("We created an gdp");
        logger.debug("Yes we created a gdp with id " + this.id);
    }

    public GDP(String country, String economy)
    {
        this.id = counter.incrementAndGet();
        this.country = country;
        this.economy = Long.parseLong(economy);
    }

    public GDP(GDP toClone)
    {
        this.id = toClone.getId();
        this.country =toClone.getCountry();
        this.economy =toClone.economy;


    }

    public GDP()
    {
    }

    public long getId()
    {
        return id;
    }



    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public long getEconomy()
    {
        return economy;
    }

    public void setEconomy(int economy)
    {
        this.economy = economy;
    }


    @Override
    public String toString()
    {
        return "GDP{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", economy=" + economy +
                '}';
    }
}
