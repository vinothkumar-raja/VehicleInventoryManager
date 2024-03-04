CREATE SCHEMA IF NOT EXISTS vehicle;

CREATE TABLE IF NOT EXISTS vehicle.vehicle (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    vehicle_type VARCHAR(255),
    vehicle_model VARCHAR(255),
    vehicle_number VARCHAR(255),
    interior_id BIGINT,
    exterior_id BIGINT,
    color VARCHAR(255),
    color_style VARCHAR(255),
    engine_number BIGINT,
    transmission_number BIGINT
);
