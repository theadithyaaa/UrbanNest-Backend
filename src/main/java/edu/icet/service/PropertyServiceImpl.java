package edu.icet.service;

import edu.icet.dto.Property;
import edu.icet.entity.CustomerEntity;
import edu.icet.entity.PropertyEntity;
import edu.icet.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService{

    private final PropertyRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Property> getAll() {
        List<Property> propertyArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            propertyArrayList.add(mapper.map(entity, Property.class));
        });
        return propertyArrayList;
    }

    @Override
    public void addproperty(Property property) {
        repository.save(mapper.map(property, PropertyEntity.class));

    }

    @Override
    public void deletepropertyById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Property searchpropertyById(Integer id) {
        return mapper.map(repository.findById(id),Property.class);


    }

    @Override
    public void updatePropertyById(Property property) {
        repository.save(mapper.map(property, PropertyEntity.class));
    }
}
