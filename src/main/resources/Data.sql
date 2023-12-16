CREATE TABLE "wheel" (
    "id" integer PRIMARY KEY,
    "wheel_radius" text,
    "manufacture_name" text
);

CREATE TABLE "body" (
    "id" integer PRIMARY KEY,
    "body_type" text,
    "color" text
);

INSERT INTO wheel VALUES
    (1, 'R15', 'Pierelli'),
    (2, 'R16', 'ShiNa Japan'),
    (3, 'R17', 'Turbo Wheels');

INSERT INTO body VALUES
    (1, 'Hatchback', 'Red'),
    (2, 'Sedan', 'Green'),
    (3, 'Offroad', 'Ocean Red');