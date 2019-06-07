package com.lambdaschool.gdp.controller;

import com.lambdaschool.gdp.GdpApplication;
import com.lambdaschool.gdp.GdpApplication;
import com.lambdaschool.gdp.GdpList;
import com.lambdaschool.gdp.exception.ResourceNotFoundException;
import com.lambdaschool.gdp.model.GDP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/gdp")
public class GdpController
{
    private static final Logger logger = LoggerFactory.getLogger(GdpController.class);

///names - return using the JSON format all of the countries alphabetized by name
///economy - return using the JSON format all of the countries sorted from most to least GDP
///country/{id} - return using the JSON format a single country and GDP based off of its id number
///country/stats/median - return using the JSON the country and its GDP with the median GDP. For odd number list,
//    return the the country in the middle. For even number list you may return either one of the countries found in the middle.

    @GetMapping(value = "/countries",
            produces = {"application/json"})
    public ResponseEntity<?> findCountries(HttpServletRequest request)
    {
        logger.info(request.getRequestURI() + " accessed");

        GdpApplication.myGdpList.gdpList.sort((g1, g2) -> g1.getCountry().compareToIgnoreCase(g2.getCountry()));


        return new ResponseEntity<>( GdpApplication.myGdpList.gdpList,HttpStatus.OK);

    }

    @GetMapping(value = "/economy")
    public ResponseEntity<?> getByGDP() {
        logger.info("/economy was accessed");


        GdpList rtnEconomyList = GdpApplication.myGdpList;
        rtnEconomyList.gdpList.sort((e1, e2) -> (int) (e2.getEconomy() - e1.getEconomy()));
        return new ResponseEntity<>(rtnEconomyList, HttpStatus.OK);
    }



    @GetMapping(value = "/country/{id}")
    public ResponseEntity<?> getDogDetail(@PathVariable long id)
    {
        logger.info("/country/" + id + " accessed");

        GDP rtnGdp;
        if (GdpApplication.myGdpList.findGdp(g -> (g.getId() == id)) == null)
        {
            throw new ResourceNotFoundException("Country with id " + id + " not found!");
        } else
        {
            rtnGdp = GdpApplication.myGdpList.findGdp(g -> (g.getId() == id));
        }
        return new ResponseEntity<>(rtnGdp, HttpStatus.OK);
    }




}
