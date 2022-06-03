package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    /**
     * this tests deleteMethod
     */
    @Test
    public void testDelete()
    {
        CityList citylist= new CityList();
        City city1= new City("Jashore","Khulna");
        City city2= new City("Jamalpur", "Dhaka");
        citylist.add(city1);
        citylist.add(city2);

        citylist.delete(city1);
        assertTrue(!citylist.getCities(1).contains(city1));
        /*getCities is a method from cityList.java that returns sorted citylist*/

    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * it checks deleteException
     */
    @Test
    public void testDeleteException()
    {
        CityList citylist= new CityList();
        City city1= new City("Jashore","Khulna");
        City city2= new City("Jamalpur", "Dhaka");
        citylist.add(city1);
        citylist.add(city2);

        citylist.delete(city1);
        assertThrows(IllegalArgumentException.class, () -> {
            citylist.delete(city1);
        });
    }

    /**
     * it tests count method
     */
    @Test
    public void testCount()
    {
        CityList citylist1= new CityList();
        City city1= new City("Jashore","Khulna");
        City city2= new City("Jamalpur", "Dhaka");
        citylist1.add(city1);
        citylist1.add(city2);
        assertEquals(2,citylist1.count());
        citylist1.delete(city1);
        assertEquals(1,citylist1.count());
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }

    /**
     * it tests new getcity method
     */
    @Test
    public void testNewGetCities() {
        CityList citylist1 = new CityList();
        City city1= new City("Jashore","A");
        citylist1.add(city1);
        assertEquals(0, city1.compareTo(citylist1.getCities(1).get(0)));

        City city2= new City("Cumilla", "B");
        citylist1.add(city2);
        assertEquals(0, city1.compareTo(citylist1.getCities(1).get(1)));
        assertEquals(0, city2.compareTo(citylist1.getCities(1).get(0)));

        assertEquals(0, city1.compareTo(citylist1.getCities(2).get(0)));
        assertEquals(0, city2.compareTo(citylist1.getCities(2).get(1)));

    }
}
