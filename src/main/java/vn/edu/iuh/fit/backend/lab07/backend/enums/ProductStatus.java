package vn.edu.iuh.fit.backend.lab07.backend.enums;

import lombok.Getter;

@Getter
public enum ProductStatus {
    ACTIVE(1), DEACTIVE(0), DELETE(-1);
    private final int code;

    ProductStatus(int code) {
        this.code = code;
    }

    public static ProductStatus fromcode(int code) {
        for (ProductStatus status : ProductStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid EmployeeStatus code: " + code);
    }
}
