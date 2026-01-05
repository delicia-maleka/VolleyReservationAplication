CREATE DATABASE IF NOT EXISTS volley_reservation
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_general_ci;

USE volley_reservation;
-- ===========================
-- Table : TERRAIN
-- ===========================
CREATE TABLE TERRAIN (
    id_terrain INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL
);

-- ===========================
-- Table : UTILISATEUR
-- ===========================
CREATE TABLE UTILISATEUR (
    id_utilisateur INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(150) NULL
);

-- ===========================
-- Table : RESERVATION
-- ===========================
CREATE TABLE RESERVATION (
    id_reservation INT PRIMARY KEY AUTO_INCREMENT,
    date_reservation DATE NOT NULL,
    heure_debut TIME NOT NULL,
    heure_fin TIME NOT NULL,
    motif VARCHAR(255) NOT NULL,

    -- FK vers TERRAIN
    terrain_id INT,
    CONSTRAINT fk_reservation_terrain
        FOREIGN KEY (terrain_id)
        REFERENCES TERRAIN(id_terrain)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    -- FK vers UTILISATEUR
    utilisateur_id INT,
    CONSTRAINT fk_reservation_utilisateur
        FOREIGN KEY (utilisateur_id)
        REFERENCES UTILISATEUR(id_utilisateur)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
-- ===========================
-- Index pour les filtres
-- ===========================
CREATE INDEX idx_reservation_date ON RESERVATION(date_reservation);
CREATE INDEX idx_reservation_terrain ON RESERVATION(terrain_id);
CREATE INDEX idx_reservation_user ON RESERVATION(utilisateur_id);
-- ===========================
-- UTILISATEURS
-- ===========================
INSERT INTO UTILISATEUR (nom, prenom, email)  VALUES
('Maleka', 'Delicia', 'Maleka.Delicia@gmail.com'),
('Bernard', 'Lucas', 'lucas.bernard@gmail.com'),
('Rot', 'freud', 'Rot.freud@gmail.com'),
('riri', 'lab', 'riri.lab@gmail.com'),
('dumas', 'suzi', 'dumas.suzi@gmail.com');

-- ===========================
-- TERRAINS
-- ===========================
INSERT INTO TERRAIN (nom, type) VALUES
('Beach 1', 'Beach'),
('Beach 2', 'Beach'),
('Indoor 1', 'Interieur'),
('Indoor 2', 'Interieur');

-- ===========================
-- RESERVATIONS
-- ===========================
INSERT INTO RESERVATION (date_reservation, heure_debut, heure_fin, motif, terrain_id, utilisateur_id) VALUES
('2026-10-01', '10:00:00', '12:00:00', 'Entraînement', 1, 1),
('2026-10-01', '14:00:00', '16:00:00', 'Match', 1, 2),
('2026-10-01', '18:00:00', '20:00:00', 'Match', 1, 1);

