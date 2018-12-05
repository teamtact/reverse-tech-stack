package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tact.base.mybatis.mapper.CityMapper;

@RestController
@RequestMapping(value = "/bases")
public class BaseController {
	
	@Autowired
    private CityMapper cityMapper;
	
	/**
	 * 
	 * @return
	 * 
	 * Possible urls:
	 * 		http://localhost:1878/bases/
	 */
    @GetMapping(value = "")
    public <T> T testBase() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");
        map.put("seven", "eight");
        
        return (T) map;
    }
    
    
    
    /**
     * 
     * @param state
     * @return
     * 
     * Possible urls:
	 * 		http://localhost:1878/base/city
     * 
     */
    @GetMapping(value = "/city")
    public <T> T getCityByState(
    		@RequestParam(value = "state")String state) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        map.put("state", state);
        map.put("city", cityMapper.findByState(state));
        
        return (T) map;
    }
    
    /**
     * 
     * @param country
     * @return
     * 
     * Possible urls:
	 * 		http://localhost:1878/base/city/by/country
     *
     */
    @GetMapping(value = "/city/by/country")
    public <T> T getCityByCountry(
    @RequestParam(value = "country")String country) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        map.put("country", country);
        map.put("city", cityMapper.findByCountry(country));
        return (T) map;
    }
    /**
     * 
     * @param state
     * @return
     * 
     * Possible urls:
	 * 		http://localhost:1878/base/cities
     */
    @GetMapping(value = "/cities")
    public <T> T getCitiesByState(
    		@RequestParam(value = "state")String state) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        map.put("state", state);
        map.put("cities", cityMapper.findMultipleCitiesByStates(state));
        
        return (T) map;
    }
    
    
    /**
     * 
     * @param country
     * @return
     * 
     * Possible urls:
	 * 		http://localhost:1878/base/cities/by/country
     */
    @GetMapping(value = "/cities/by/country")
    public <T> T getCitiesByCountry(
    		@RequestParam(value = "country")String country) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        map.put("state", country);
        map.put("cities", cityMapper.findMultipleCitiesByStates(country));
        
        return (T) map;
    }
}
