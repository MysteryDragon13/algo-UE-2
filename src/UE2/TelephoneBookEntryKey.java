package UE2;

import kapitel_3.tests.Student;
import kapitel_3.vl.IKey;

public class TelephoneBookEntryKey {
    public static class NameKey implements IKey {
        String surName;
        String firstName;
        public NameKey(String firstName,String surName) {
            this.surName = surName;
            this.firstName=firstName;
        }
        public boolean matches(Object data) {
            return(
                surName.equals(((TelephoneBookEntry) data).surName)
                &&
                firstName.equals(((TelephoneBookEntry) data).name)
            );
        }
    }
}
