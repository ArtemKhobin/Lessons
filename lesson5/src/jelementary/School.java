package jelementary;

import java.util.Arrays;

public class School {
  private String name;
  private Group[] groups;

  public School(String name) {
    this.name = name;
  }

  public School(String name, Group[] groups) {
    this(name);
    this.groups = groups;
  }

  public void addGroup(Group newGroup) {
    if (groups == null) {
      groups = new Group[] {newGroup};
      return;
    }
    groups = Arrays.copyOf(groups, groups.length+1);
    groups[groups.length - 1] = newGroup;
  }

  public String toString() {
    String result = "School name: " + name;
    if (groups != null) {
      result += " Groups: ";
      for (int i = 0; i < groups.length; i++) {
        result += groups[i].getName() + " ";
      }
    }
    return result;
  }

}
