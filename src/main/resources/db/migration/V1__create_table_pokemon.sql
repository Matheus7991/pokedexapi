CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE pokemon (
                         id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         type VARCHAR(50) NOT NULL,
                         height INTEGER,
                         weight INTEGER,
                         description TEXT,
                         image_url VARCHAR(255)
);