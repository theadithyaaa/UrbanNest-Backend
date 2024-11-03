package edu.icet.service;


import edu.icet.dto.Property;

import java.util.List;

public interface PropertyService {
    List<Property> getAll();
    void addproperty(Property property);
    void deletepropertyById(Integer id);
    Property searchpropertyById(Integer id);
    void updatePropertyById(Property property);
}
