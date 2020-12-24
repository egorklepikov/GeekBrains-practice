package com.geekbrains.practice;

import java.util.*;

public class PhoneHandbook {
  private final Map<String, List<String>> contacts;

  public PhoneHandbook() {
    contacts = new HashMap<>();
  }

  public void add(String lastName, String phoneNumber) {
    List<String> phone;
    if (contacts.containsKey(lastName)) {
      phone = contacts.get(lastName);
    } else {
      phone = new ArrayList<>();
    }
    phone.add(phoneNumber);
    contacts.put(lastName, phone);
  }

  public List<String> get(String lastName) {
    return contacts.get(lastName);
  }
}
