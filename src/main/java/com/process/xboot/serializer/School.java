package com.process.xboot.serializer;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class School {

  private String schoolName;
  private List<Student> students;

  public School(String schoolName, List<Student> students) {
    this.schoolName = schoolName;
    this.students = students;
  }
}

