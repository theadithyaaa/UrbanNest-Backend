package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Property {
    private Integer id;
    private String owner;
    private String ownerContact;
    private String location;
    private String district;
    private Double price;
}
