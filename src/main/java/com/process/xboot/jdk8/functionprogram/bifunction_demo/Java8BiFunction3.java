package com.process.xboot.jdk8.functionprogram.bifunction_demo;

import java.util.function.BiFunction;

public class Java8BiFunction3 {

  public static void main(String[] args) {

    GPS obj = factory("40.741895", "-73.989308", GPS::new);
    System.out.println(obj);

  }

  public static <R extends GPS> R factory(String Latitude, String Longitude,
      BiFunction<String, String, R> func) {
    return func.apply(Latitude, Longitude);
  }

}

class GPS {

  String Latitude;
  String Longitude;

  public GPS(String latitude, String longitude) {
    Latitude = latitude;
    Longitude = longitude;
  }

  public String getLatitude() {
    return Latitude;
  }

  public void setLatitude(String latitude) {
    Latitude = latitude;
  }

  public String getLongitude() {
    return Longitude;
  }

  public void setLongitude(String longitude) {
    Longitude = longitude;
  }

  @Override
  public String toString() {
    return "GPS{" +
        "Latitude='" + Latitude + '\'' +
        ", Longitude='" + Longitude + '\'' +
        '}';
  }
}