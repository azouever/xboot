package com.process.xboot.jdk8.functionprogram.predicate_demo;
// Java program to demonstrate working of predicates
// on collection. The program finds all admins in an 
// arrayList of users. 

import java.util.function.Predicate;
import java.util.*;

class User {

  String name, role;

  User(String a, String b) {
    name = a;
    role = b;
  }

  String getRole() {
    return role;
  }

  String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "User Name : " + name + ", Role :" + role;
  }

  public static void main(String args[]) {
    List<User> users = new ArrayList<User>();
    users.add(new User("John", "admin"));
    users.add(new User("Peter", "member"));
    List admins = process(users, (User u) -> u.getRole().equals("admin"));
    System.out.println(admins);
  }

  public static List<User> process(List<User> users,
      Predicate<User> predicat) {
    List<User> result = new ArrayList<User>();
    for (User user : users) {
      if (predicat.test(user)) {
        result.add(user);
      }
    }
    return result;
  }
} 
