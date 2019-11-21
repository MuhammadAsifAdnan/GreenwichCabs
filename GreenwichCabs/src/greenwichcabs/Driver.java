/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabs;

import java.util.Objects;

/**
 *
 * @author aa
 */
public class Driver {
    private int Id;
    private String FirstName;
    private String LastName;
    private String SSN;

    public Driver(int Id, String FirstName, String LastName, String SSN) {
    this.Id = Id;
    this.FirstName = FirstName;
    this.LastName = LastName;
    this.SSN = SSN;
    }
        
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    @Override
    public String toString() {
        return Id + " - " + FirstName + " " + LastName;
    }
}
