package com.PgManagement.Pg.exception;

public class RentNotFoundException extends RuntimeException {
    public RentNotFoundException(Long id) {
        super("Rent info not found for ID: " + id);
    }
}
