package br.com.erudio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = -276717165117137620L;

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

}
