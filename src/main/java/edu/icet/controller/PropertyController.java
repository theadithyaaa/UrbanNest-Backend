package edu.icet.controller;

import edu.icet.dto.Property;
import edu.icet.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/property")
@RequiredArgsConstructor
public class PropertyController {
    @Autowired
    final PropertyService service;

    @GetMapping("/property/get-all")
    public List<Property>getProperty(){
        return service.getAll();
    }

    @PostMapping("/property/add-property")
    @ResponseStatus(HttpStatus.CREATED)
    public void addproperty(@RequestBody Property property){
        service.addproperty(property);
    }

    @GetMapping("/property/search-by-id/{id}")
    public Property getPropertyById(@PathVariable Integer id){
        return service.searchpropertyById(id);
    }

    @DeleteMapping("/property/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePropertyById(@PathVariable Integer id){
        service.deletepropertyById(id);
    }
    @PutMapping("/property/update-property")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProperty(@RequestBody Property property){
        service.updatePropertyById(property);
    }
}
