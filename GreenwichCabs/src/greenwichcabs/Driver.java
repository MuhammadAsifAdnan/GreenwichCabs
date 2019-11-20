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
    private String fullName;
    private String SSN;

    public Driver(int Id, String fullName, String SSN) {
        this.Id = Id;
        this.fullName = fullName;
        this.SSN = SSN;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
}
