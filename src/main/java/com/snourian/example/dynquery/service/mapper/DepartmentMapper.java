package com.snourian.example.dynquery.service.mapper;

import com.snourian.example.dynquery.domain.Department;
import com.snourian.example.dynquery.service.dto.DepartmentDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jsr330", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface DepartmentMapper {

    Department toEntity(DepartmentDto dto);

    DepartmentDto toDto(Department entity);
}
