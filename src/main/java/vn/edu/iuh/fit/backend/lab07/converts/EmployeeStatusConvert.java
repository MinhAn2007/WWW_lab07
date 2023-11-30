package vn.edu.iuh.fit.backend.lab07.converts;

import jakarta.persistence.Converter;
import vn.edu.iuh.fit.backend.lab07.enums.EmployeeStatus;
import jakarta.persistence.AttributeConverter;

@Converter(autoApply = true)
public class EmployeeStatusConvert implements AttributeConverter<EmployeeStatus,Integer> {

    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus attribute) {
        if(attribute==null)
            return null;
        return  attribute.getCode();
    }

    @Override
    public EmployeeStatus convertToEntityAttribute(Integer dbData) {
        if(dbData==null)
            return null;
        return EmployeeStatus.fromcode(dbData);
    }
}